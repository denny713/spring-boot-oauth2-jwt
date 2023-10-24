package com.oauth.test.service;

import com.oauth.test.data.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ClientDetailsService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return tokenRepository.findByClient(s);
    }
}
