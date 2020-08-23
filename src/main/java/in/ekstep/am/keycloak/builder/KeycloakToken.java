package in.ekstep.am.keycloak.builder;

public interface KeycloakToken {
    void setAccess_token(String access_token);
    void setExpires_in(String expires_in);
    void setRefresh_expires_in(String refresh_expires_in);
    void setRefresh_token(String refresh_token);
    void setToken_type(String token_type);
    void setNot_before_policy(String not_before_policy);
    void setSession_state(String session_state);
    void markFailure(String error, String errmsg);
    void markSuccess();
}
