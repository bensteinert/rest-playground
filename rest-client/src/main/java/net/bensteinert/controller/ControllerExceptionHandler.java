package net.bensteinert.controller;

import net.bensteinert.errorhandling.DuplicateDocumentExecption;
import net.bensteinert.errorhandling.MissingDocumentExecption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bensteinert
 */
@ControllerAdvice(basePackageClasses = {ControllerExceptionHandler.class})
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = {MissingDocumentExecption.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleMissing(){
        logger.error("Caught DuplicateDocumentException. Returning 404.");
    }

    @ExceptionHandler(value = {DuplicateDocumentExecption.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDuplicates(){
        logger.error("Caught DuplicateDocumentException. Returning 409.");
    }

}
