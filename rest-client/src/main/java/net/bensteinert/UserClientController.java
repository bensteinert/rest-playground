package net.bensteinert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bensteinert
 */
@RestController
@RequestMapping("/api")
public class UserClientController {

    private final UserService userService;

    @Autowired
    public UserClientController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return new ArrayList<>(userService.users().getContent());
    }
}
