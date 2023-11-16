/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sangnvpc06179
 */
public class XImage {

    public static Image getAppIcon(String img) {
        URL url = XImage.class.getResource(img);
        return new ImageIcon(url).getImage();
    }
    
    public static void saveImgToLable(String img, JLabel lbl) {
        URL url = XImage.class.getResource(img);
        ImageIcon imgIcon = new ImageIcon(url);
        lbl.setText("");
        Image image = imgIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }
    
     public static void saveImgToLbl(String img, JLabel lbl) {
        ImageIcon imgIcon = new ImageIcon(img);
        lbl.setText("");
        Image image = imgIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }

    public static void save(File src) {
        File dir = new File("logos", src.getName());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            Path source = Paths.get(src.getAbsolutePath());
            Path destination = Paths.get(dir.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ImageIcon read(String filename) {
        File path = new File("logos", filename);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }
}
