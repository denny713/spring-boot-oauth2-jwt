package com.oauth.test.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            return encrypt(rawPassword.toString());
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.encode(rawPassword.toString()).equals(encodedPassword);
    }

    public static String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = digest.digest();
        StringBuilder str = new StringBuilder();
        for (byte byt : bytes) {
            str.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return str.toString();
    }
}
