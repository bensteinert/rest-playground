package net.bensteinert;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@EnableMongoRepositories
public class BootMain {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String root() {
        return "<html><body><a href=\"/profile/users\">Spring Data REST Profile</a></</body></html>";
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseBody
    String healthCheck() {
        return "OK";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootMain.class, args);
    }
}
