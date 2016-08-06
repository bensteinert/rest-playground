package net.bensteinert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableMongoRepositories
@Controller
public class BootMain {

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseBody
    String healthCheck() {
        return "OK";
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.failOnUnknownProperties(false); // be more graceful with yet unknown fields
        return builder;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootMain.class, args);
    }
}
