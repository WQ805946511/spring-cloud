package com.example.security.test;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test {


    private static final String TEST_STRING = "0123456789，0123456789，0123456789，0123456789，0123456789，0123456789，0123456789";

    public static void main(String[] args) {
        String base64Result = Base64.getEncoder().encodeToString(TEST_STRING.getBytes());
        System.out.println(base64Result);

        String base64Result2 = Base64.getEncoder().encodeToString("2fd929784a3c415faa21b9092b13634f".getBytes());
        System.out.println(base64Result2);

        String aa = "UzE4MDcwOTA2NDAxMjE6YzQyM2IzMGFmNzdmNDJhMzhlNGY5MmRlYWM1YjEyMGY=";
        String s = decodeToken(aa);
        System.out.println(s);


        String s1 = resolveToken("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5el91c2VyIiwiYXV0aCI6IlJPTEVfU1VCX0VOVEVSUFJJU0VfQURNSU4iLCJvcmciOiJTMTgwNzA5MDY0MDEyMSIsImV4cCI6MTY0MzA5NjY2Nn0.nNKLe2odF4CqtsOY6WWj4EQvqoxtCWv4FniLDFjBu5nqf2FRG7YIQt3VzZLT-T8tsUUbH7_sGwdRXRvOlm_ntA");
        System.out.println(s1);
    }

    private static String resolveToken(String request) {
        if (StringUtils.hasText(request) && request.startsWith("Bearer ")) {
            return request.substring(7);
        }
        return null;
    }

    public static String createToken(String orgId, String sid) {
        return Base64Utils.encodeToString(String.join(":", orgId, sid).getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeToken(String token) {
        return new String(Base64Utils.decodeFromString(token), StandardCharsets.UTF_8);
    }

   /* public static void main(String args[]) throws IOException {
        byte b[] = fileToByte("C:\\Users\\WangQing\\Desktop\\111.txt");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }*/


    public static byte[] fileToByte(String filepath) throws IOException {
        byte[] bytes = null;
        FileInputStream fis = null;
        try {
            File file = new File(filepath);
            fis = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fis.close();
        }
        return bytes;
    }
}
