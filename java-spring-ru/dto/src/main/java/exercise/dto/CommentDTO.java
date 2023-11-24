package exercise.dto;

import exercise.model.Comment;

import java.util.List;

// BEGIN
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// BEGIN
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private long id;
    private String body;

}
// END
