package exercise.controller;

import java.security.Security;
import java.util.Collections;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        String warning = "Wrong username or password";

        User user = UsersRepository.findByName(name);
        if (user != null) {
            if (user.getPassword().equals(encrypt(password))) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect(NamedRoutes.rootPath());
            }else {
                LoginPage page = new LoginPage(name, warning);
                ctx.render("build.jte", Collections.singletonMap("page", page));
            }
        } else {
            LoginPage page = new LoginPage(name, warning);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
}
