package my.task.SpringHTMLJS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.task.SpringHTMLJS.model.User;
import my.task.SpringHTMLJS.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/restuser")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userpage")
    public User oneUser(Principal principal) {
        return userService.findByUsername(principal.getName());
    }
}
