package exercise.controller;

import exercise.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

import exercise.repository.UserRepository;
import exercise.dto.UserDTO;
import exercise.dto.UserCreateDTO;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "")
    public List<UserDTO> index() {
        var users = userRepository.findAll();
        return users.stream()
                .map(p -> userMapper.map(p))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public UserDTO show(@PathVariable long id) {

        var user =  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        var userDto = userMapper.map(user);
        return userDto;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO userData) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n!!!!!!!!!!!!!!!!!!!!");
        System.out.println(userData.getEmail());
        System.out.println(userData.getName());
        System.out.println(userData.getPasswordDigest());
        var user = userMapper.map(userData);
        System.out.println("\n\n\n\n\n\n\n\n\n\n???????????????");
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        System.out.println(user.getPasswordDigest());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        userRepository.save(user);
        var userDto = userMapper.map(user);
        return userDto;
    }
}
