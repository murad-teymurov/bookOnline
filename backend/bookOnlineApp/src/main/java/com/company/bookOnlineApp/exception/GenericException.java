package com.company.bookOnlineApp.exception;

import com.company.bookOnlineApp.dto.enums.ErrorCode;
import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GenericException extends Throwable { // why Throwable ?
    private HttpStatus httpStatus;
    private ErrorCode errorCode;

}
