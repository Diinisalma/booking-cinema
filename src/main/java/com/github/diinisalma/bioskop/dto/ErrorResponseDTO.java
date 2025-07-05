package com.github.diinisalma.bioskop.dto;

import com.github.diinisalma.bioskop.enums.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6353415404729703034L;

    private Date timestamp;
    private String message;
    private ErrorCode errorCode;
    private List<String> details;
    private HttpStatus status;

    public static ErrorResponseDTO of(ErrorCode errorCode, String message, HttpStatus status, List<String> details) {
        return new ErrorResponseDTO(status, message, errorCode, details);
    }

    public ErrorResponseDTO(HttpStatus status, String message, ErrorCode errorCode, List<String> details) {
        super();
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.timestamp = new Date();
    }
}
