package com.tonnyseko.servlet.app.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashText {
    public String hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return new String(md.digest());
    }
}
