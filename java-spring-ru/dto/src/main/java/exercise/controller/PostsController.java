package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        var comments = commentRepository.findByPostId(id);
        List<CommentDTO> commentDTOs = comments.stream()
            .map(comment -> new CommentDTO(comment.getId(), comment.getBody()))
            .collect(Collectors.toList());

        return new PostDTO(post.getId(), post.getTitle(),post.getBody(), commentDTOs);
    }
}
// END
