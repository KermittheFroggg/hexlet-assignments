package exercise.dto;

import java.util.List;

import exercise.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// BEGIN
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;


}
// END
