package br.com.fujideia.iesp.tecback.handler;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    // Handler para exceções específicas
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>(); // Armazena os detalhes da resposta de erro
        body.put("timestamp", LocalDateTime.now()); // Adiciona o horario atual da resposta
        body.put("message", ex.getMessage()); // Adiciona a mensagem

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
