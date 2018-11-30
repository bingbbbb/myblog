package com.bing.myblog.util;

import java.util.Random;

public class GenerateSalt {
    static public String generateSalt(int saltLength){
        StringBuffer salt = new StringBuffer();
        String constantString = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random rd = new Random();
        for(int i=0;i<saltLength;i++){
            salt.append(constantString.charAt(rd.nextInt(62)));
        }
        return salt.toString();
    }
}
