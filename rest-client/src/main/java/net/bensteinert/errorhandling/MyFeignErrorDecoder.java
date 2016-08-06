package net.bensteinert.errorhandling;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author bensteinert
 */
@Component
public class MyFeignErrorDecoder extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.CONFLICT.value()) {
            return new DuplicateDocumentExecption();
        }
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new MissingDocumentExecption();
        }
        return super.decode(methodKey, response);
    }

}
