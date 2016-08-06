package net.bensteinert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bensteinert
 */
@SpringBootApplication
@Controller
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class WebClientMain {

    @RequestMapping(value = "api/alive", method = RequestMethod.GET)
    @ResponseBody
    String healthCheck() {
        return "OK";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebClientMain.class, args);
    }
}
