package com.xiafish;


public class BCryptPasswordEncoder {

    public static void main(String[] args) {
        passwordEncode("1");
    }

    public static void passwordEncode(String password)
    {
        // 使用BCryptPasswordEncoder进行密码加密
        org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        System.out.println(encryptedPassword);
    }
}
