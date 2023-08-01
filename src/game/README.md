# ROCKET GAME
CSC 171 Project 3
Drone Pilot Game

*Sometimes Swing has problem rendering graphics, if blank screen occurs, please try re-run the program.

<br />

### *Controls*
Player 1:\
w: Accelerate\
a: turn left\
d: turn right

Player 2 (Optional):\
ArrowKey 
Up: Accelerate\
Left: turn left\
Right: turn right

***To properly accelerate, you need to type/pressdown and release acceleration key repeatly 
** DO NOT HOLD DOWN THE KEYS* 

<br />

#### *Goals and Mechanics:* 
The goal of the game is to land the rocket correctly(Head First from coming from the top of the landing zone) in order to enter the next level and score as many points as possible. 

If you lost a life, -25 score
If you pass level, + 100 score
If you retrieved star, +35 score
If you retrieved star but didnot pass level, you do not ear the points for retrieving the star and -25 score occur for losing a life.

To start, run **Firstpage.java**, which includes the main program to the game. After the game load up, choose single or double player mode. 

<br />

# TEAM 

### Members/Contributors: 

Weile Zheng - wzheng13@u.rochester.edu\
Peter Nie - jnie7@u.rocester.edu\
Jinglin Zheng - jzheng20@u.rochester.edu\
Shiyou Li - sli121@u.rochester.edu

<br />

# CLASS DESCRIPTIONS
## Firstpage
Extends JFrame. Main program, contains button for different gamemode and pages.

## Rocket
Rocket class, includes all instance variables necessary and drawrocket method for animation. 

## RocketPanel1p
Extends JPanel for single player mode. This will be added on top of the main frame if single player is chosen.

## RocketPanel2p
Extends RocketPanel1p, adds another set of keylistner and rocket for two player mode. Please note that 2 player mode scores are not recorded in the scoreboard. Also, star rewards are not implemented in 2 player mode, please download extension to experience the feature in the next update.

## Fuel
Fuel decrease when acceleration key is been pressed. Running out of fuel will result in rocket unable to accelerate. 

## sObstacles
Obstacles will be drawn at random. 

## Bonus(Star)
Floating star with a random path at each level. Bonus gives a good increase in total score. 

## Scoreboard
Extends JLabel. Scoreboard Label will be added on top of the main frame if *Scoreboard* button is being clicked.

## Music
Extends Thread. Play music in the background from a file.

## Credit
Extends JDialogue. Includes informations about game creators.

<br />

# FLOURISHES
### Main Menu
- A nice-looking main menu to choose between gamemodes, leaderboard page, and a elegant exit. 
- Returning to main menu during a running game is smooth and re-entering the gameplay will start the game from beginning. Allowing a way to restart without the need of quitting the program.
- Implemented by using JFrame that extends ActionListener for its buttons and KeyListener. A new JPanel will be added or removed to the frame base on the button pressed.  The key listeners are also used to add and remove frames but used in jumping between levels and runs.

### Leader Board System
- Can be accessed through main menu. List the top 5 highest score. Scoreboard will be reset if program ends. 
- Implemented by extending JLabel and take in an ArrayList of all recorded scores from the main program. The list begin with 5 zero scores by default. The leaderboard will then sort the ArrayList and take the top five score as needed.

### Duo Player
-  Grab a friend and play together! Choose duo player mode from the main menu. Two rockets, red and blue, can be controlled by two set of keys.
- If any one player reaches the target and land successfully, the level will be passed
- If both player dies, the level does not get passed. If both player still have **lifes** left, the game is not over. If only one player has **life** , the game essentially turns into a single player. If both player have no more **life**, game ends.
- Implemented by having RocketPanel2p extend RocketPanel1p and overrides its keylistener methods for two players. The main JFrame also have a system of tracking whether single player or double player game is being runned to execute methods accordingly/

```
private boolean mprunning = false;
private boolean mp2running = false;
```

### Music 
- Background music starts with the game and will continue to loop until quit.
- Implemented by extending a thread to run concurrently with the main program. Terminates as main program ends.

```
public class Music extends Thread {
		String songpath = "src/game/music.wav";
	
	public void run() {
		try {
		File file = new File(songpath);
		AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInput);
		clip.start();
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch(Exception e) {
			System.out.println("Audio Playing Error");
		}

	}
}
```
<br />

### Immovable Objects
- Run through the stars to earn a bonus of 35 points. If you lost a life and points as a consequence, try to earn more star bonus points to get back into the game.
- Implemented by drawing a star on the screen. If rocket x and y get into a certain range as the star's x, y coordinate, the star will be retrieved.

<br />

### Pop-Up Window
- Contributor Acknowledgment and Credit information can be found in menu page. 
- Implemented by extending JDialogue and adding JLabels onto it.

<br />

