package tn.esprit.bookstore.entities.utils;

public class OAuthToken {

    private String tokenName;

    public OAuthToken(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }
}
