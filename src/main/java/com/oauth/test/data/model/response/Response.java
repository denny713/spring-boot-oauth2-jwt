package com.oauth.test.data.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response<T> implements Serializable {

    private int code;
    private String message;
    private T data;
}
