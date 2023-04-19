import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class MidtermGreg{ 
	
	public static void main(String []args){
	Console con = new Console("Monkey Game",1280,720);
	int intcount = 0;	
	int intloopcontrol = 0;
	int intmousex;
	int intmousey;
	int intmouseclick;
	int intbirdposx = 1;
	int intbirdposy = 350;
while (intloopcontrol == 0){
		con.clear();
		intmousex = con.currentMouseX();
		intmousey = con.currentMouseY();
		intmouseclick = con.currentMouseButton();
		con.println(intmousex);
		con.println(intmousey);
		con.println(intmouseclick);
		if (intcount == 0){
		start(con);
		
		if (intmousex < 930 && intmousex > 400 && intmousey < 650 && intmousey > 460 && intmouseclick == 1){
			intcount = 1;
		}
		
}
		if (intcount == 1){
		scene1(con);
		if (intmousex < 910 && intmousey < 150 && intmouseclick == 1){
		intcount = 2;
		}
		if (intmousex < 150 && intmousey < 390 && intmouseclick == 1){
		intcount = 3;
		}
		if (intcount == 2){
		scene2(con);
		}
con.sleep(10);

}

}
}
	public static void start(Console con){
			
		BufferedImage imgstart = con.loadImage("start.png");
		con.drawImage(imgstart,0,0);
		con.repaint();
		 }
	public static void scene1(Console con){
		BufferedImage imgscene1 = con.loadImage("scene1.png");
		con.drawImage(imgscene1,0,0);con.repaint();
		con.setTextColor(Color.RED);
		con.println("Monkey spots a banana in the distance and wants it!");
		con.println("Does he walk or swing to the banana, click your choice");
		con.repaint();
}
	public static void scene2(Console con){
			
		BufferedImage imgscene2 = con.loadImage("scene1.png");
		BufferedImage imgbird = con.loadImage("bird.png");
		con.drawImage(imgscene2,0,0);
		con.drawImage(imgbird,intbirdposx,intbirdposy);
		intbirdposx = intbirdposx+5;
		
		con.repaint();
		 }
}
	
	

	


