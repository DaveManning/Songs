
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DisplayList extends JPanel implements ActionListener {
		
		  private JLabel label1;
		  private JTextArea MainText;
	      private JButton PrintButton;
		  
	      public DisplayList() {
			    makeTheObjects();
			    doTheLayout();
			    PrintButton.addActionListener( new java.awt.event.ActionListener() {
			        public void actionPerformed(ActionEvent e){
			            actionPerformed(e);
			            }
			    });

			  } // end of constructor
		  
		  private void makeTheObjects(){
		      label1 = new JLabel("top 100 songs");
		      MainText = new JTextArea ();
		      PrintButton = new JButton("Print");
		      MainText.setEditable(false);

		  }// end of creating objects method

		  private void doTheLayout(){

		      JPanel top = new JPanel();
		      JPanel center = new JPanel();
		      JPanel bottom = new JPanel();

		      top.setLayout( new FlowLayout());
		      top.add(label1);
		      
		      top.setLayout( new FlowLayout());
		      center.add(MainText);
		      
		      top.setLayout( new FlowLayout());
		      bottom.add(PrintButton);
		      
		      setLayout( new BorderLayout());
		      add(top, "North");
		      add(center, "Center");
		      add(bottom, "South");


		  }// end of Layout method

		@Override
		public void actionPerformed(ActionEvent e) {
			MainText.setText("s");
			
		}
		  		  
}// end ListDisplay


