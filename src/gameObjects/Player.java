package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Player extends JComponent implements Runnable,KeyListener {

	ImageIcon rightpac = new ImageIcon(getClass().getResource("rightpac.png"));
	ImageIcon leftpac = new ImageIcon(getClass().getResource("leftpac.png"));
	ImageIcon uppac = new ImageIcon(getClass().getResource("uppac.png"));
	ImageIcon downpac = new ImageIcon(getClass().getResource("downpac.png"));
	
	
	int eatenSeedsNum=0;
	int pace=5;
	int x;
	int y;
	char currentmove='N';
	char change='N';
	char shapedir='R';

	boolean dallowed;
	boolean allowed;
	boolean [][]verticalwalls=new boolean[11][7];
	boolean [][]horizentalwalls=new boolean[10][8];

	 ArrayList<Rectangle> horWalls =new ArrayList<Rectangle>();
	 ArrayList<Rectangle> verWalls =new ArrayList<Rectangle>();
	
	 ArrayList<Rectangle> seeds =new ArrayList<Rectangle>();
		boolean []aliveseeds= new boolean[70];

	Rectangle rec_player;
	
	boolean itsdone=false;

	
	
	
	
		public Player() {
        
        x=600;
        y=625;
    }
		
		
		public void makingRec(boolean done){
			if (!done){
				itsdone=true;
			//sets horizentals
			for(int j=0;j<8;j++){
				for(int i=0;i<10;i++){
			if(horizentalwalls[i][j]){			
			horWalls.add(new Rectangle( 170+i*100,5+j*100,120,20));
			}}}		
			
			//sets verticals
			for(int j=0;j<7;j++){
				for(int i=0;i<11;i++){
			if(verticalwalls[i][j]){				
			verWalls.add(new Rectangle( 170+i*100,5+j*100,20,120));
			
			}}}		
			
			for(int i=0;i<70;i++){	
			seeds.add(new Rectangle( 220+(i%10)*100,50+100*(i/10),20,20  ));
			}
			
			for(int j=0;j<70;j++){
				aliveseeds[j]=true;
			}
			
		}}
		
		



	
	//getters and setters
	
	
	public void setVerticalwalls(boolean[][] verticalwalls) {
	this.verticalwalls = verticalwalls;
}

	public void setHorizentalwalls(boolean[][] horizentalwalls) {
		this.horizentalwalls = horizentalwalls;
	}


	public boolean[] getAliveseeds() {
		return aliveseeds;
	}

	

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getEatenSeedsNum() {
		return eatenSeedsNum;
	}


	public void paint(Graphics k){ 
		
		
		
		makingRec(itsdone);
		
		rec_player= new Rectangle(x, y, 80, 80);

		for(int i=0;i<70;i++){
			if(rec_player.intersects(seeds.get(i))){
				if(aliveseeds[i]){
					eatenSeedsNum++;
				aliveseeds[i]=false;
			}}
		}
		
		
					
		if(shapedir=='R')
		k.drawImage(rightpac.getImage(), x, y,80,80,null );
		
		if(shapedir=='U')
			k.drawImage(uppac.getImage(), x, y,80,80,null );

		if(shapedir=='D')
			k.drawImage(downpac.getImage(), x, y,80,80,null );
		
		if(shapedir=='L')
			k.drawImage(leftpac.getImage(), x, y,80,80,null );
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent k) {
		
		if( k.getKeyCode() == KeyEvent.VK_RIGHT){
			change='R';
		
			}
		
		if( k.getKeyCode() == KeyEvent.VK_LEFT){
			change='L';			

		}
		if( k.getKeyCode() == KeyEvent.VK_DOWN){
			change='D';
		}
		if( k.getKeyCode() == KeyEvent.VK_UP){
			change='U';
		}
		
	
		
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			
			if(change=='R'){
				Rectangle temp= new Rectangle(x+10, y, 80, 80);
				boolean Rallowed=true;
				if(verWalls.size()!=0){	
				for(int j=0;j<verWalls.size();j++){
				if(temp.intersects(verWalls.get(j)))
				Rallowed=false;	
				}
				if(horWalls.size()!=0){	
					for(int j=0;j<horWalls.size();j++){
					if(temp.intersects(horWalls.get(j)))
					Rallowed=false;	
					}}}
				if(Rallowed){
					currentmove='R';
					shapedir='R';	
					change='N';
				}}
			
			if(change=='L'){
				Rectangle temp= new Rectangle(x-pace, y, 80, 80);
				boolean Lallowed=true;
				if(verWalls.size()!=0){	
				for(int j=0;j<verWalls.size();j++){
				if(temp.intersects(verWalls.get(j)))
				Lallowed=false;	
				}
				if(horWalls.size()!=0){	
					for(int j=0;j<horWalls.size();j++){
					if(temp.intersects(horWalls.get(j)))
					Lallowed=false;	
					}}}
				if(Lallowed){
					currentmove='L';
					shapedir='L';
					change='N';
				}}
			
			if(change=='D'){
				Rectangle temp= new Rectangle(x, y+pace, 80, 80);
				boolean Dallowed=true;
				if(horWalls.size()!=0){
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Dallowed=false;	
				}
				if(verWalls.size()!=0){	
					for(int j=0;j<verWalls.size();j++){
					if(temp.intersects(verWalls.get(j)))
					Dallowed=false;	
					}}}
				if(Dallowed){
					currentmove='D';
					shapedir='D';
					change='N';	
				}}
			
			if(change=='U'){
				Rectangle temp= new Rectangle(x, y-pace, 80, 80);
				boolean Uallowed=true;
				if(horWalls.size()!=0){	
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Uallowed=false;	
				}
				if(verWalls.size()!=0){	
					for(int j=0;j<verWalls.size();j++){
					if(temp.intersects(verWalls.get(j)))
					Uallowed=false;	
					}}}
				if(Uallowed){
					currentmove='U';
					shapedir='U';
					change='N';
				}}
			
			
			
			
			
			
			
			
			
			
			
	
			//maintanus of movement
			if(currentmove=='R'){
				Rectangle temp= new Rectangle(x+pace, y, 80, 80);
				boolean Rallowed=true;
				if(verWalls.size()!=0){	
				for(int j=0;j<verWalls.size();j++){
				if(temp.intersects(verWalls.get(j)))
				Rallowed=false;	
				}
				if(horWalls.size()!=0){	
					for(int j=0;j<horWalls.size();j++){
					if(temp.intersects(horWalls.get(j)))
					Rallowed=false;	
					}}}	
				if(Rallowed)
				x+=pace;	
	
			}
			else if(currentmove=='L'){	
				Rectangle temp= new Rectangle(x-pace, y, 80, 80);
				boolean Lallowed=true;
				if(verWalls.size()!=0){	
				for(int j=0;j<verWalls.size();j++){
				if(temp.intersects(verWalls.get(j)))
				Lallowed=false;	
				}
				if(horWalls.size()!=0){	
					for(int j=0;j<horWalls.size();j++){
					if(temp.intersects(horWalls.get(j)))
					Lallowed=false;	
					}}}				
				if(Lallowed)
				x-=pace;	

			}
			else if(currentmove=='U' ){
				Rectangle temp= new Rectangle(x, y-pace, 80, 80);
				boolean Uallowed=true;
				if(horWalls.size()!=0){	
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Uallowed=false;	
				}
				
				if(verWalls.size()!=0){	
					for(int j=0;j<verWalls.size();j++){
					if(temp.intersects(verWalls.get(j)))
					Uallowed=false;	
					}}}
				if(Uallowed)
				y-=pace;	
			}
				
			else if(currentmove=='D'){	
				Rectangle temp= new Rectangle(x, y+pace, 80, 80);
				boolean Dallowed=true;
				if(horWalls.size()!=0){
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Dallowed=false;	
				}
				if(verWalls.size()!=0){	
					for(int j=0;j<verWalls.size();j++){
					if(temp.intersects(verWalls.get(j)))
					Dallowed=false;	
					}}}
				if(Dallowed)
				y+=pace;
			}
			
			
			
			
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}

	
}
