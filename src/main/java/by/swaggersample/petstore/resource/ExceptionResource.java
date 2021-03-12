package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.resource.dto.ApiResponse;
import by.swaggersample.petstore.resource.exception.AccessException;
import by.swaggersample.petstore.resource.exception.LoginException;
import by.swaggersample.petstore.service.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionResource {

    @ExceptionHandler(UserNotFoundException.class)
    public ApiResponse userNotFound(UserNotFoundException e) {
        log.trace("method userNotFound has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(UserIsAlreadyExistException.class)
    public ApiResponse userIsAlreadyExist(UserIsAlreadyExistException e) {
        log.trace("method userIsAlreadyExist has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(InvalidIdSuppliedException.class)
    public ApiResponse invalidIdSupplied(InvalidIdSuppliedException e) {
        log.trace("method invalidIdSupplied has started " + e.getMessage());
        return new ApiResponse(400, e.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ApiResponse orderNotFound(OrderNotFoundException e) {
        log.trace("method orderNotFound has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ApiResponse petNotFound(PetNotFoundException e) {
        log.trace("method petNotFound has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ApiResponse categoryNotFound(CategoryNotFoundException e) {
        log.trace("method categoryNotFound has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(TagNotFoundException.class)
    public ApiResponse tagNotFound(TagNotFoundException e) {
        log.trace("method tagNotFound has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(LoginException.class)
    public ApiResponse loginOrPasswordNotCorrect(LoginException e) {
        log.trace("method loginOrPasswordNotCorrect has started " + e.getMessage());
        return new ApiResponse(404, e.getMessage());
    }

    @ExceptionHandler(AccessException.class)
    public ApiResponse accessException(AccessException e) {
        log.trace("method accessException has started " + e.getMessage());
        return new ApiResponse(403, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> accessException(MethodArgumentNotValidException e) {
        log.trace("method accessException has started " + e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> message = new HashMap<>();
        message.put("code", "400");
        message.put("message", "Validation problems");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return message;
    }
}
