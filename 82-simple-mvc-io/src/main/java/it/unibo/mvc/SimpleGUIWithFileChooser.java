package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private static final String PATH = System.getProperty("user.home") 
            +File.separator
            + "Desktop";
    private static final Controller control = new Controller();
    private final JFrame frame = new JFrame();
    
    public SimpleGUIWithFileChooser() {
        final JPanel main_canvas = new JPanel();
        final JPanel upper_canvas = new JPanel();
        final JTextField text = new JTextField(PATH);
        text.setEditable(false);
        final JButton button = new JButton("Browse");
        main_canvas.setLayout(new BorderLayout());
        main_canvas.add(upper_canvas, BorderLayout.NORTH);
        upper_canvas.add(text, BorderLayout.CENTER);
        upper_canvas.add(button, BorderLayout.LINE_END);
        frame.setContentPane(main_canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showSaveDialog(button) == JFileChooser.APPROVE_OPTION) {
                    control.setFile(fileChooser.getSelectedFile());
                }
                else if (fileChooser.showSaveDialog(button) == JFileChooser.CANCEL_OPTION) {
                    
                } 
                else {
                    JOptionPane.showMessageDialog(frame,"An error has occurred");
                }
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
