package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import java.io.IOException;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first GUI";
    private static final String PATH = System.getProperty("user.home") 
            +File.separator
            + SimpleGUI.class.getSimpleName() + ".txt";
    private static final Controller control = new Controller();
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton button = new JButton("Save");
        canvas.add(text);
        canvas.add(button, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                control.setFile(new File(PATH));
                control.writeString(text.getText());
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
