
// -----------------------------------------------------
//Assignment # 1
// Written by :  Lachezara Lazarova (40211033) and Djouher Alili (40129927) 
// Description : 
// This program will allow 2 to 4 users to play Ladder and Snake. 
// Users have 3 attempts to input the correct number of players, or the game will terminate. 
// A first flip will happen in order to decide the order. 
// The player with the biggest dice value will start first and so on.
// As the game progresses, the first player to achieve the 100th square wins. 
// -----------------------------------------------------

/** importing scanner */
/**
* @author Djouher Alili
* @authorLachezara Lazarova
*
**/
import java.util.Scanner;

/** creating a class named PlayLadderAndSnake */
public class PlayLadderAndSnake {
	
	/**creating a class named main */ 
	public static void main(String[] args) {

		// Create a scanner object
		Scanner scan = new Scanner(System.in);
		
		// Declaring and initializing variables 
		String z;
		int square;

		// object for ladder and snake
		LadderAndSnake playingLandS = new LadderAndSnake();
		
		// Welcome message 
		System.out.println(" \t\t\tWelcome to Ladder and Snake!\t");
		System.out.println( "\nThis game was created by Lachezara Lazarova and Djouher Alili. We hope you have fun !\n");

		// prompts user to input the  number of players 
		System.out.println("Please, enter the number of players for your game - Number must be between 2 and 4 inclusively: ");
		int NbofPlayers = scan.nextInt();

		int attempt = 1;
		// this while loop makes sure  the correct # of players is within 2-4. And offers 3 attempts to user to prompt a valid number. 
		while ((NbofPlayers > 4 || NbofPlayers < 2) && attempt <= 4) {

			switch (attempt) {

			case (1):

			case (2):
				System.out.println("Bad attempt " + attempt
						+ "- Invalid number of players. Please enter a number between 2 and 4 inclusively:");
				NbofPlayers = scan.nextInt();
				attempt++;
				break;

			case (3):
				System.out.println("Bad attempt " + attempt + "- Invalid number of players. "
						+ "Please enter a number between 2 and 4 inclusively. This is your last attempt:");
				NbofPlayers = scan.nextInt();
				attempt++;
				break;

			case (4):
				System.out.println("Bad attempt " + attempt + "! You have exhausted all your chances. "
						+ "Program will terminate!");
				System.exit(0);
			} // switch system

		} // while loop
		
		// confirms the number of players to user 
		System.out.println("Thank you. The number of players is " + NbofPlayers + ".\n");

		// creating a 2D array to keep track of each player information 
		String[][] Players = new String[4][NbofPlayers];

		// prompts user to input a name of 5 characters for the # of players 
		for (int i = 1; i <= NbofPlayers;) {
			System.out.println("Please enter the name of Player " + i + " (The name must contain 5 characters) :");
			--i;
			Players[0][i] = scan.next();
			while (Players[0][i].length() != 5) {
				System.out.println("Please try again with the correct number (5) of characters.");
				Players[0][i] = scan.next();
			}
			i += 2;
		}
		
		// Declaring the number of players 
		System.out.print("The players are : ");
		for (int j = 0; j < NbofPlayers; j++) {
			System.out.print(Players[0][j] + ", ");
		}
		// informing user, we entered the sorting part 
		System.out.println("\n\nNow deciding which player will start playing!");
		
		// Declaring the dice value of each player 
		for (int j = 0; j < NbofPlayers; j++) {
			int dice = playingLandS.RandomDice();
			Players[1][j] = String.valueOf(dice);
			System.out.println(Players[0][j] + " got a dice value of " + Players[1][j]);
		}
		
		// This switch will apply a sorting based on the number of players
		switch (NbofPlayers) {
		
		// If we have 2 players 
		case 2:
			
			// If each player gets the same value of dice 
			if ((Players[1][0].equals(Players[1][1]))) {

				System.out.println("\nA tie was achieved between " + Players[0][0] + " and " + Players[0][1]
						+ ". Attempting to break the tie.");
				int dice = playingLandS.RandomDice();

				// This do-while loop will keep on happening until a different value is assigned for each player 
				do {
					Players[1][0] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][1] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
				}

				while ((Players[1][0].equals(Players[1][1])));
				
				// Prints the final and different values for each player 
				System.out.println("Now, " + Players[0][0] + " got a dice value of " + Players[1][0]);
				System.out.println("Now, " + Players[0][1] + " got a dice value of " + Players[1][1]);
				System.out.println("\nThe final value for " + Players[0][0] + " is " + Players[1][0] + ", and for "
						+ Players[0][1] + " it is " + Players[1][1] + ".");

			} // closes if statement
			
			// if the values of dice are different from the start, this will  display the result for each player  
			else
				System.out.println("\nThe final value for " + Players[0][0] + " is " + Players[1][0] + ", and for "
						+ Players[0][1] + " it is " + Players[1][1] + ".");

			// this  will sort which player starts first 
			// if the first player has the biggest value, no  change 
			if (Integer.parseInt(Players[1][0]) > Integer.parseInt(Players[1][1])) 
				System.out.println("\nReached final decision on order of playing: " + Players[0][0] + " , " + Players[0][1]);
			
			// else it will interchange 
			else {
				String min = Players[0][0];
				String max = Players[0][1];
				Players[0][0] = max;
				Players[0][1] = min;
				System.out.println("\nReached final decision on order of playing: " + Players[0][0] + " , " + Players[0][1]);
			}
			
			// case 2 finished 
			break;

		// if there are 3 players 
		case 3:

			// to check if there is a tie between all the 3
			// declaring and initializing variables
			Boolean tie = false;
			
			// if all the  values are equal for the players
			if ((Players[1][0].equals(Players[1][1]) && (Players[1][0].equals(Players[1][2])))
					&& (Players[1][2].equals(Players[1][2]))) {
				
				// display to user that a tie was achieved between all 3 of them 
				System.out.println("\nA tie was achieved between " + Players[0][0] + " and " + Players[0][1] + " and "
						+ Players[0][2] + ". Attempting to break the tie.");
				int dice = playingLandS.RandomDice();
				
				//this do-while loop occurs until a different value is provided for each player
				do {
					Players[1][0] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][1] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][2] = String.valueOf(dice);
				}

