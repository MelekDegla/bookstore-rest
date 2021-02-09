package tn.esprit.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The type Resource not found exception.

 */
@ResponseStatus(value = HttpStatus.OK)
public class ResourceAlreadyExistsException extends Exception {

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}
