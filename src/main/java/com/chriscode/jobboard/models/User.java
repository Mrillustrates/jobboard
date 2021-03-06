package com.chriscode.jobboard.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private String username;
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {

        super();

        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        this.username = username;
        this.pwHash = hashPassword(password);

    }

    @NotNull
    @Column(name = "pwhash")
    public String getPwHash() {
        return pwHash;
    }

    @SuppressWarnings("unused")
    private void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    @NotNull
    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    @SuppressWarnings("unused")
    private void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public static boolean isValidPassword(String password) {
        Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
        Matcher matcher = validUsernamePattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidUsername(String username) {
        Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
        Matcher matcher = validUsernamePattern.matcher(username);
        return matcher.matches();
    }

}
