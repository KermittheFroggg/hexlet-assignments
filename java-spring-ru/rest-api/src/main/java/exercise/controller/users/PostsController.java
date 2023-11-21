package exercise.controller.users;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> index(@RequestParam(defaultValue = "10") Integer limit,
                            @RequestParam(defaultValue = "1") Integer pageNumber,
                            @PathVariable String id) {
        return posts.stream()
                .filter(p -> String.valueOf(p.getUserId()).equals(id))
                .skip((pageNumber - 1) * limit)
                .limit(limit).toList();
    }
    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable String id, @RequestBody Post post) {
       post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return post;
    }
}
// END
