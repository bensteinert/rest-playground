package net.bensteinert.controller;

import net.bensteinert.model.User;
import net.bensteinert.service.HalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bensteinert
 */
@RestController
@RequestMapping("/api")
public class UserClientController {

    private final HalUserService userService;


    @Autowired
    public UserClientController(HalUserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId) {
        return userService.findUser(userId).getContent();
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return new ArrayList<>(userService.findAllUsers().getContent());
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable("userId") String userId) {
        userService.updateUser(userId, user);
    }


    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void updateUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }
}
