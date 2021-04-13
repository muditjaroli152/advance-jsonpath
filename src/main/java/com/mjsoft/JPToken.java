package com.mjsoft;

import com.mjsoft.token.TokenType;

public class JPToken {
    TokenType tokenType;
    String fragment;

    public JPToken(TokenType tokenType, String fragment) {
        this.tokenType = tokenType;
        this.fragment = fragment;
    }

    public JPToken(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }
}
