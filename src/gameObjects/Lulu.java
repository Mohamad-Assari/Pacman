package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Lulu extends JComponent implements Runnable{
	
	boolean [][]verticalwalls=new boolean[11][7];
	boolean [][]horizentalwalls=new boolean[10][8];
	
	int xLulu=-200;
	int yLulu=-200;
	int lastmove;
	ArrayList<Rectangle> horWalls =new ArrayList<Rectangle>();
	 ArrayList<Rectangle> verWalls =new ArrayList<Rectangle>();
	 int possiblemoves;	
	 int anshwer;
	 
	Rectangle rec_lulu;
	int lulunumber;
	
	
	public Lulu(int lulunumber){
		this.lulunumber=lulunumber;
		
	}
		

	ImageIcon redlulu = new ImageIcon(getClass().getResource("Red lulu.png"));
	ImageIcon bluelulu = new ImageIcon(getClass().getResource("Blue lulu.png"));
	
		public void paint(Graphics j) {
			
			//red or blue ghost
		if(lulunumber==0)
		j.drawImage(redlulu.getImage(), xLulu , yLulu,80,80,null );
		else
		j.drawImage(bluelulu.getImage(), xLulu , yLulu,80,80,null );
	
		
		
	
	}
		


public void setyLulu(int yLulu) {
	this.yLulu = yLulu+20;
}


public void setxLulu(int xLulu) {
	this.xLulu = xLulu-60;
}


public void setVerticalwalls(boolean[][] verticalwalls) {
	this.verticalwalls = verticalwalls;
}


public void setHorizentalwalls(boolean[][] horizentalwalls) {
	this.horizentalwalls = horizentalwalls;
}




public int getxLulu() {
	return xLulu;
}



public int getyLulu() {
	return yLulu;
}



@Override
public void run() {
	
	while(xLulu==-200){
		
	}
	
	
	while(horWalls.size()==0){
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
	
	}
	
	while(true){
		
		
		boolean Rallowed = true;
		boolean Lallowed = true;
		boolean Uallowed = true;
		boolean Dallowed = true;
		
		Rectangle temp;
		
		
		
		 temp= new Rectangle(xLulu+1, yLulu, 80, 80);
		if(verWalls.size()!=0){	
			for(int j=0;j<verWalls.size();j++){
			if(temp.intersects(verWalls.get(j)))
			Rallowed=false;	
			}
			if(horWalls.size()!=0){	 
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Rallowed=false;	
				}}
			
			}
		
		 temp= new Rectangle(xLulu-1, yLulu, 80, 80);
		if(verWalls.size()!=0){	
			for(int j=0;j<verWalls.size();j++){
			if(temp.intersects(verWalls.get(j)))
			Lallowed=false;	
			}
			if(horWalls.size()!=0){	
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Lallowed=false;	
				}}
			
			}
		
		
		temp= new Rectangle(xLulu, yLulu+1, 80, 80);
		if(verWalls.size()!=0){	
			for(int j=0;j<verWalls.size();j++){
			if(temp.intersects(verWalls.get(j)))
			Dallowed=false;	
			}
			if(horWalls.size()!=0){	
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Dallowed=false;	
				}}
			
			}
		
		
		temp= new Rectangle(xLulu, yLulu-1, 80, 80);
		if(verWalls.size()!=0){	
			for(int j=0;j<verWalls.size();j++){
			if(temp.intersects(verWalls.get(j)))
			Uallowed=false;	
			}
			if(horWalls.size()!=0){	
				for(int j=0;j<horWalls.size();j++){
				if(temp.intersects(horWalls.get(j)))
				Uallowed=false;	
				}}
			
			}

		
		boolean [] moves={Rallowed,Lallowed,Uallowed,Dallowed};
		int which=0;
		possiblemoves=0;
		for(int i=0;i<4;i++){	
			if(moves[i]){
			possiblemoves++;
			which=i;
			}
			
		}
		
		if(possiblemoves==1){
			
			
			if(which==0)
				xLulu++;	
			if(which==1)
				xLulu--;
			if(which==2)
				yLulu--;
			if(which==3)
				yLulu++;
			lastmove=which;
		}

		
		
		if(possiblemoves==2){
			if(moves[lastmove]){
			if(lastmove==0)
				xLulu++;
			if(lastmove==1)
				xLulu--;
			if(lastmove==2)
				yLulu--;
			if(lastmove==3)
				yLulu++;
			
		}
			 if (!moves[lastmove]){
				
				if((lastmove==3||lastmove==2) && moves[0]){
					xLulu++;	
				lastmove=0;}
				else if((lastmove==3||lastmove==2) && moves[1]){
					xLulu--;
				lastmove=1;}
				else if((lastmove==0||lastmove==1) && moves[2]){
					yLulu--;
				lastmove=2;}
				else if((lastmove==0||lastmove==1) && moves[3]){
					yLulu++;
				lastmove=3;}
			}
			
			
			
			}
		if(possiblemoves==3){
			
			Random rn = new Random();
			int answer = rn.nextInt(2);
			
			//mojaz ast
			if(moves[lastmove]){
			
			
			if (answer==0){
				if(lastmove==0)
					xLulu++;	
				if(lastmove==1)
					xLulu--;
				if(lastmove==2) 
					yLulu--;
				if(lastmove==3)
					yLulu++;	
				
		}
			if(answer==1){
				if((lastmove==2 || lastmove==3)&& moves[0]){
					xLulu++;
					lastmove=0;
				}
				else if((lastmove==2 || lastmove==3)&& moves[1]){
				xLulu--;
				lastmove=1;
				
				}
				else if((lastmove==0 || lastmove==1)&& moves[2]){
					yLulu--;
					lastmove=2;
					
				}
				else if((lastmove==0 || lastmove==1)&& moves[3]){
					yLulu++;
					lastmove=3;
					

				}
				
			}
			
			
			}	
			if(!moves[lastmove]){

				if(answer==0){
					if(lastmove==2 || lastmove==3){
					xLulu++;
					lastmove=0;}
					else if(lastmove==0||lastmove==1){
					yLulu--;
					lastmove=2;
					}
				}
				if(answer==1){

					if(lastmove==2 || lastmove==3){
					xLulu--;
					lastmove=1;
					}
					else if(lastmove==0||lastmove==1){
					yLulu++;
					lastmove=3;
				}
				}
				
			}
		}
		
		if(possiblemoves==4){
			
			boolean conditionsatisfied=false;
			

			while(!conditionsatisfied){
				Random rn = new Random();
				anshwer = rn.nextInt(4);
				
			if((anshwer==0 && lastmove!=1 ) || (anshwer==1 && lastmove!=0 ) ||(anshwer==2 && lastmove!=3 ) || (anshwer==3 && lastmove!=2 ))
				conditionsatisfied=true;
			
			}
			
			if(anshwer==0)
				xLulu++;
			if(anshwer==1)
				xLulu--;
			if(anshwer==2) 
				yLulu--;
			if(anshwer==3)
				yLulu++;
			
			lastmove=anshwer;
		}
		
		
		
		
		
		try {
			Thread.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	
	
}
	
	

	
	

}
