package gui;

import javax.swing.*;

public class MainTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
<<<<<<< HEAD

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
=======
                new PreviewTransferFrame();
>>>>>>> 6d9494a33348e15da5e870cdebcaeed37487a869
            }
        });
    }
}
