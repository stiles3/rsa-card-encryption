/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blacksilicon.rsa.encrypt;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author mubarakanifowose
 */
public class NettDecrypt extends CommonAbstract {

    public static PrivateKey getPrivateKey(String base64PrivateKey) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static RSAPrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
        String privateKeyPEM = key;
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        privateKeyPEM = privateKeyPEM.replaceAll("\\s", "");
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        System.out.println(keySpec);
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
        return privKey;
    }

    public static String getPrivateKeyString(String filename) throws IOException {
        return getKey(filename);
    }

    public static RSAPrivateKey getPrivateKeyPem(String filename) throws InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        String privateKeyPem = getKey(filename);

        privateKeyPem = privateKeyPem.replace("-----BEGIN PRIVATE KEY-----", "");
        privateKeyPem = privateKeyPem.replace("-----END PRIVATE KEY-----", "");
        privateKeyPem = privateKeyPem.replaceAll("\\s", "");
        System.out.println(privateKeyPem);
        byte[] encoded = Base64.getDecoder().decode(privateKeyPem);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
        return privKey;

    }

    public static RSAPrivateKey getPrivateKey2(String filename) throws IOException, GeneralSecurityException {
        String privateKeyPEM = getKey(filename);
        return getPrivateKeyFromString(privateKeyPEM);
    }

    public static RSAPrivateKey getPrivateKey3(String priKey) throws IOException, GeneralSecurityException {
        String privateKeyPEM = priKey;
        return getPrivateKeyFromString(privateKeyPEM);
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

    public static NettCardPojo decrypted(String data, String priKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException, GeneralSecurityException {

        String decrypted = decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey3(priKey));
        decrypted = decrypted.replace("{", "");
        decrypted = decrypted.replace("}", "");

        String list[] = decrypted.split(",");

        NettCardPojo cardPojo = new NettCardPojo();

        for (String val : list) {

            if (val.contains("cvv")) {
                val = val.replace("cvv=", "");
                cardPojo.setCvv(val);
            } else if (val.contains("card_number")) {
                val = val.replace("card_number=", "");
                cardPojo.setCard_number(val);
            } else if (val.contains("pin")) {
                val = val.replace("pin=", "");
                cardPojo.setPin(val);
            } else if (val.contains("expMonth")) {
                val = val.replace("expMonth=", "");
                cardPojo.setExpMonth(val);
            } else if (val.contains("expYear")) {
                val = val.replace("expYear=", "");
                cardPojo.setExpYear(val);
            } else if (val.contains("email")) {
                val = val.replace("email=", "");
                cardPojo.setEmail(val);
            }

        }
        return cardPojo;
    }

    public static NettBankPojo decrypted2(String data, String priKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException, GeneralSecurityException {

        String decrypted = decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey3(priKey));
        decrypted = decrypted.replace("{", "");
        decrypted = decrypted.replace("}", "");

        String list[] = decrypted.split(",");

        NettBankPojo bankPojo = new NettBankPojo();

        for (String val : list) {

            if (val.contains("bankCode")) {
                val = val.replace("bankCode=", "");
                bankPojo.setBankCode(val);
            } else if (val.contains("bankName")) {
                val = val.replace("bankName=", "");
                bankPojo.setBankName(val);
            }

        }
        return bankPojo;
    }

}
