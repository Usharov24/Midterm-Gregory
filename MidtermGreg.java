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
	double dblangle;
	double dblvelocity;
	double dbluserdist;
		
	
		
	
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
	if (intcount == 4){
		scene4(con);
		con.println("What angle is the banana peel thrown?");
		dblangle = con.readDouble(); 
		dblangle = (dblangle * 3.14) / 180;
		con.println("What velocity is the banana peel thrown?");
		dblvelocity = con.readDouble();
		dbluserdist = ((dblvelocity * dblvelocity) * Math.sin(2*dblangle))/9.81;
		if (dbluserdist > 8 && dbluserdist <12){
			intcount = 7;
		}
		else if (dbluserdist <= 8){
			intcount = 6;
		}
		else {
			intcount = 8;
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
	if (intcount == 6){
		scene6(con);
	}
	if (intcount == 7){
		scene7(con);
	}

	if (intcount == 14){
		scene14(con);
		dbltime = con.readDouble();
		intcount = 15;
}
if (intcount == 15){
		scene15(con);
		con.println("you eat 1000 bananas in "+dbltime+" minitues or "+1000/dbltime+" bananas per minute");
		con.println("monkey is full and falls asleep, the end.");
		
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
			
		BufferedImage imgscene4 = con.loadImage("scene4.png");
		con.drawImage(imgscene4,0,0);
		con.println("Monkey wants to throw banana peel at bird.");
		con.println("If bird is on the same height and 10 meters away.");
		con.println("Use the range formula");
		con.repaint();
	}

	public static void scene5(Console con){
		con.clear();
		BufferedImage imgscene5 = con.loadImage("scene5.png");
		con.drawImage(imgscene5,0,0);
		con.println("Gambling monkeys, 1/6 chance to get 1000 bananas, input a number from 1 to 6.");
		con.repaint();
	}
	public static void scene6(Console con){
		con.clear();
		BufferedImage imgscene6 = con.loadImage("scene6.png");
		BufferedImage imgbanana = con.loadImage("banana1.png");
		con.drawImage(imgscene6,0,0);
		int intbanana;
		int intcount;
		for (intbanana=500; intbanana < 700; intbanana++){
			con.drawImage(imgscene6,0,0);
			con.drawImage(imgbanana,intbanana,700 - intbanana);
			con.repaint();
			con.sleep(5);
	}
		for (intbanana = 700; intbanana < 900 ; intbanana++){
			con.drawImage(imgscene6,0,0);
			con.drawImage(imgbanana,intbanana,intbanana - 700);
			con.repaint();
			con.sleep(5);
		}
		con.println("Monkey undershot, monkey sad, monkey sleeps, the end.");
		
		con.repaint();
	}
	
	public static void scene7(Console con){
		con.clear();
		int intbanana;
		int intcount;
		int intcount1;
		BufferedImage imgbanana = con.loadImage("banana.png");
		BufferedImage imgmonkeytime = con.loadImage("monkeytime.png");
		BufferedImage imgscene7 = con.loadImage("scene4.png");
		BufferedImage imgscene71 = con.loadImage("scene7,1.png");
		con.drawImage(imgscene7,0,0);
		for (intbanana=500; intbanana < 700; intbanana++){
			con.drawImage(imgscene7,0,0);
			con.drawImage(imgbanana,intbanana,700 - intbanana);
			con.repaint();
			con.sleep(5);
	}
		for (intbanana = 700; intbanana < 900 ; intbanana++){
			con.drawImage(imgscene7,0,0);
			con.drawImage(imgbanana,intbanana,intbanana - 700);
			con.repaint();
			con.sleep(5);
		}
		for (intcount1 = 0; intcount1 < 50; intcount1++){
		for (intcount =0; intcount < 10; intcount++){
			con.drawImage(imgscene71,0,0);
			con.drawImage(imgmonkeytime,0,intcount);
			con.repaint();
			con.sleep(5);
		}
		for (intcount =0; intcount < 10; intcount++){
			con.drawImage(imgscene71,0,0);
			con.drawImage(imgmonkeytime,0,10 - intcount);
			con.repaint();
			con.sleep(5);
		}
		
	}
	con.clear();
	con.println("the end, monkey is king");
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


