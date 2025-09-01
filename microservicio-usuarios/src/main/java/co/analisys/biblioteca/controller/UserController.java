package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.Email;
import co.analisys.biblioteca.model.User;
import co.analisys.biblioteca.model.UserId;
import co.analisys.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(new UserId(id));
    }

    @PutMapping("/{id}/email")
    public void changeEmail(@PathVariable String id, @RequestBody String newEmail) {
        userService.changeUserEmail(new UserId(id), new Email(newEmail));
    }
}
