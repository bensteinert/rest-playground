package net.bensteinert;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("http://userService")
interface UserService {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    PagedResources<User> users();
}