				while ((Players[1][0].equals(Players[1][1]) && (Players[1][0].equals(Players[1][2])))
						&& (Players[1][1].equals(Players[1][2])));
				
				// displays the  distinct and final values for each player 
				System.out.println("Now, " + Players[0][0] + " got a dice value of " + Players[1][0]);
				System.out.println("Now, " + Players[0][1] + " got a dice value of " + Players[1][1]);
				System.out.println("Now, " + Players[0][2] + " got a dice value of " + Players[1][2]);

				tie = false;

			} // closes if statement

			// if  between the 3 players, there are 2 that tie, this for loop will find it 
			for (int i = 0; i < NbofPlayers; i++) {
				for (int m = NbofPlayers - 1; m >= i; m--) {
					if (Players[1][i].equals(Players[1][m]) && i != m) {
						
						// displays to user which player tied 
						System.out.println("\nA tie was achieved between " + Players[0][i] + " and " + Players[0][m]
								+ ". Attempting to break the tie.");
						tie = true;
						int dice = playingLandS.RandomDice();
						
						// this do while loop will occur until all the  pair of players  get distinct  value 
						do {
							Players[1][i] = String.valueOf(dice);
							dice = playingLandS.RandomDice();
							Players[1][m] = String.valueOf(dice);
						} // do statement

						while (Players[1][i].equals(Players[1][m]));
						
						// displays the final and distinct values for each player 
						System.out.println("Now, " + Players[0][i] + " got a dice value of " + Players[1][i]);
						System.out.println("Now, " + Players[0][m] + " got a dice value of " + Players[1][m]);


						// this will help sort the 3 players. The player not part of the tie will be first, and between those that tied
						// the player with the biggest value will be second.
						for (int y = 0; y < 3; y++) {
							
							// y is the player that didn't tie, automatically it is the first 
							//declaring and initializing values for sorting  
							String first = "";
							String second = "";
							String third = "";
							
							//  this will sort such that : if  m player > i player, then m= second player  and i= third player
							if (Integer.parseInt(Players[1][m]) > Integer.parseInt(Players[1][i]) && i != m && y != m
									&& y != i) {
								first = Players[0][y];
								second = Players[0][m];
								third = Players[0][i];

								Players[0][0] = first;
								Players[0][1] = second;
								Players[0][2] = third;
								System.out.println("\nReached final decision on order of playing: " + Players[0][0]
										+ ", " + Players[0][1] + ", " + Players[0][2]);
								break;
							}

							//  this will sort such that : if  i player > m player, then i= second player  and m= third player
							else if (Integer.parseInt(Players[1][m]) < Integer.parseInt(Players[1][i]) && i != m
									&& y != m && y != i) {
								first = Players[0][y];
								second = Players[0][i];
								third = Players[0][m];

								Players[0][0] = first;
								Players[0][1] = second;
								Players[0][2] = third;
								System.out.println("\nReached final decision on order of playing: " + Players[0][0]
										+ ", " + Players[0][1] + ", " + Players[0][2]);
								break;

							} // else if statement
						} // for y statement closed
					} // if a pair of players is equal statement closed 
				} // second for ( int m )  statement closed 
			} // first for ( int i)   statement closed 
			
			// sorting if all the values are different
			if (tie == false) {

				String first = "";
				String second = "";
				String third = "";

				// if the first player has the biggest values of the 3  
				if ((Integer.parseInt(Players[1][0]) > Integer.parseInt(Players[1][1]))
						&& (Integer.parseInt(Players[1][0]) > Integer.parseInt(Players[1][2]))) {
					first = Players[0][0];
					second = Players[0][1];
					third = Players[0][2];


					// 0, 1, 2 is the automatic sorting. Thus, an if statement is not required 
					// therefore : 0 , 2 , 1 , third player's value > second player's value 
					if (Integer.parseInt(Players[1][1]) < Integer.parseInt(Players[1][2])) {
						Players[0][1] = third;
						Players[0][2] = second;
					}

					// displays the final sorting for this case 
					System.out.println("\nReached final decision on order of playing: " + Players[0][0] + ", "
							+ Players[0][1] + ", " + Players[0][2]);
				}
				
				// if the second player has the biggest values of the 3  
				else if ((Integer.parseInt(Players[1][1]) > Integer.parseInt(Players[1][0]))
						&& (Integer.parseInt(Players[1][1]) > Integer.parseInt(Players[1][2]))) {
					first = Players[0][0];
					second = Players[0][1];
					third = Players[0][2];

					Players[0][0] = second;

					// here : 1, 0, 2,  first player's value > third player's value 
					if (Integer.parseInt(Players[1][0]) > Integer.parseInt(Players[1][2])) {
						Players[0][1] = first;
						Players[0][2] = third;
						
						// displays the final sorting for this case 
						System.out.println("\nReached final decision on order of playing: " + Players[0][0] + ", "
								+ Players[0][1] + ", " + Players[0][2]);
					}

					// here : 1, 2, 0,  first player's value < third player's value 
					if (Integer.parseInt(Players[1][0]) < Integer.parseInt(Players[1][2])) {
						Players[0][1] = third;
						Players[0][2] = first;
						
						// displays the final sorting for this case 
						System.out.println("\nReached final decision on order of playing: " + Players[0][0] + ", "
								+ Players[0][1] + ", " + Players[0][2]);
					}
					// if the third  player has the biggest values of the 3  
				}

				else if ((Integer.parseInt(Players[1][2]) > Integer.parseInt(Players[1][0]))
						&& (Integer.parseInt(Players[1][2]) > Integer.parseInt(Players[1][1]))) {
					first = Players[0][0];
					second = Players[0][1];
					third = Players[0][2];

					Players[0][0] = third;

					// here : 2, 0, 1, first player's value > second  player's value
					if (Integer.parseInt(Players[1][0]) > Integer.parseInt(Players[1][1])) {
						Players[0][1] = first;
						Players[0][2] = second;
						
						// displays the final sorting for this case 
						System.out.println("\nReached final decision on order of playing: " + Players[0][0] + ", "
								+ Players[0][1] + ", " + Players[0][2]);
					}

					// here : 2, 1, 0 , first player's value < second  player's value  
					if (Integer.parseInt(Players[1][0]) < Integer.parseInt(Players[1][1])) {
						Players[0][2] = first;
						
						// displays the final sorting for this case 
						System.out.println("\nReached final decision on order of playing: " + Players[0][0] + ", "
								+ Players[0][1] + ", " + Players[0][2]);
					}
				}
			}

			break; // end of the case 3 
		// if the number of players is 4	
		case 4:
			// declaring and initializing variables
			boolean three_different = false, tieoftwo = false;
			tie = false;

			// if initially  the users  get 4 identical values , this for loop will happen until all are distinct 
			if ((Players[1][0].equals(Players[1][1]) && (Players[1][0].equals(Players[1][2])))
					&& (Players[1][0].equals(Players[1][3])) && (Players[1][1].equals(Players[1][2]))
					&& (Players[1][1].equals(Players[1][3])) && (Players[1][2].equals(Players[1][3]))) {
				
				// informs users  they have tied
				System.out.println("\nA tie was achieved between " + Players[0][0] + " and " + Players[0][1] + " and "
						+ Players[0][2] + " and " + Players[0][3] + ". Attempting to break the tie.");
				int dice = playingLandS.RandomDice();
				do {
					Players[1][0] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][1] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][2] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][3] = String.valueOf(dice);
				}

				while ((Players[1][0].equals(Players[1][1]) && (Players[1][0].equals(Players[1][2])))
						&& (Players[1][0].equals(Players[1][3])) && (Players[1][1].equals(Players[1][2]))
						&& (Players[1][1].equals(Players[1][3])) && (Players[1][2].equals(Players[1][3])));
				// displays the distinct values obtained after the loop 
				System.out.println("Now, " + Players[0][0] + " got a dice value of " + Players[1][0]);
				System.out.println("Now, " + Players[0][1] + " got a dice value of " + Players[1][1]);
				System.out.println("Now, " + Players[0][2] + " got a dice value of " + Players[1][2]);
				System.out.println("Now, " + Players[0][3] + " got a dice value of " + Players[1][3]);
			}

			// if initially 2 pairs of users get the same values, this for loop will happen until all are distinct 
			if (((Players[1][0].equals(Players[1][1])) && (Players[1][2].equals(Players[1][3])))
					|| ((Players[1][0].equals(Players[1][2])) && (Players[1][1].equals(Players[1][3])))
					|| ((Players[1][0].equals(Players[1][3])) && (Players[1][1].equals(Players[1][2])))) {
				
				// informs users  which pairs  have tied
				System.out.println("\nA tie was achieved between " + Players[0][0] + " and " + Players[0][1] + " and "
						+ Players[0][2] + " and " + Players[0][3] + ". Attempting to break the tie.");
				int dice = playingLandS.RandomDice();
				do {
					Players[1][0] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][1] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][2] = String.valueOf(dice);
					dice = playingLandS.RandomDice();
					Players[1][3] = String.valueOf(dice);
				}

				while (((Players[1][0].equals(Players[1][1])) && (Players[1][2].equals(Players[1][3])))
						|| ((Players[1][0].equals(Players[1][2])) && (Players[1][1].equals(Players[1][3])))
						|| ((Players[1][0].equals(Players[1][3])) && (Players[1][1].equals(Players[1][2]))));
				// displays the distinct values obtained after the loop 
				System.out.println("Now, " + Players[0][0] + " got a dice value of " + Players[1][0]);
				System.out.println("Now, " + Players[0][1] + " got a dice value of " + Players[1][1]);
				System.out.println("Now, " + Players[0][2] + " got a dice value of " + Players[1][2]);
				System.out.println("Now, " + Players[0][3] + " got a dice value of " + Players[1][3]);
			}

			// if initially 3 players get the same value, this for loop will happen until all 3 are distinct 
			for (int r = 0; r <= 1; ++r) {
				for (int t = 1; t <= 2; ++t) {
					if (r == t)
						++t;
					for (int y = 2; y <= 3; ++y) {

						if (r == y || t == y)
							++y;

						if ((Players[1][r].equals(Players[1][t]) && (Players[1][r].equals(Players[1][y]))
								&& (Players[1][t].equals(Players[1][y])))) {
							// informs users which three  have tied 
							System.out.println("\nA tie was achieved between " + Players[0][r] + " and " + Players[0][t]
									+ " and " + Players[0][y] + ". Attempting to break the tie.");

							int dice;
							do {
								dice = playingLandS.RandomDice();
								Players[1][0] = String.valueOf(dice);
								dice = playingLandS.RandomDice();
								Players[1][1] = String.valueOf(dice);
								dice = playingLandS.RandomDice();
								Players[1][2] = String.valueOf(dice);

							}

							while ((Players[1][r].equals(Players[1][t]) || (Players[1][r].equals(Players[1][y])))
									|| (Players[1][t].equals(Players[1][y])));
							// displays to the three players the final and distinct values for each 
							System.out.println("Now, " + Players[0][r] + " got a dice value of " + Players[1][r]);
							System.out.println("Now, " + Players[0][t] + " got a dice value of " + Players[1][t]);
							System.out.println("Now, " + Players[0][y] + " got a dice value of " + Players[1][y]);

							// this will sort the players after the three that tied are now distinct 
							if (Players[1][r] != Players[1][t] && Players[1][r] != Players[1][y]
									|| Players[1][t] != Players[1][y]) {
								// declaring and initializing variables  
								String first = "";
								String second = "";
								String third = "";
								String fourth = "";

								// this for loop will put the one that  never tied first (m)  and will sort between the three that tied (r,t,y)
								for (int m = 0; m < NbofPlayers; m++) {
									if (m != t && m != r && m != y && r != y && r != t && t != y) {
										
										// if between r,t,y, r has the biggest value 
										if ((Integer.parseInt(Players[1][r]) > Integer.parseInt(Players[1][t]))
												&& (Integer.parseInt(Players[1][r]) > Integer
														.parseInt(Players[1][y]))) {
											// if t> y , therefore will get sorted as r,t,y
											if (Integer.parseInt(Players[1][t]) > Integer.parseInt(Players[1][y])) {
												first = Players[0][m];
												second = Players[0][r];
												third = Players[0][t];
												fourth = Players[0][y];

												Players[0][0] = first;
												Players[0][1] = second;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
											// if t < y , therefore will get sorted as r,y,t 
											if (Integer.parseInt(Players[1][t]) < Integer.parseInt(Players[1][y])) {
												first = Players[0][m];
												second = Players[0][r];
												Players[0][1] = second;
												third = Players[0][y];
												fourth = Players[0][t];

												Players[0][0] = first;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
										} // closed  the if for r

										// if between r,t,y, t has the biggest value 
										else if ((Integer.parseInt(Players[1][t]) > Integer.parseInt(Players[1][r]))
												&& (Integer.parseInt(Players[1][t]) > Integer
														.parseInt(Players[1][y]))) {
											// if r> y , therefore will get sorted as t,r,y
											if (Integer.parseInt(Players[1][r]) > Integer.parseInt(Players[1][y])) {
												first = Players[0][m];
												second = Players[0][t];
												third = Players[0][r];
												fourth = Players[0][y];

												Players[0][0] = first;
												Players[0][1] = second;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
											// if r < y , therefore will get sorted as t,y,r
											if (Integer.parseInt(Players[1][r]) < Integer.parseInt(Players[1][y])) {
												first = Players[0][m];
												second = Players[0][t];
												third = Players[0][y];
												fourth = Players[0][r];

												Players[0][0] = first;
												Players[0][1] = second;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
										} // of the if for r

										// if between r,t,y, y has the biggest value 
										else if ((Integer.parseInt(Players[1][y]) > Integer.parseInt(Players[1][r]))
												&& (Integer.parseInt(Players[1][y]) > Integer
														.parseInt(Players[1][t]))) {
											
											// if r> t , therefore will get sorted as y,r,t
											if (Integer.parseInt(Players[1][r]) > Integer.parseInt(Players[1][t])) {
												first = Players[0][m];
												second = Players[0][y];
												third = Players[0][r];
												fourth = Players[0][t];

												Players[0][0] = first;
												Players[0][1] = second;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
											// if r< t , therefore will get sorted as y,t,r
											if (Integer.parseInt(Players[1][r]) < Integer.parseInt(Players[1][t])) {
												first = Players[0][m];
												second = Players[0][y];
												third = Players[0][t];
												fourth = Players[0][r];

												Players[0][0] = first;
												Players[0][1] = second;
												Players[0][2] = third;
												Players[0][3] = fourth;
												// displays final sorting to user 
												System.out.println("\nReached final decision on order of playing: "
														+ Players[0][0] + ", " + Players[0][1] + ", " + Players[0][2]
														+ ", " + Players[0][3]);
												break;
											}
										}
									}
								}
							}
							three_different = true;
							tie = true;
							break;
						}
					}
				}
			}
			// declaring an initializing variable 
			int nbofpairs = 0;
			
			// this for loop will detect 2 players having the same value, but won't start if they went through the sorting above ( three_different == false)
			if ((three_different == false)) {
				for (int i = 0; i <= NbofPlayers / 2; i++) {
					for (int j = 1; j <= NbofPlayers - 1; j++) {

						if ((Players[1][i].equals(Players[1][j])) && i != j) {
							// informs the user which pair have tied 
							System.out.println("\nA tie was achieved between " + Players[0][i] + " and " + Players[0][j]
									+ ". Attempting to break the tie.");
							++nbofpairs;
							int dice = playingLandS.RandomDice();
							do {
								Players[1][i] = String.valueOf(dice);
								dice = playingLandS.RandomDice();
								Players[1][j] = String.valueOf(dice);
							}

							while (Players[1][i].equals(Players[1][j]));
							// informs user of the now 2 distinct values obtained for the two players 
							System.out.println("Now, " + Players[0][i] + " got a dice value of " + Players[1][i]);
							System.out.println("Now, " + Players[0][j] + " got a dice value of " + Players[1][j]);

						} // if statement
						int y = 0;
						int m = 0;

						// this if loop will sort the players, after those that tied now have a distinct value 
						if (nbofpairs == 1) {
							if ((i != j) && !(Players[1][i].equals(Players[1][j]))) {
								if (i == 0 && j == 1) {
									m = 2;
									y = 3;
								} 
								else if (i == 0 && j == 2) {
									m = 1;
									y = 3;
								} 
								else if (i == 0 && j == 3) {
									m = 1;
									y = 2;
								} 
								else if (i == 1 && j == 2) {
									m = 0;
									y = 3;
								} 
								else if (i == 1 && j == 3) {
									m = 0;
									y = 2;
								}
								else if (i == 2 && j == 3) {
									m = 0;
									y = 1;
								}	
								// declaring and initializing variables 
								String first = "";
								String second = "";
								String third = "";
								String fourth = "";
								
								// this will make sure that  the loop takes into account the different players 
								// m  and y player didn't tie  and i and j did 
								if (m != i && m != j && y != i && y != j && y != m && y < 4) {
										
									// m> y  and i>j , therefore  order : m,y,i,j
									if ((Integer.parseInt(Players[1][m]) > Integer.parseInt(Players[1][y]))
											&& (Integer.parseInt(Players[1][i]) > Integer.parseInt(Players[1][j]))) {

										first = Players[0][m];
										second = Players[0][y];
										third = Players[0][i];
										fourth = Players[0][j];

										Players[0][0] = first;
										Players[0][1] = second;
										Players[0][2] = third;
										Players[0][3] = fourth;
										
										// displays the  order to user 
										System.out.println(
												"\nReached final decision on order of playing: " + Players[0][0] + ", "
														+ Players[0][1] + ", " + Players[0][2] + ", " + Players[0][3]);
										break;

									}
									// m> y  and i<j , therefore  order : m,y,j,i
									else if ((Integer.parseInt(Players[1][m]) > Integer.parseInt(Players[1][y]))
											&& (Integer.parseInt(Players[1][i]) < Integer.parseInt(Players[1][j]))) {

										first = Players[0][m];
										second = Players[0][y];
										third = Players[0][j];
										fourth = Players[0][i];

										Players[0][0] = first;
										Players[0][1] = second;
										Players[0][2] = third;
										Players[0][3] = fourth;
										// displays the  order to user 
										System.out.println(
												"\nReached final decision on order of playing: " + Players[0][0] + ", "
														+ Players[0][1] + ", " + Players[0][2] + ", " + Players[0][3]);
										break;
									}
									// m< y  and i>j , therefore  order : y,m,i,j
									else if ((Integer.parseInt(Players[1][m]) < Integer.parseInt(Players[1][y]))
											&& (Integer.parseInt(Players[1][i]) > Integer.parseInt(Players[1][j]))) {

										first = Players[0][y];
										second = Players[0][m];
										third = Players[0][i];
										fourth = Players[0][j];

										Players[0][0] = first;
										Players[0][1] = second;
										Players[0][2] = third;
										Players[0][3] = fourth;
										// displays the  order to user 
										System.out.println(
												"\nReached final decision on order of playing: " + Players[0][0] + ", "
														+ Players[0][1] + ", " + Players[0][2] + ", " + Players[0][3]);
										break;
									}
									// m< y  and i<j , therefore  order : y,m,j,i
									else if ((Integer.parseInt(Players[1][m]) < Integer.parseInt(Players[1][y]))
											&& (Integer.parseInt(Players[1][i]) < Integer.parseInt(Players[1][j]))) {

										first = Players[0][y];
										second = Players[0][m];
										third = Players[0][j];
										fourth = Players[0][i];

										Players[0][0] = first;
										Players[0][1] = second;
										Players[0][2] = third;
										Players[0][3] = fourth;
										// displays the  order to user 
										System.out.println(
												"\nReached final decision on order of playing: " + Players[0][0] + ", "
														+ Players[0][1] + ", " + Players[0][2] + ", " + Players[0][3]);
										break;
									}
									break;
								} // if m!=...
								tieoftwo = true;
								break;
							} // equal if statement
							break;
						}
					}
				}
			}
			// sorting if all the values are different from the start , and if no initial tie happened
			if ((tie == false) && (tieoftwo == false) && !(Players[1][0].equals(Players[1][1]) && !(Players[1][0].equals(Players[1][2])))
					&& !(Players[1][0].equals(Players[1][3])) && !(Players[1][1].equals(Players[1][2]))
					&& !(Players[1][1].equals(Players[1][3])) && !(Players[1][2].equals(Players[1][3]))) {

				int j = 0;
				for (int m = 0; m < 4; ++m) {
					for (int y = 0; y < 4; ++y) {
						if (m == y)
							++y;
						if (y == 4)
							break;
						for (int i = 0; i < 4; ++i) {
							if (i == m || i == y)
								++i;
							if (i == m || i == y)
								++i;
							if (i == 4)
								break;
							for (int r = 0; r < 4; ++r) {

								if (r != m && r != y && r != i) {
									j = r;

									if ( (Integer.parseInt(Players[1][m]) > Integer.parseInt(Players[1][y])) 
											&& (Integer.parseInt(Players[1][y]) > Integer.parseInt(Players[1][i]))
											&& (Integer.parseInt(Players[1][i]) > Integer.parseInt(Players[1][j])) ) {
										// displays the  order to user 
										System.out.println(
												"\nReached final decision on order of playing: " + Players[0][m] + ", "
														+ Players[0][y] + ", " + Players[0][i] + ", " + Players[0][j]);
										break;
								}
							}

						}
					}
				}
			}
			}
			break;
		}


		// initializing second row of the array to 0 which will be used to keep track of each players square #
		for (int column = 0; column < NbofPlayers; ++column) {
			Players[1][column] = "0";
		}

		// initializing second row of the array to 0 which will be used to keep track of each players row #
		for (int column = 0; column < NbofPlayers; ++column) {
			Players[2][column] = "0";
		}

		// initializing second row of the array to 0 which will be used to keep track of each players column #
		for (int column = 0; column < NbofPlayers; ++column) {
			Players[3][column] = "0";
		}
		
		// initializing the board
		char[][] board = {
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
				{'|', ' ', ' ', '1', '0', '0', '|', ' ', ' ', ' ', '9', '9', '|', ' ', ' ', ' ', '9', '8', '|', ' ', ' ', ' ', '9', '7', '|', ' ', ' ', ' ', '9', '6', '|', ' ', ' ', ' ', '9', '5', '|', ' ', ' ', ' ', '9', '4', '|', ' ', ' ', ' ', '9', '3', '|', ' ', ' ', ' ', '9', '2', '|', ' ', ' ', ' ', '9', '1', '|', ' ', ' ', 'T', 'h', 'e', ' ', 'L', 'a', 'd', 'd', 'e', 'r', 's', ':'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', 'F', 'r', 'o', 'm', ' ', 's', 'q', 'u', 'a', 'r', 'e', '-', '-', '>', 'T', 'o', ' ', 's', 'q', 'u', 'a', 'r', 'e'},
				{'|', ' ', ' ', ' ', '8', '1', '|', ' ', ' ', ' ', '8', '2', '|', ' ', ' ', ' ', '8', '3', '|', ' ', ' ', ' ', '8', '4', '|', ' ', ' ', ' ', '8', '5', '|', ' ', ' ', ' ', '8', '6', '|', ' ', ' ', ' ', '8', '7', '|', ' ', ' ', ' ', '8', '8', '|', ' ', ' ', ' ', '8', '9', '|', ' ', ' ', ' ', '9', '0', '|'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '1', '-', '-', '>', '3', '8'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '4', '-', '-', '>', '1', '4'},
				{'|', ' ', ' ', ' ', '8', '0', '|', ' ', ' ', ' ', '7', '9', '|', ' ', ' ', ' ', '7', '8', '|', ' ', ' ', ' ', '7', '7', '|', ' ', ' ', ' ', '7', '6', '|', ' ', ' ', ' ', '7', '5', '|', ' ', ' ', ' ', '7', '4', '|', ' ', ' ', ' ', '7', '3', '|', ' ', ' ', ' ', '7', '2', '|', ' ', ' ', ' ', '7', '1', '|', ' ', ' ', '9', '-', '-', '>', '3', '1'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '2', '1', '-', '-', '>', '4', '2'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '2', '8', '-', '-', '>', '8', '4'},
				{'|', ' ', ' ', ' ', '6', '1', '|', ' ', ' ', ' ', '6', '2', '|', ' ', ' ', ' ', '6', '3', '|', ' ', ' ', ' ', '6', '4', '|', ' ', ' ', ' ', '6', '5', '|', ' ', ' ', ' ', '6', '6', '|', ' ', ' ', ' ', '6', '7', '|', ' ', ' ', ' ', '6', '8', '|', ' ', ' ', ' ', '6', '9', '|', ' ', ' ', ' ', '7', '0', '|', ' ', ' ', '3', '6', '-', '-', '>', '4', '4'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '5', '1', '-', '-', '>', '6', '7'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '7', '1', '-', '-', '>', '9', '1'},
				{'|', ' ', ' ', ' ', '6', '0', '|', ' ', ' ', ' ', '5', '9', '|', ' ', ' ', ' ', '5', '8', '|', ' ', ' ', ' ', '5', '7', '|', ' ', ' ', ' ', '5', '6', '|', ' ', ' ', ' ', '5', '5', '|', ' ', ' ', ' ', '5', '4', '|', ' ', ' ', ' ', '5', '3', '|', ' ', ' ', ' ', '5', '2', '|', ' ', ' ', ' ', '5', '1', '|', ' ', ' ', '8', '0', '-', '-', '>', '1', '0', '0'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
				{'|', ' ', ' ', ' ', '4', '1', '|', ' ', ' ', ' ', '4', '2', '|', ' ', ' ', ' ', '4', '3', '|', ' ', ' ', ' ', '4', '4', '|', ' ', ' ', ' ', '4', '5', '|', ' ', ' ', ' ', '4', '6', '|', ' ', ' ', ' ', '4', '7', '|', ' ', ' ', ' ', '4', '8', '|', ' ', ' ', ' ', '4', '9', '|', ' ', ' ', ' ', '5', '0', '|', ' ', ' ', 'T', 'h', 'e', ' ', 'S', 'n', 'a', 'k', 'e', 's', ':'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', 'F', 'r', 'o', 'm', ' ', 's', 'q', 'u', 'a', 'r', 'e', '-', '-', '>', 'T', 'o', ' ', 's', 'q', 'u', 'a', 'r', 'e'},
				{'|', ' ', ' ', ' ', '4', '0', '|', ' ', ' ', ' ', '3', '9', '|', ' ', ' ', ' ', '3', '8', '|', ' ', ' ', ' ', '3', '7', '|', ' ', ' ', ' ', '3', '6', '|', ' ', ' ', ' ', '3', '5', '|', ' ', ' ', ' ', '3', '4', '|', ' ', ' ', ' ', '3', '3', '|', ' ', ' ', ' ', '3', '2', '|', ' ', ' ', ' ', '3', '1', '|'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '1', '6', '-', '-', '>', '6'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '4', '8', '-', '-', '>', '3', '0'},
				{'|', ' ', ' ', ' ', '2', '1', '|', ' ', ' ', ' ', '2', '2', '|', ' ', ' ', ' ', '2', '3', '|', ' ', ' ', ' ', '2', '4', '|', ' ', ' ', ' ', '2', '5', '|', ' ', ' ', ' ', '2', '6', '|', ' ', ' ', ' ', '2', '7', '|', ' ', ' ', ' ', '2', '8', '|', ' ', ' ', ' ', '2', '9', '|', ' ', ' ', ' ', '3', '0', '|', ' ', ' ', '6', '4', '-', '-', '>', '6', '0'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '7', '9', '-', '-', '>', '1', '9'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '9', '3', '-', '-', '>', '6', '8'},
				{'|', ' ', ' ', ' ', '2', '0', '|', ' ', ' ', ' ', '1', '9', '|', ' ', ' ', ' ', '1', '8', '|', ' ', ' ', ' ', '1', '7', '|', ' ', ' ', ' ', '1', '6', '|', ' ', ' ', ' ', '1', '5', '|', ' ', ' ', ' ', '1', '4', '|', ' ', ' ', ' ', '1', '3', '|', ' ', ' ', ' ', '1', '2', '|', ' ', ' ', ' ', '1', '1', '|', ' ', ' ', '9', '5', '-', '-', '>', '2', '4'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '9', '7', '-', '-', '>', '7', '6'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ', '9', '8', '-', '-', '>', '7', '8'},
				{'|', ' ', ' ', ' ', '0', '1', '|', ' ', ' ', ' ', '0', '2', '|', ' ', ' ', ' ', '0', '3', '|', ' ', ' ', ' ', '0', '4', '|', ' ', ' ', ' ', '0', '5', '|', ' ', ' ', ' ', '0', '6', '|', ' ', ' ', ' ', '0', '7', '|', ' ', ' ', ' ', '0', '8', '|', ' ', ' ', ' ', '0', '9', '|', ' ', ' ', ' ', '1', '0', '|'},
				{'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|'},
				{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
		};
		

		int k = 0;
		int j = 0;
		int turn = 0;
		square = 0;
		//while loop to write the names on the board, erase the names when needed and to calculate the correct square that the player is at
		while (k <= NbofPlayers) {

			// re-initializing the order of players to stay in bounds 
			if (j == NbofPlayers)
				j = 0;

			// initializing all needed values 
			int column = 0;
			int ArrayColumnNb = 0;
			int row = 0;

			// if statement to erase the names on the boards (after the first time everyone has played)
			if (turn >= NbofPlayers) {

				//making all necessary values into integers 
				square = Integer.parseInt(Players[1][j]);
				row = Integer.parseInt(Players[2][j]);
				ArrayColumnNb = Integer.parseInt(Players[3][j]);

				// for the rows 2-4-6-8-10 on the board
				if (row % 2 != 0) {

					int tempcolumn = ArrayColumnNb;
				
					for (; ArrayColumnNb <= 60; ++ArrayColumnNb) {
						if (ArrayColumnNb > tempcolumn + 4)
							break;

						//if there is already one name on the board erase part of it to write part of the other name 
						if (board[row][tempcolumn + 1] == ' ' && board[row][tempcolumn + 2] == '\\') {
							board[row][ArrayColumnNb + 2] = ' ';
							board[row][ArrayColumnNb + 3] = ' ';
							board[row][ArrayColumnNb + 4] = ' ';
							break;
						}
						if (board[row][tempcolumn + 2] == '\\') {
							board[row][ArrayColumnNb] = ' ';
							board[row][ArrayColumnNb + 1] = ' ';
							break;
						}
						//if there is only one name in the square 
						board[row][ArrayColumnNb] = ' ';
					}
				}

				// for rows 1-3-5-7-9 on the board
				else {
					column = 55;

					ArrayColumnNb = column - (6 * ((square % 10) - 1));

					if (square % 10 == 0)
						ArrayColumnNb = 1;

					for (column = ArrayColumnNb; column <= 60; ++column) {
						if (column > ArrayColumnNb + 4)
							break;

						//if there is already one name on the board erase part of it to write part of the other name 
						if (board[row][ArrayColumnNb + 1] == ' ' && board[row][ArrayColumnNb + 2] == '\\') {
							board[row][column + 2] = ' ';
							board[row][column + 3] = ' ';
							board[row][column + 4] = ' ';
							break;
						}
						if (board[row][ArrayColumnNb + 2] == '\\') {
							board[row][column] = ' ';
							board[row][column + 1] = ' ';
							break;
						}
						//if there is only one name in the square 
						board[row][column] = ' ';
					}
				}
			}

			int dice;

			//playing the dice and getting new square 
			dice = playingLandS.RandomDice();
			square = playingLandS.play(dice, Integer.parseInt(Players[1][j]));

			//declaring the dice value each player got 
			System.out.print("\n" + Players[0][j] + " got a dice value of " + dice);

			//declaring if the player got a ladder or a snake or more than 100
			if (Integer.valueOf(Players[1][j]) + dice == square)
				System.out.print("; so " + Players[1][j] + "+" + dice + "=" + square + "; now in square " + square + "\n");
			else if (Integer.valueOf(Players[1][j]) + dice > 100)
				System.out.print("; your square is more than 100, you need to get 100 exactly!; now in square " + square + "\n");
			else if (square > Integer.valueOf(Players[1][j]) + dice)
				System.out.print("; you hit a ladder :)!!; went to square " + (Integer.valueOf(Players[1][j]) + dice) + " and up to square " + square + "\n");
			else
				System.out.print("; you hit a snake :'(!!; went to square " + (Integer.valueOf(Players[1][j]) + dice) + " and down to square " + square + "\n");

			Players[1][j] = Integer.toString(square);

			// finding the correct row depending on the square the player has 
			int l = 2; // l=2 because starts to write name at [2]
			for (int i = 100; i > 0;) {
				if (square <= i && square >= i - 9)
					row = l;
				l += 3; // l+3 because its every 3 rows that we can write a name
				i -= 10;
			}

			Players[2][j] = Integer.toString(row);

			// writing the names
			// for the rows 2-4-6-8-10 on the board
			if (row % 2 != 0) {

				ArrayColumnNb = 6 * (square % 10) - 5;// why-5???????

				if (square % 10 == 0)
					ArrayColumnNb = 55;

				int i = 0;
				int w = 0;
				for (; ArrayColumnNb <= 60; ++ArrayColumnNb) {
					
					if (i == 5) {
						break;
					}
					//if there is already one name written 
					if (w == 0) {
						if (board[row][ArrayColumnNb] != ' ') {
							board[row][ArrayColumnNb + 2] = '\\';
							board[row][ArrayColumnNb + 3] = Players[0][j].charAt(0);
							board[row][ArrayColumnNb + 4] = Players[0][j].charAt(1);
							Players[3][j] = Integer.toString(ArrayColumnNb);
							break;
						}
						board[row][ArrayColumnNb] = Players[0][j].charAt(i);
					} 
					//writing the whole name if there is nothing there 
					else {
						board[row][ArrayColumnNb] = Players[0][j].charAt(i);
						++w;
					}
					Players[3][j] = Integer.toString(ArrayColumnNb - 4);
					++i;
				}
				++j;
				++turn;
			}

			// for rows 1-3-5-7-9 on the board
			else {
				column = 55;

				ArrayColumnNb = column - (6 * ((square % 10) - 1));

				if (square % 10 == 0)
					ArrayColumnNb = 1;

				int i = 0;
				int w = 0;
				for (column = ArrayColumnNb; column <= 60; ++column) {
					if (column > ArrayColumnNb + 4) {
						break;
					}
					//if there is already one name written 
					if (w == 0) {
						if (board[row][column] != ' ') {
							board[row][column + 2] = '\\';
							board[row][column + 3] = Players[0][j].charAt(0);
							board[row][column + 4] = Players[0][j].charAt(1);
							break;
						}
						board[row][column] = Players[0][j].charAt(i);
					} 
					//writing the whole name if there is nothing there 
					else {
						board[row][column] = Players[0][j].charAt(i);
						++w;
					}
					Players[3][j] = Integer.toString(column - 4);
					++i;
				}
				++j;
				++turn;

			}
			// printing the board with the names 
			for (int i = 0; i <= 30; ++i) {
				System.out.println(board[i]);
			}

			//ending loop when a player wins (gets 100 exactly)
			if (square >= 100) {
				System.out.println("\n**********************************");
				System.out.println("CONGRATS YOU HAVE WON THE GAME!!");
				System.out.println("**********************************");
				break;
			}
			//Want to continue playing? other wise the computer plays for us
			System.out.println("\nDo you want to continue (Y or N)?");
			String continuePlaying = scan.nextLine();
	
			if (continuePlaying.equals("N")==true) {
				System.out.println("\nSad to see you go, hope to see you soon!!");
				break;
			}
		}
		// close scanner 
		scan.close();
	}// end of main
}// end of class


