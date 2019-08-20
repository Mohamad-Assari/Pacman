package gameObjects;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Seeds extends JComponent {

	ImageIcon seed = new ImageIcon(getClass().getResource("seed.png"));	
	boolean []aliveseeds= new boolean[70];
	boolean doitonce=false;
	
	
	
	@Override
	public void paint(Graphics arg0) {
		
		if(!doitonce){
			for(int j=0;j<70;j++){
				aliveseeds[j]=true;
		}
			doitonce=true;
		}
		
		
		
		for(int i=0;i<70;i++){	
			if(aliveseeds[i])
		arg0.drawImage(seed.getImage(), 220+(i%10)*100,50+100*(i/10),20,20,null );
		}
		
	}



	public void setAliveseeds(boolean[] aliveseeds) {
		this.aliveseeds = aliveseeds;
	}
	
	
	
	
}
