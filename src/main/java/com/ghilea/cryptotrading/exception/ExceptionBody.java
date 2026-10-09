package com.ghilea.cryptotrading.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Structured HTTP response body returned for API exceptions.
 *
 * @author Dan Lucian Ghilea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionBody {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private int status;
    private String error;
    private String message;
    private String path;
}
