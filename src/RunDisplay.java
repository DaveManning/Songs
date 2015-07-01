import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RunDisplay extends JFrame {

	public static void main(String[] args) {
		
        JFrame f = new RunDisplay();
        f.setTitle("Songs");
        Container contentPane = f.getContentPane();
        contentPane.add( new DisplayList());
        f.pack();
        f.setVisible(true);

	}// end main

}// end class
