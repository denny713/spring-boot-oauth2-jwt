package com.oauth.test.data.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenRes implements Serializable {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String scope;
    private String jti;
}
