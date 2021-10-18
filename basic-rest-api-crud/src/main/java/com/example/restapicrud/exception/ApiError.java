package com.example.restapicrud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
class ApiError {
    private Integer errorCode;
    private String errorDesc;
    private Date date;

}
