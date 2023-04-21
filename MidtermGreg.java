import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class MidtermGreg{ 
	
	public static void main(String []args){
	Console con = new Console("Monkey Game",1280,720);
	int intcount = 0;	
	

		
	
		
		
		start(con);
		scene1(con);
		if (intcount == 2){
		scene2(con);
	}
	if (intcount == 3){
		scene3(con);
	}



}
	public static void start(Console con){
	int intmousex;
	int intmousey;
	int intmouseclick;
	int intcount = 0;
	
		BufferedImage imgstart = con.loadImage("start.png");
		con.drawImage(imgstart,0,0);
		while (intcount == 0){
		intmousex = con.currentMouseX();
		intmousey = con.currentMouseY();
		intmouseclick = con.currentMouseButton();
		intmouseclick = con.currentMouseButton();
		con.clear();
		con.println(intmousex);
		con.println(intmousey);
		con.println(intmouseclick);
		con.println(intcount);
		if (intmousex < 930 && intmousex > 400 && intmousey < 650 && intmousey > 460 && intmouseclick == 1){
			intcount = 1;
		}
		con.repaint();
		 }
	 }
	public static void scene1(Console con){
	
	int intmousex;
	int intmousey;
	int intmouseclick;
	int intcount = 1;
	while (intcount == 1){
	intmousex = con.currentMouseX();
	intmousey = con.currentMouseY();
	intmouseclick = con.currentMouseButton();
		BufferedImage imgscene1 = con.loadImage("scene1.png");
		con.drawImage(imgscene1,0,0);con.repaint();
		if (intmousex > 910 && intmousey < 150 && intmouseclick == 1){
		intcount = 2;
		}
		if (intmousex < 150 && intmousey < 390 && intmouseclick == 1){
		intcount = 3;
		} 
		con.clear();
		con.setTextColor(Color.RED);
		con.println("Monkey spots a banana in the distance and wants it!");
		con.println("Does he walk or swing to the banana, click your choice");
		con.println(intmousex);
		con.println(intmousey);
		con.println(intmouseclick);
		con.println(intcount);
	
		con.repaint();
	}
}
	public static void scene2(Console con){
		int intbirdposx = 1;
		int intbirdposy = 150;
		int intcount = 2;
			while(intcount == 2){
		BufferedImage imgscene2 = con.loadImage("scene2.png");
		BufferedImage imgbird = con.loadImage("bird.png");
		con.drawImage(imgscene2,0,0);
		con.drawImage(imgbird,intbirdposx,intbirdposy);
		
		con.println(intbirdposx);
		con.repaint();
		if (intbirdposx < 600){
			
			intbirdposx= intbirdposx+10;
		}
		if (intbirdposx > 600){
			con.clear();
			con.println("Bird got it first, you lost, monkey sad");
		con.repaint();
	}
		 }
	 }
	public static void scene3(Console con){
			
		BufferedImage imgscene3 = con.loadImage("scene3.png");
		con.drawImage(imgscene3,0,0);
		con.repaint();
	}
}


