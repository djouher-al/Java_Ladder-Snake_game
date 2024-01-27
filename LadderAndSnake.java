
import java.util.Random;

	public class LadderAndSnake {
		
		// attributes 
		private int NbofPlayers;
		private int DiceResult;
		private int SquareNb=0;
		
		
		//Accessor for Number of Players
		public int getNbofPlayers() {
			return NbofPlayers;
		}

		//Mutator for Number of Players
		public void setNbofPlayers(int NbofPlayers) {
			this.NbofPlayers = NbofPlayers;
		}
			
		//Accessor for the Dice Result
		public int getDiceResult() {
			return DiceResult;
		}

		//Mutator for the Dice Result
		public void setDiceResult(int DiceResult) {
			this.DiceResult = DiceResult;
		}

		//Accessor for the Square Number 
		public int getSquareNb() {
			return SquareNb;
		}

		//Mutator for the Square Number 
		public void setSquareNb(int SquareNb) {
			this.SquareNb = SquareNb;
		}
		
		public int RandomDice() {
			Random random = new Random();
			int RandomDiceNb = random.nextInt(6)+1;
			return RandomDiceNb;
		}
		
		public void AddSquares(int square) {
			SquareNb = SquareNb + square;
		}
		
	
		
		
		
	
		public int play(int dice, int square) {
			
			square = SquareNb + dice;
			
			switch (square){
				case 1:
					square = 38;
					break;
				case 4:
					square = 14;
					break;
				case 9:
					square = 31;
					break;
				case 21:
					square = 42;
					break;
				case 28:
					square = 84;
					break;
				case 36:
					square = 44;
					break;
				case 51:
					square = 67;
					break;
				case 71:
					square = 91;
					break;
				case 80:
					square = 100;
					break;
				case 98:
					square = 78;
					break;
				case 97:
					square = 76;
					break;
				case 95:
					square = 24;
					break;
				case 93:
					square = 68;
					break;
				case 79:
					square = 19;
					break;
				case 64:
					square = 60;
					break;
				case 48:
					square = 30;
					break;
				case 16:
					square = 6;
					break;
			}
			SquareNb = square;
			return square;
		}
	}


	
	
	
	

