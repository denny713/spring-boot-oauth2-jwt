package com.oauth.test.data.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Data
@Entity
@Table(name = "tokens")
public class Token implements ClientDetails {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "authorities", length = 100)
    private String authorities;

    @Column(name = "client", length = 50)
    private String client;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "grant_types", length = 50)
    private String grantTypes;

    @Column(name = "access_valid")
    private Integer accessValid;

    @Column(name = "refresh_valid")
    private Integer refreshValid;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "scopes", length = 100)
    private String scopes;

    @Column(name = "secret", length = 100)
    private String secret;

    @Column(name = "is_scope")
    private Boolean isScope;

    @Column(name = "is_secret")
    private Boolean isSecret;

    @Column(name = "resources", length = 100)
    private String resources;

    @Override
    public String getClientId() {
        return client;
    }

    @Override
    public Set<String> getResourceIds() {
        Set<String> res = new HashSet<>();
        res.add(resources);
        return res;
    }

    @Override
    public boolean isSecretRequired() {
        return isSecret;
    }

    @Override
    public String getClientSecret() {
        return secret;
    }

    @Override
    public boolean isScoped() {
        return isScope;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList(scopes.split(",")));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grants = new HashSet<>();
        String[] strs = authorities.split(",");
        for (String atr : strs) {
            grants.add(new SimpleGrantedAuthority(atr));
        }
        return grants;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList(grantTypes.split(",")));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return url != null ? new HashSet<>(Arrays.asList(url.split(","))) : new HashSet<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessValid;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshValid;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return approved;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Collections.emptyMap();
    }
}
