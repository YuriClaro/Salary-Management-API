package com.humanit.salary_api.exception.salary;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static com.humanit.salary_api.exception.ErrorEnum.SALARY_NOT_FOUND;

@Getter
public class SalaryByIdNotFoundException extends Exception {
    private final String message;
    private final String code;
    private final HttpStatus status;

    public SalaryByIdNotFoundException(UUID id) {
        super(SALARY_NOT_FOUND.getMessage(id));
        this.message = SALARY_NOT_FOUND.getMessage(id);
        this.code = SALARY_NOT_FOUND.getCode();
        this.status = SALARY_NOT_FOUND.getStatus();
    }
}