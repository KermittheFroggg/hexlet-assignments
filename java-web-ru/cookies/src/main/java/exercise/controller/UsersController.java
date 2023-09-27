package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import java.util.Collections;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        if (user.getToken().equals(ctx.cookie("token"))) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }

    public static void create(Context ctx) throws Exception {
        String firstName = ctx.formParamAsClass("firstName", String.class).get();
        String lastName = ctx.formParamAsClass("lastName", String.class).get();
        String email = ctx.formParamAsClass("email", String.class).get();
        String password = ctx.formParamAsClass("password", String.class).get();
        String token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);

        UserRepository.save(user);
        long id = user.getId();
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(id));
    }
}
