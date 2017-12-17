public class Card{
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s, int r)
{
		thisCardSuit=s;
		rank=r;
	}	
	enum Suit{Clubs,Diamonds,Hearts,Spades};//将Suit限定为 Clubs,Diamonds,Hearts,Spades
	Suit thisCardSuit;
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.print(thisCardSuit.name());
		if(rank==1)
			System.out.println("A");
		if(rank==2)
			System.out.println("2");
		if(rank==3)
			System.out.println("3");
		if(rank==4)
			System.out.println("4");
		if(rank==5)
			System.out.println("5");
		if(rank==6)
			System.out.println("6");
		if(rank==7)
			System.out.println("7");
		if(rank==8)
			System.out.println("8");
		if(rank==9)
			System.out.println("9");
		if(rank==10)
			System.out.println("10");
		if(rank==11)
			System.out.println("J");
		if(rank==12)
			System.out.println("Q");
		if(rank==13)
			System.out.println("K");
		
	}
	public Suit getSuit(){//回传thisCardSuit
		return thisCardSuit;
	}
	public int getRank(){//回传rank
		return rank;
	}
}