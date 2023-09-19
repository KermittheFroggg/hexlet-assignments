package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Collections;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });
        app.post("/users", ctx -> {
            var firstName = ctx.formParam("firstName");
            firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);

            var lastName = ctx.formParam("lastName");
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);

            var email = ctx.formParam("email").trim().toLowerCase();
            var password = Security.encrypt(ctx.formParam("password"));
            var user = new User(firstName, lastName, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
