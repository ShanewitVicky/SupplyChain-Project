package com.example.shane.Utility;

/**
 * Created by Shane on 08-Jul-18.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Decoder.BASE64Encoder;

public class EncryptInput {

    private static String SALT="akjbehg3247dfdshga";
    MessageDigest sha;
    //EncryptInput input=new EncryptInput();

   //Hashes the password and returns the Hashed password as String
    public String hashPwd(String password) {
        String saltedpassword=SALT+password;
        String hashedpassword=generateHash(saltedpassword);

        return hashedpassword;



    }
   // Generates the Hash for the password entered
    public synchronized String generateHash(String input) {
        String hash =null;

        try {
            sha = MessageDigest.getInstance("SHA-1");
            sha.update(input.getBytes("UTF-8"));
            byte rawbyte[]=sha.digest();
            hash=(new BASE64Encoder()).encode(rawbyte);

        }catch(UnsupportedEncodingException e) {

        }
        catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        return hash;
    }



}