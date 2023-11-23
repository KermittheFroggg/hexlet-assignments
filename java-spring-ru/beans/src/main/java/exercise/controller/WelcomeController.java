package exercise.controller;

import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN

@RestController
public class WelcomeController {

    @Autowired
    private Daytime getDaytime;

    @GetMapping("/welcome")
    public String welcome() {
        String response = "It is " + getDaytime.getName() + " now! Welcome to Spring!";
        return response;
    }
}
// END
