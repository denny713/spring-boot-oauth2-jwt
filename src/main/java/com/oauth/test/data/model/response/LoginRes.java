package com.oauth.test.data.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginRes implements Serializable {

    private String username;
    private String nama;
    private TokenRes token;
}
