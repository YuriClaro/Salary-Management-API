package com.humanit.portal_api.exceptions.salaryApi;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static com.humanit.portal_api.exceptions.ErrorEnum.SALARY_COMPONENT_NOT_FOUND;

@Getter
public class SalaryComponentByIdNotFoundException extends Exception {
    private final String message;
    private final String code;
    private final HttpStatus status;

    public SalaryComponentByIdNotFoundException(UUID id) {
        super(SALARY_COMPONENT_NOT_FOUND.getMessage(id));
        this.message = SALARY_COMPONENT_NOT_FOUND.getMessage(id);
        this.code = SALARY_COMPONENT_NOT_FOUND.getCode();
        this.status = SALARY_COMPONENT_NOT_FOUND.getStatus();
    }
}