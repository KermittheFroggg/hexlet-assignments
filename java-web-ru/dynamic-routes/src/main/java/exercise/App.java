package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            int companyId = ctx.pathParamAsClass("id", Integer.class).get();
            Map<String, String> company = new HashMap<>();
            for (int i = 0; i < COMPANIES.size(); i++) {
                for (Map.Entry entry : COMPANIES.get(i).entrySet()) {
                    System.out.println(entry.getKey());
                    if (entry.getKey().equals("id") && entry.getValue().equals(String.valueOf(companyId))) {
                        company = COMPANIES.get(i);
                    }
                }
            }
            if (!company.isEmpty()) {
                ctx.json(company);
            } else {
                throw new NotFoundResponse("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
