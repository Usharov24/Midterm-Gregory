import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class MidtermGreg{ 
	
	public static void main(String []args){
	Console con = new Console("Monkey Game",1280,720);
	int intcount = 0;	
	int intmousex;
	int intmousey;
	int intmouseclick;
	String strrun;
	int intrandom;
	int intuser;
	double dbltime = 0;
		
	
		
	
		while (intcount == 0){
		start(con);
		intmousex = con.currentMouseX();
		intmousey = con.currentMouseY();
		intmouseclick = con.currentMouseButton();
		intmouseclick = con.currentMouseButton();
		con.clear();
		
		if (intmousex < 930 && intmousex > 400 && intmousey < 650 && intmousey > 460 && intmouseclick == 1){
			intcount = 1;
		}
		con.println(intmousex);
		con.println(intmousey);
		con.println(intmouseclick);
		con.println(intcount);
	}
	while (intcount == 1){
		intmousex = con.currentMouseX();
		intmousey = con.currentMouseY();
		intmouseclick = con.currentMouseButton();
		scene1(con);
		if (intmousex > 910 && intmousey < 150 && intmouseclick == 1){
		intcount = 2;
		}
		if (intmousex < 150 && intmousey < 390 && intmouseclick == 1){
		intcount = 3;
		} 
	}
	while (intcount == 2){
		scene2(con);
	}
	while (intcount == 3){
		scene3(con);
		strrun = con.readLine();
		if (strrun.equals("left")){
			intcount = 5;
		}	
		if (strrun.equals("right")){
			intcount = 4;
		}
	}
	
	while (intcount == 5){
		scene5(con);
	intrandom = (int)( Math.random()*6+1);
	con.println(intrandom);
	intuser = con.readInt();
	if (intuser == intrandom){
		intcount = 14;
	}
}
	if (intcount == 14){
		scene14(con);
		dbltime = con.readDouble();
		intcount = 15;
}
if (intcount == 15){
		scene15(con);
		con.println("you eat 1000 bananas in "+dbltime+" minitues or "+1000/dbltime+" bananas per minute");
		con.println("monkey is full and falls asleep, the end");
		
}

}
	public static void start(Console con){
	int intmousex;
	int intmousey;
	int intmouseclick;
	
		BufferedImage imgstart = con.loadImage("start.png");
		con.drawImage(imgstart,0,0);
		
		con.repaint();
		 
	 }
	public static void scene1(Console con){
	
	
	
		BufferedImage imgscene1 = con.loadImage("scene1.png");
		con.drawImage(imgscene1,0,0);con.repaint();
		con.clear();
		con.setTextColor(Color.RED);
		con.println("Monkey spots a banana in the distance and wants it!");
		con.println("Does he walk or swing to the banana, click your choice");
		
	
		con.repaint();
	
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
		con.clear();
		BufferedImage imgscene3 = con.loadImage("scene3.png");
		con.drawImage(imgscene3,0,0);
		con.println("Enter left or right, left is forest, right is rock.");
		con.repaint();
	}
	public static void scene4(Console con){
			
		BufferedImage imgscene3 = con.loadImage("scene3.png");
		con.drawImage(imgscene3,0,0);
		con.println("Enter left or right, left is forest, right is rock.");
		con.repaint();
	}

	public static void scene5(Console con){
		con.clear();
		BufferedImage imgscene5 = con.loadImage("scene5.png");
		con.drawImage(imgscene5,0,0);
		con.println("Gambling monkeys, 1/6 chance to get 1000 bananas, input a number from 1 to 6.");
		con.repaint();
	}
		public static void scene14(Console con){
		con.clear();
		BufferedImage imgscene14 = con.loadImage("scene14.png");
		con.drawImage(imgscene14,0,0);
		con.println("You won the thousand bananas!!! how fast do you eat them all in minutes?");
		con.repaint();
	}
	public static void scene15(Console con){
		con.clear();
		BufferedImage imgscene15 = con.loadImage("scene15.png");
		con.drawImage(imgscene15,0,0);
		con.repaint();
	}
	
}


