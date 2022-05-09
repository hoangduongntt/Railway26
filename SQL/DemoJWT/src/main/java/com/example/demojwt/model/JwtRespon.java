package com.example.demojwt.model;

public class JwtRespon {
    private String jwtToken;

    public JwtRespon(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
