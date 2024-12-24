/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.blacksilicon.rsa.encrypt;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import com.blacksilicon.rsa.encrypt.NettEncrypt;
import com.blacksilicon.rsa.encrypt.NettDecrypt;
import com.google.gson.Gson;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mubarakanifowose
 */
public class NewMain {

    private static String publicKey = "-----BEGIN PUBLIC KEY-----"
            + "-----END PUBLIC KEY-----";
    private static String privateKey = "-----BEGIN PRIVATE KEY-----\n" +"-----END PRIVATE KEY-----";

    public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, GeneralSecurityException {

        Map<String, String> cardHash = new HashMap<>();

        cardHash.put("card_number", "5204730000002449");
        cardHash.put("cvv", "244");
        cardHash.put("email", "bellotobiloba01@gmail.com");
        cardHash.put("expMonth", "12");
        cardHash.put("expYear", "25");
        cardHash.put("fullname", "Thrillee");
        cardHash.put("pin", "12345");

         NettCardPojo cardPojo = NettDecrypt.decrypted("G6u+/PswaCa66N5Q/ysOGm05KE4KwmHoIKzC/76E8v+QUVYh3z3m+JpPsjYwK9azfmj7zGphbtIes1/kdj/zlHBhhKCc2FN6+tp/c8s5+Am3TXinbO5yB6t2NAuUGYNTxwdL8Nh4IvkXLZ9f0PeOWzzPyTtNdP7ZQc1aBWHO4kbO/l4Pei5CEDdSDiEPKUFhgINV9GGk5OLeGUQ8N1xaFp0lKwKVk87icI/DhtvqpPQv6zpZ+3HkvekBX8KPTblW2mYPE/66ItqlU54QQUzwyMB3lI7qHbtQSP4OF8JYLC5wtvUqfmAFqpVMMd8fcdl8QWQvLFO8PQhcCL5YVVRJtQ==", privateKey);

System.out.println(cardPojo.getCard_number());
System.out.println(cardPojo.getCvv());
System.out.println(cardPojo.getExpMonth());
System.out.println(cardPojo.getPin());
System.out.println(cardPojo.getExpYear());

    }
}
