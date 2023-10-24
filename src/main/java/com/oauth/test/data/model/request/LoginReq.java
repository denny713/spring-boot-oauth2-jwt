package com.oauth.test.data.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginReq implements Serializable {

    private String username;
    private String password;
}
