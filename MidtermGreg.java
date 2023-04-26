import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class MidtermGreg{ 
	
	public static void main(String []args){
		Console con = new Console("Monkey Game 1.02",1280,720);
		//sets the console window size and name
		int intcount = 0;	
		//the main control of the story
		int intmousex;
		int intmousey;
		int intmouseclick;
		//will be used for mouse intputs
		int intpalindromecheck = 0;
		int intcorrelationcount;
		String strrun;
		String strpalinedrome;
		String strsub; 
		String strsub2;
		int intstrlength;
		int intdromecount = 0;
		//will be used for palindrome checker 
		int intrandom;
		int intuser;
		//used for the dice minigame
		double dbltime = 0;
		double dblangle;
		double dblvelocity;
		double dbluserdist;
		//used for the range equation
		int intcounter1=0;
		char charcurrent;
		//used in the scene where the the keyboard input is registered / scene 8
		int intmonkeycount;
		//another variable, user input variable on scene 11
		
		
		//Start of the game / Scene 0
		while (intcount == 0){
			//very start of the game, loops all the code below
			start(con);
			//displays the image in the start method
			intmousex = con.currentMouseX();
			intmousey = con.currentMouseY();
			intmouseclick = con.currentMouseButton();
			//registers the values of the mouse to integers used in the next if command
			if (intmousex < 930 && intmousex > 400 && intmousey < 650 && intmousey > 460 && intmouseclick == 1){
				intcount = 1;
			}
			//the area where the button is, if the mouse is pressed and in the button region, move to next scene
		}
		//Scene 1
		while (intcount == 1){
			//while is used to make sure mouse values are registered
			intmousex = con.currentMouseX();
			intmousey = con.currentMouseY();
			intmouseclick = con.currentMouseButton();
			//mouse values are assigned
			
			if (intmousex > 910 && intmousey < 150 && intmouseclick == 0){
				con.drawRect( 910,1 ,360,150);
				//draws a rectangle bordering the image if the mouse is on top of the image
			}
			//if the mouse is hovering over the feet to walk, the scene is switched to scene2
			else if (intmousex < 150 && intmousey < 390 && intmouseclick == 0){
				con.drawRect(0,1 ,120, 390);
				//draws a rectangle bordering the image if the mouse is on top of the image
			}	
			else {
				scene1(con);
				//prints the image in scene1
			}
			if (intmousex > 910 && intmousey < 150 && intmouseclick == 1){
				intcount = 2;
				//if the image is clicked, switch the scene
			}
			if (intmousex < 150 && intmousey < 390 && intmouseclick == 1){
				intcount = 3;
				//if the image is clicked, switch the scene
			} 
		
		}
		
		//Scene 2
		if (intcount == 2){
			scene2(con);
			//prints scene2, an ending
		}
		//Scene 3
		while (intcount == 3){
			scene3(con);
			//found that often users misinterpret the question put in scene3, made a loop to make sure they don't have to restart
			strrun = con.readLine();
			if (strrun.equals("left")){
				intcount = 5;
			}	
			//plays a different scene depending on the user input
			if (strrun.equals("right")){
				intcount = 4;
			}
		}
		//intcount demonstrating that it is the main variable for the story
		
		//Scene 4
		if (intcount == 4){
			scene4(con);
			//draws the scene in scene 4
			con.println("What angle is the banana peel thrown?");
			dblangle = con.readDouble(); 
			//user inputs a value for the equation
			dblangle = (dblangle * 3.14) / 180;
			//converted into radiens because Math.sin() uses radians
			con.println("What velocity is the banana peel thrown?");
			dblvelocity = con.readDouble();
			//user input for the velocity
			dbluserdist = ((dblvelocity * dblvelocity) * Math.sin(2*dblangle))/9.81;
			//the range equation, distance = (velocity^2 * sin(2angle))/9.81
			//uses the users input to see if the target destination is reached
			if (dbluserdist > 8 && dbluserdist <12){
				intcount = 7;
				//if the distance reacehed is between 8 and 12, the bird is hit to make the test easier for the player
			}
			else if (dbluserdist <= 8){
				intcount = 6;
				//if the shot was undershot, change intcount to 6
			}
			else {
				intcount = 8;
				//if the shot was overshot, change the intcount to 7
			}
		
		}
		//Scene 5
		while (intcount == 5){
			//in loop format so multiple random ints can happen incase the user isn't lucky
			scene5(con);
			//draws scene5
			intrandom = (int)( Math.random()*6+1);
			//random integer from 1-6 because a dice is used
			intuser = con.readInt();
			//gathers the users input
			if (intuser == intrandom){
				intcount = 14;
				//if the user input and the random integer is the same, progress the story, else reloop
			}
		}
		//Scene 6
		if (intcount == 6){
			scene6(con);
			//prints the scene, if statement determines if the scene is meant to be played
		}
		
		//Scene 7
		if (intcount == 7){
			scene7(con);
			//prints the scene, if statement determines if the scene is meant to be played
		}
		//Scene 8
		while (intcount == 8){
			//looping the commands is neccasary for the charcurrent command, the if statement below can only happen once so their is a counter to make sure it does
			if (intcounter1 == 0){
				scene8(con);
				//intcounter1 starts as 0 to and is equal to 1 to make sure the if statement only happens once
				//plays an animation
				intcounter1=1;
			}
			charcurrent = con.currentChar();
			//reads the current input of the player
			if (charcurrent == ('a')){
				intcount = 9;
				//if the current key pressed is "a"
			}
			if (charcurrent == ('d')){
				intcount = 10;
				//if the current key pressed is "d"
			}
		}
		//Scene 9
		if (intcount == 9){
			scene9(con);
			//prints the scene if the story variable is equal to 9
		}
		//Scene 10
		if (intcount == 10){
			scene10(con);
			//prints the scene if the story variable is equal to 9
			while (intpalindromecheck == 0){
				//intpalindromecheck is used to make sure the user has inputted a palindrome, if the user has not, the code runs
				intcorrelationcount = 0;
				//sets the correlation count to 0 every loop of the code
				strpalinedrome =con.readLine();
				//user inputted string, to be tested later if it is or isn't a variable
				intstrlength = strpalinedrome.length();
				//the strlength is set the length of the user inputted string to be used as a counter later 
				intdromecount = 0;
				//resets another counter used in the code
				while (intstrlength > 0){
					//intstrlength is reduced each time by one for each individual letter
					strsub = strpalinedrome.substring(intstrlength-1, intstrlength);
					//assigns the letter from the end of the word to strsub
					strsub2 = strpalinedrome.substring(intdromecount,intdromecount + 1);
					//assigns the letter from the start of theword to strsub2
					if (strsub.equals(strsub2)){
						intcorrelationcount  = intcorrelationcount + 1;
					//if the letters are the same, that is one correlating letter
					}
					if (intcorrelationcount == strpalinedrome.length()){
						intpalindromecheck = 1;
						//if one half of the letters is equal to the other half of the word reversed, change the scene and stop the loop at the start
						intcount = 11;
					}
					intstrlength = intstrlength -1;
					intdromecount =	intdromecount + 1;
					//intstrlength decreases to both function as a loop and to read the letter to left of the last and so on.
					//intdromecount increases to read the letter right of the first and so on
					
				}
			}
		}
		//Scene 11
		if (intcount == 11){
			scene11(con);
			//prints the scene if the story variable is equal to 11
			intmonkeycount = con.readInt();
			//4 or more monkeys are required to beat the bird, user inputs a number and that number is assigned to the variable "intmonkeycount"
			if (intmonkeycount < 4){
				intcount = 12;
				//if the number of monkeys is below 4, you go to a losing screen
			}
			else {
				//if there is 4+ monkeys, you go ot a win screen
				intcount = 13;
			}
			
		}
		//Scene 12
		if (intcount == 12){
			//prints the scene if the story variable is equal to 12
			scene12(con);
		}
		//Scene 13
		if (intcount == 13){
			//prints the scene if the story variable is equal to 13
			scene13(con);
		}
		//Scene 14
		if (intcount == 14){
			//prints the scene if the story variable is equal to 14
			scene14(con);
			dbltime = con.readDouble();
			//assigns the user inputted value to dbltime for later use
			intcount = 15;
		}
		//Scene 15
		if (intcount == 15){
			//prints the scene if the story variable is equal to 15
				scene15(con);
				con.println("Monkey eats 1000 bananas in "+dbltime+" minitues or "+1000/dbltime+" bananas per minute");
				con.println("Monkey is full and falls asleep, The End.");
				//prints the text above and uses the variable dbltime from before to do some math
		}
	}
	
	public static void start(Console con){
		BufferedImage imgstart = con.loadImage("start.png");
		//renders images
		con.drawImage(imgstart,0,0);
		con.repaint(); 
		//makes sure the drawn image is visible
	 }
	 
	public static void scene1(Console con){
		
		//clears all past text
		BufferedImage imgscene = con.loadImage("scene1.png");
		//renders images
		con.drawImage(imgscene,0,0);con.repaint();
		//no con.clear statement because no prior text
		con.clear();
		con.println("Monkey is the name of the main character");
		con.println("Monkey spots a banana in the distance and wants it!");
		con.println("Does he walk or swing to the banana, click your choice");
		//prints the following text
		con.repaint();
		//makes sure the drawn image is visible
	}
	
	public static void scene2(Console con){
		con.clear();
		//clears all past text
		int intbirdposx;
		int intbirdposy = 150;
		int intcount = 2;
		//integers used to animate the bird
		BufferedImage imgscene = con.loadImage("scene2.png");
		BufferedImage imgbird = con.loadImage("bird.png");
		//renders images
		for(intbirdposx=1; intbirdposx<600;intbirdposx++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbird,intbirdposx,intbirdposy);
			//draws the new images
			con.repaint();
			intbirdposx= intbirdposx+5;
			//changes the birds position
			con.repaint();
			con.sleep(5);
		}
		//when the for loop is done, prints the following text
		con.println("A bird got it first, you lost, Monkey is sad");
	}
	
	public static void scene3(Console con){
		con.clear();				
		//clears all past text
		BufferedImage imgscene = con.loadImage("scene3.png");
		//renders all the images and draws the scene
		con.drawImage(imgscene,0,0);
		con.println("Enter left or right via typing, left is forest, right is rock.");
		con.repaint();
	}
	
	public static void scene4(Console con){
		con.clear();
		//clears all past text
		con.setTextColor(new Color(21,60,43));
		
		//sets the text color to red to make it easier to see in some scenes
		BufferedImage imgscene = con.loadImage("scene4.png");
		//renders all the images and draws the scene
		con.drawImage(imgscene,0,0);
		con.println("Monkey wants to throw a banana peel at a bird.");
		con.println("If bird is on the same height and 10 meters away.");
		con.println("What are the numbers needed to hit the bird?");
		con.println("Use the range formula");
		//prints all of the above text to inform the player what to do
		//the range formula is distance = (velocity^2 * sin(2θ))/9.81
		con.repaint();
	}

	public static void scene5(Console con){
		con.clear();
		//clears all past text
		BufferedImage imgscene = con.loadImage("scene5.png");
		con.drawImage(imgscene,0,0);
		//renders all the images and draws the scene
		con.println("Gambling monkeys, 1/6 chance to get 1000 bananas, input a number from 1 to 6.");
		con.repaint();
	}
	
	public static void scene6(Console con){
		con.clear();
		//clears all past text
		BufferedImage imgscene = con.loadImage("scene6.png");
		//renders all the images and draws the scene
		BufferedImage imgbanana = con.loadImage("banana1.png");
		con.drawImage(imgscene,0,0);
		int intbanana;
		int intcount;
		//integers for animation, going to be used for the banana coordinates
		for (intbanana=500; intbanana < 700; intbanana++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbanana,intbanana,700 - intbanana);
			con.repaint();
			con.sleep(5);
			//banana goes to the left and rises
		}
		for (intbanana = 700; intbanana < 900 ; intbanana++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbanana,intbanana,intbanana - 700);
			con.repaint();
			con.sleep(5);
			//banana goes to the left and lowers
		}
		//Doesn't hit the bird
		con.println("Monkey undershot, monkey sad, monkey sleeps, the end.");
	}
	
	public static void scene7(Console con){
		con.clear();
		//clears all past text
		int intbanana;
		int intcount;
		int intcount1;
		//uses integers for animation, int banana and intcount
		BufferedImage imgbanana = con.loadImage("banana.png");
		BufferedImage imgmonkeytime = con.loadImage("monkeytime.png");
		BufferedImage imgscene = con.loadImage("scene4.png");
		BufferedImage imgscene7 = con.loadImage("scene7,1.png");
		//renders all the images and draws the scene
		con.drawImage(imgscene,0,0);
		for (intbanana=500; intbanana < 700; intbanana++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbanana,intbanana,700 - intbanana);
			con.repaint();
			con.sleep(5);
			//the banana goes up and to the left until it reaches an x-coordinate 700
		}
		for (intbanana = 700; intbanana < 900 ; intbanana++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbanana,intbanana,intbanana - 700);
			con.repaint();
			con.sleep(5);
			// the banana falls and goes to the left until the an x-coordinate of 900 is reached
		}
		//the banana eventually reaches the bird 
		con.println("the end, monkey is now king");
		for (intcount1 = 0; intcount1 < 50; intcount1++){
			for (intcount =0; intcount < 10; intcount++){
				con.drawImage(imgscene7,0,0);
				con.drawImage(imgmonkeytime,0,intcount);
				con.repaint();
				con.sleep(5);
			}	
			for (intcount =0; intcount < 10; intcount++){
				con.drawImage(imgscene7,0,0);
				con.drawImage(imgmonkeytime,0,10 - intcount);
				con.repaint();
				con.sleep(5);
			}	
		}
		//these 2 for loops make the observing monkeys shake in applause, the are moved up and down rapidly and the monkey who threw the banana is crowned
	}
	
	public static void scene8(Console con){
		con.clear();
		//clears all the text previously printed
		int intbanana;
		//used as an x-coordinate for the banana image
		BufferedImage imgbanana = con.loadImage("banana2.png");
		BufferedImage imgscene = con.loadImage("scene8.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		for (intbanana=500; intbanana < 900; intbanana++){
			con.drawImage(imgscene,0,0);
			//prints the scene then the banana to make sure changes are clear
			con.drawImage(imgbanana,intbanana,900 - intbanana);
			con.repaint();
			//con.sleep is used to make the animation clean, 5ms was used because I think it looks nice
			con.sleep(5);
			//the banana goes up as intbanana raises, and goes to the left until intbanana = 900
		}
		for (intbanana = 900; intbanana < 1200 ; intbanana++){
			con.drawImage(imgscene,0,0);
			con.drawImage(imgbanana,intbanana,intbanana - 900);
			//the banana goes down as intbanana raises, and goes to the left until intbanana = 1200
			con.repaint();
			con.sleep(5);
		}
		con.println("The banana was overshot, the bird is now angry");
		con.println("Press 'a' key to run to a clear landscape, or 'd' to a cave");
		con.repaint();
	}
	
	public static void scene9(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene9.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		con.println("Monkey enters a clear area, and is taken down by the bird");
		con.println("The end");
		con.repaint();
	}
	
	public static void scene10(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene10.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		con.setTextColor(Color.WHITE);
		//sets the textcolor to white
		con.println("Monkey got into a cave");
		con.println("He has a paper airplane");
		con.println("Write a palidrome to summon monkeys to your area");
		con.println("The monkeys will sense for intelligent life and know");
		//prints all the above text
		con.repaint();
	}
	
	public static void scene11(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene11 = con.loadImage("scene11.png");
		//renders the image scene and prints it
		con.drawImage(imgscene11,0,0);
		con.println("The group of monkeys got your message");
		con.println("How many monkeys do you want to come?");
		//prints all of the text above
		con.repaint();
	}
	
	public static void scene12(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene12.png");
		Font fntdebrose = con.loadFont("debrose.ttf",55);
		//makes drawstring font equal to the font downloaded
		con.drawImage(imgscene,0,0);
		con.println("You summoned way to little monkeys to fight");
		con.println("The monkeys lost, the bird won");
		con.setDrawFont(fntdebrose);
		//the drawfont is set to the downloaded font
		con.drawString("Game Over",640,360);
		//draws the string "Game Over at coordinates 640,360
		con.repaint();
	}
	
	public static void scene13(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene13.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		con.println("You summoned enough monkeys to fight");
		con.println("The monkeys defeated the bird, The End");
		//prints the above text and con.repaint makes sure the image was drawn
		con.repaint();
	}
	
		public static void scene14(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene14.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		con.println("You won the thousand bananas!!! how fast do you eat them all in minutes?");
		//prints the above text
		con.repaint();
		//makes sure the image is printed
	}
	
	public static void scene15(Console con){
		con.clear();
		//clears all the text previously printed
		BufferedImage imgscene = con.loadImage("scene15.png");
		//renders the image scene and prints it
		con.drawImage(imgscene,0,0);
		con.repaint();
		//makes sure the image is printed
	}
}


