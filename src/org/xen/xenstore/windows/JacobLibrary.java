/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.xenstore.windows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class JacobLibrary {

    public static void init() {
        FileOutputStream fileOutputStream = null;
        try {
            String name = "jacob-1.18-M2-x";
            String model = System.getProperty("sun.arch.data.model");
            if (model.equals("32")) {
                model = "86";
            }
            name = name + model + ".dll";
            System.out.println(name);
            InputStream inputStream = JacobLibrary.class.getResourceAsStream(name);
            fileOutputStream = new FileOutputStream(name);
            byte[] buffer = new byte[1024];
            int n = 0;
            while ((n = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, buffer.length);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            System.load(new File(name).getAbsolutePath());
        } catch (Exception ex) {
            Logger.getLogger(JacobLibrary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(JacobLibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
