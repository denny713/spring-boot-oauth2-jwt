package com.oauth.test.data.entity;

import lombok.Data;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@Table(name = "tokens")
public class Token implements ClientDetails {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "client")
    private String client;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "grant_types")
    private String grantTypes;

    @Column(name = "access_valid")
    private Integer accessValid;

    @Column(name = "refresh_valid")
    private Integer refreshValid;

    @Column(name = "url")
    private String url;

    @Column(name = "scopes")
    private String scopes;

    @Column(name = "secret")
    private String secret;

    @Column(name = "is_scope")
    private Boolean isScope;

    @Column(name = "is_secret")
    private Boolean isSecret;

    @Column(name = "resources")
    private String resources;

    @Override
    public String getClientId() {
        return null;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return null;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
