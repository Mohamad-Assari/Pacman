import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



@SuppressWarnings("serial")
public class My_Board extends JFrame{


	Dimension screen ;
	
	public My_Board(){
		screen = Toolkit.getDefaultToolkit().getScreenSize(); 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	

		
		
		
			setTitle("Pacman");
			setSize((int)screen.getWidth() ,(int) screen.getHeight());

			
			
			
			
			
			
			
			
			
			
			
			
			
			The_Inside objOfInside = new The_Inside(this);
			this.addKeyListener(objOfInside.player);
			(new Thread(objOfInside)).start();
			this.getContentPane().add(objOfInside);
			setVisible(true);
			
	
	
}
}
