package com.example.demo.exception;

import com.example.demo.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApiException(ApiException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        
        // Determine status based on keywords for completeness
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (ex.getMessage().contains("not found") || ex.getMessage().contains("missing")) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "An unexpected error occurred");
        
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.time.LocalDateTime;
// import java.util.LinkedHashMap;
// import java.util.Map;
// import java.util.stream.Collectors;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ApiException.class)
//     public ResponseEntity<Map<String, Object>> handleApiException(ApiException ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
//         body.put("message", ex.getMessage());
        
//         HttpStatus status = HttpStatus.BAD_REQUEST;
//         if (ex.getMessage().contains("not found") || ex.getMessage().contains("missing")) {
//             status = HttpStatus.NOT_FOUND;
//         }

//         return new ResponseEntity<>(body, status);
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
        
//         String errorMessage = ex.getBindingResult()
//                 .getFieldErrors()
//                 .stream()
//                 .map(error -> error.getDefaultMessage())
//                 .collect(Collectors.joining(", "));
        
//         body.put("message", errorMessage);
        
//         return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
//         body.put("message", "An unexpected error occurred");
        
//         return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.time.LocalDateTime;
// import java.util.LinkedHashMap;
// import java.util.Map;
// import java.util.stream.Collectors;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ApiException.class)
//     public ResponseEntity<Map<String, Object>> handleApiException(ApiException ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
//         body.put("message", ex.getMessage());
        
//         HttpStatus status = HttpStatus.BAD_REQUEST;
//         if (ex.getMessage().contains("not found")) {
//             status = HttpStatus.NOT_FOUND;
//         }
//         return new ResponseEntity<>(body, status);
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
        
//         // This extracts the real error from your @NotBlank/@NotNull annotations
//         String errors = ex.getBindingResult()
//                 .getFieldErrors()
//                 .stream()
//                 .map(error -> error.getDefaultMessage())
//                 .collect(Collectors.joining(", "));
        
//         body.put("message", errors);
//         return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
//         Map<String, Object> body = new LinkedHashMap<>();
//         body.put("timestamp", LocalDateTime.now());
//         // For now, let's show the real error message so you can debug
//         body.put("message", ex.getMessage()); 
        
//         return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }