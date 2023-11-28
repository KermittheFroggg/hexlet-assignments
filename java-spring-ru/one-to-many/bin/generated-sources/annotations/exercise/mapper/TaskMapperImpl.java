package exercise.mapper;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.model.Task;
import exercise.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T19:08:35+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl extends TaskMapper {

    @Override
    public Task map(TaskCreateDTO taskCreateDTO) {
        if ( taskCreateDTO == null ) {
            return null;
        }

        Task task = new Task();

        task.setDescription( taskCreateDTO.getDescription() );
        task.setTitle( taskCreateDTO.getTitle() );

        return task;
    }

    @Override
    public void updateTaskFromDto(TaskUpdateDTO taskUpdateDTO, Task task) {
        if ( taskUpdateDTO == null ) {
            return;
        }

        if ( taskUpdateDTO.getDescription() != null ) {
            task.setDescription( taskUpdateDTO.getDescription() );
        }
        if ( taskUpdateDTO.getTitle() != null ) {
            task.setTitle( taskUpdateDTO.getTitle() );
        }
    }

    @Override
    public TaskDTO map(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setAssigneeId( taskAssigneeId( task ) );
        taskDTO.setCreatedAt( task.getCreatedAt() );
        taskDTO.setDescription( task.getDescription() );
        taskDTO.setId( task.getId() );
        taskDTO.setTitle( task.getTitle() );
        taskDTO.setUpdatedAt( task.getUpdatedAt() );

        return taskDTO;
    }

    private Long taskAssigneeId(Task task) {
        if ( task == null ) {
            return null;
        }
        User assignee = task.getAssignee();
        if ( assignee == null ) {
            return null;
        }
        long id = assignee.getId();
        return id;
    }
}
