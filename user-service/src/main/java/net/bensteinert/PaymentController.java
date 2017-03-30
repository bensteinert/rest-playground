package net.bensteinert;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bensteinert
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String submitTransaction() {
        return "OK";
    }
}
