package com.oauth.test.service;

import com.oauth.test.data.model.request.LoginReq;
import com.oauth.test.data.model.response.TokenRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.util.*;

@Service
public class AuthService {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    public TokenRes generateToken(LoginReq dto) throws HttpRequestMethodNotSupportedException {
        Map<String, String> param = new HashMap<>();
        param.put("grant_type", "password");
        param.put("username", dto.getUsername());
        param.put("password", dto.getPassword());
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        auth.add(new SimpleGrantedAuthority("ROLE_TRUSTED_CLIENT"));
        User principal = new User("test-auth", "b@ck0ff1ce", true, true, true, true, auth);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, "b@ck0ff1ce", auth);
        ResponseEntity<OAuth2AccessToken> token = tokenEndpoint.postAccessToken(authToken, param);
        if (token.getBody() == null) {
            return null;
        } else {
            StringBuilder scopes = new StringBuilder();
            Objects.requireNonNull(token.getBody()).getScope().forEach(str -> scopes.append(str).append(" "));
            return new TokenRes(
                    token.getBody().getValue(),
                    token.getBody().getRefreshToken().getValue(),
                    token.getBody().getTokenType(),
                    scopes.substring(0, scopes.toString().length() - 1),
                    token.getBody().getAdditionalInformation().get("jti").toString()
            );
        }
    }
}
