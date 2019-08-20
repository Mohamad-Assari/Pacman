import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

public class MapReader {
	
	 FileInputStream in = null;
	 String lineSaver = null;
	 DataInputStream dataIn = null;
	 boolean [][]horizentalwalls=new boolean[10][8];
	 boolean [][]verticalwalls=new boolean[11][7];
	 ImageIcon singlewall;
	 
	 
	 int xLulu;
	 int yLulu;
	 
	 
	 
	 


	
	@SuppressWarnings("deprecation")
	public MapReader(){
		
		singlewall=new ImageIcon(getClass().getResource("Wall (2).png"));
		
		
		
		
		try {
			in = new FileInputStream(new File("src/Map.txt"));
			dataIn = new DataInputStream(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String temp = null;
			while(true){
				temp = dataIn.readLine();
				if(temp.equals("-1"))
					break;
				lineSaver += (temp);
				
			}
			lineSaver=lineSaver.substring(4);	
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		lineSaver=lineSaver.replaceAll(" ", "");
		
		
		
		//sets horizental 
		for(int j=0;j<8;j++){
		for(int i=0;i<10;i++){
			
			 if(lineSaver.charAt(j*21+i)=='-'){
				horizentalwalls[i][j]=true;
			}
			}		
		}
		
		
		//sets vertical 
				for(int j=0;j<7;j++){
				for(int i=0;i<11;i++){
					
					
					
					if(lineSaver.charAt(10+j*21+i)=='|'){
						verticalwalls[i][j]=true;
					}
					}		
				}	

	 	
				//finds lulu's place
				for(int j=0;j<7;j++){
					for(int i=0;i<11;i++){
						
						
						if(lineSaver.charAt(10+j*21+i)=='#'){
						
							yLulu=5+j*100;
							xLulu=170+i*100;
							
							break;
						
						}}}
				
				
				
		
		
	}

	public void paint(Graphics mapping){
		
		
		
		//paints horizentals
		for(int j=0;j<8;j++){
			for(int i=0;i<10;i++){
		
		if(horizentalwalls[i][j]){
		mapping.drawImage(singlewall.getImage(), 170+i*100, 5+j*100,120,20,null );
		


		
		}		
			}
			}
		
		
		//paints verticals
				for(int j=0;j<7;j++){
					for(int i=0;i<11;i++){
				
				if(verticalwalls[i][j]){
				mapping.drawImage(singlewall.getImage(), 170+i*100, 5+j*100,20,120,null );
				}		
					}
					}
		
		
		
		
		
		
		
		
		
		
	}

	public boolean[][] getVerticalwalls() {
		return verticalwalls;
	}

	public boolean[][] getHorizentalwalls() {
		return horizentalwalls;
	}

	public int getxLulu() {
		return xLulu;
	}

	public int getyLulu() {
		return yLulu;
	}
	
	
	
	
	
	
	
	
	
}
