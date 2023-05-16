package gui;

import javax.swing.*;

public class MainTest {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new CreateNewCardFrame();


               new PreviewTransferFrame();

//                try {
//                    new MainFrame();
//                } catch (UnsupportedLookAndFeelException e) {
//                    throw new RuntimeException(e);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                } catch (InstantiationException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });
    }
}
