/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blacksilicon.rsa.encrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

/**
 *
 * @author mubarakanifowose
 */

public class PemFile {

    private PemObject pemObject;

    public PemFile(String filename) throws FileNotFoundException, IOException {
        
        try (PemReader pemReader = new PemReader(new InputStreamReader(new FileInputStream(filename)))) {
            this.pemObject = pemReader.readPemObject();
        }
    }

    public PemObject getPemObject() {
        return pemObject;
    }

}
