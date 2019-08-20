package gameObjects;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Hearts extends JComponent {

	
	int numberOfLosts;
	ImageIcon hearts = new ImageIcon(getClass().getResource("heart.png"));


	
	
	@Override
	public void paint(Graphics arg0) {
		
		for(int i=1; i<=3-numberOfLosts;i++){
				arg0.drawImage(hearts.getImage(), -30+i*45 , 400,40,40,null );

			}
		
		
	}




	public void setNumberOfLosts(int numberOfLosts) {
		this.numberOfLosts = numberOfLosts;
	}
	
	
}
