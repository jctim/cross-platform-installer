package com.upwork.jctim;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        File currentDir = new File(".");
        File folderDir = new File("./folder");
        System.out.println("And I have such file in . : " + Arrays.toString(currentDir.list()));
        System.out.println("And I have such file in ./folder : " + Arrays.toString(folderDir.list()));

        showSimpleGui(folderDir.listFiles());
    }

    public static void showSimpleGui(File[] imageFiles) {
        JFrame mainFrame = new JFrame("Test GUI App");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                panel.add(new ImagePanel(imageFile));
            }
        }

        mainFrame.getContentPane().add(panel);
        mainFrame.setVisible(true);
    }

    static class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(File imageFile) {
            try {
                image = ImageIO.read(imageFile);
            } catch (IOException ex) {
                System.err.println("Image not loaded: " + ex.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

    }
}
