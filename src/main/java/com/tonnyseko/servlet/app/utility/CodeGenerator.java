package com.tonnyseko.servlet.app.utility;

public class CodeGenerator {
    // generate a random code of length 5 from the characters A-Z, 0-9 and store it
    // in the code field of the Reservation object
    public static String generateCode() {
        String code = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * chars.length());
            code += chars.charAt(index);
        }
        return code;
    }
}
