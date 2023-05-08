package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Utils {

//  Used for setting a Jlabel with an icon
    public static ImageIcon setLabelIcon(String path, JLabel logo) {

        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH); //resizing the image to fit the label
        return new ImageIcon(newImg);
    }
}
