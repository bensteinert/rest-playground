package net.bensteinert.service;

import net.bensteinert.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("http://userService")
public interface HalUserService {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    PagedResources<User> findAllUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    Resource<User> findUser(@PathVariable("userId") String userId);

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = "application/json")
    void saveNewUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}", consumes = "application/json")
    Resource<User> updateUser(@PathVariable("userId") String userId, User user);

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}", consumes = "application/json")
    Resource<User> deleteUser(@PathVariable("userId") String userId);

}