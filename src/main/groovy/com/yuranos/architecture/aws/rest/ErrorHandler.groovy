package com.yuranos.architecture.aws.rest

import groovy.json.JsonBuilder
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import javax.servlet.http.HttpServletRequest
/**
 * Created by yuranos on 9/20/17.
 */
@RestControllerAdvice
@Newify(JsonBuilder)
class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
//            throw e
        def errorResponse = JsonBuilder()
        errorResponse.error {
            description "There was an internal server error. Please do not repeat the same operation and try to call a call centre instead"
            code 500
            errorMessage e.message
        }
        errorResponse.toPrettyString()
    }
}
