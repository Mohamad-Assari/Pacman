import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameObjects.Hearts;
import gameObjects.Lulu;
import gameObjects.Player;
import gameObjects.Seeds;

@SuppressWarnings("serial")
public class The_Inside  extends JPanel implements Runnable{
	
	
	ImageIcon alaki;
	ImageIcon alaki2;

	MapReader map=new MapReader();;
	Player player= new Player();;
	Lulu lulu=new Lulu(0);
	Lulu lulu1=new Lulu(1);
	Hearts heart=new Hearts();
	Seeds objseed=new Seeds();
	boolean gamenotfinished=true;
	//aya ehtiaje
	 int xLulu;
	 int yLulu;
	 Rectangle rec_player;
	 
	 Rectangle rec_lulu;
	 Rectangle rec_lulu1;

	 My_Board objBoard;
	 
	 int numberOfLosts=0;

	
	public The_Inside(My_Board objBoard){
		this.objBoard = objBoard;
		setLayout(null);
		setBackground(Color.green);
		
		new Thread(player).start();
		new Thread(lulu).start();
		new Thread(lulu1).start();
		alaki2=new ImageIcon(getClass().getResource("Wall (2).png"));
		player.setVerticalwalls(map.getVerticalwalls());
		player.setHorizentalwalls(map.getHorizentalwalls());
		lulu.setVerticalwalls(map.verticalwalls);
		lulu.setHorizentalwalls(map.horizentalwalls);
		
		lulu.setxLulu(map.getxLulu());
		lulu.setyLulu(map.getyLulu());
		
		
		lulu1.setVerticalwalls(map.verticalwalls);
		lulu1.setHorizentalwalls(map.horizentalwalls);
		lulu1.setxLulu(map.getxLulu());
		lulu1.setyLulu(map.getyLulu());
		objseed.setAliveseeds(player.getAliveseeds());
		
		
		
	}
	
	public void paint(Graphics arg0) {
		
		
		super.paint(arg0);
		
		map.paint(arg0);
		objseed.paint(arg0);
		player.paint(arg0);
		lulu.paint(arg0);
		lulu1.paint(arg0);
		heart.paint(arg0);
		
		// checks collision
		rec_player= new Rectangle(player.getX(), player.getY(), 80, 80);
		rec_lulu= new Rectangle(lulu.getxLulu(), lulu.getyLulu(), 50, 50);
		rec_lulu1= new Rectangle(lulu1.getxLulu(), lulu1.getyLulu(), 50, 50);
		
		
		if((rec_player.intersects(rec_lulu)||rec_player.intersects(rec_lulu1) ) && gamenotfinished &&numberOfLosts<=3){
			numberOfLosts++;
			player.setX(600);
			player.setY(625);
			lulu.setxLulu(map.getxLulu());
			lulu.setyLulu(map.getyLulu());
			lulu1.setxLulu(map.getxLulu());
			lulu1.setyLulu(map.getyLulu());
			
			heart.setNumberOfLosts(numberOfLosts);
			
			
			
		}
		
		
		
		
		
		
		if((rec_player.intersects(rec_lulu)||rec_player.intersects(rec_lulu1) ) && gamenotfinished &&numberOfLosts==3){
			gamenotfinished=false;
			setVisible(false);
			
			int finish = JOptionPane.showConfirmDialog(null,
					"oh no!! you lost the game \n Do you want to play it again?", "Game over :)",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			if (finish == 1)
				System.exit(0);
			
			if (finish == 0){
				objBoard.setVisible(false);
				new My_Board ();
		}
			
		}
		
		// checks winning
		if(player.getEatenSeedsNum()==70 && gamenotfinished){
			gamenotfinished=false;
			setVisible(false);
			
			int finish = JOptionPane.showConfirmDialog(null,
					"Congratulations !! you won the game \n Do you want to play it again?", "Victory :)",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			if (finish == 1)
				System.exit(0);
			
			if (finish == 0){
				objBoard.setVisible(false);
				new My_Board ();
		}
		
	
	}
	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			repaint();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
