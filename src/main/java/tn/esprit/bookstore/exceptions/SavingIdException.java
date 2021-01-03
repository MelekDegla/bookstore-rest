package tn.esprit.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "id provided")
public class SavingIdException extends ResponseStatusException {


    public SavingIdException(HttpStatus status, String msg) {
        super(status, msg );


    }
}
