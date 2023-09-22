package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {
    private static final List<Post> POSTS = PostRepository.getEntities();

    public static void index(Context ctx) {
        int numberOfPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        List<Post> posts = POSTS.subList((numberOfPage - 1) * 5, numberOfPage * 5);
        var page = new PostsPage(posts, numberOfPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        Long postId = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(postId)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
