import java.util.ArrayList;

public class Table {

	public static void main(String[] args) {
		
		
		
		
	}
		// TODO 自动生成的方法存根
		private static final int MAXPLAYER=4;
		private Deck deck;//存放所有的牌
		private Player[] players;//存放所有的玩家
		private Dealer dealer;//存放一个庄家
		private int[] pos_betArray;
		private int nDecks;
		public void set_player(int pos, Player p){
		//將Player放到牌桌上 (意即放到型別為Player[]的變數(instance field)中，為setter)，pos為牌桌位置，最多MAXPLAYER人，p則為Player instance。
			players [pos]=p;
		}public Table (int nDecks){
			this.nDecks=nDecks;
			deck=new Deck(nDecks);
			players= new Player[MAXPLAYER];
			pos_betArray=new int[MAXPLAYER];
			//新增 Constructor, 輸入參數為 int nDeck，在HW5.java內有實體化Table Class，可參考。
			//在此Constructor中，請將Deck class實體化，並存入上述新增的Deck變數(instance field) 
			//- 新增 請初始化上述新增型別為Player[]的變數(instance field)，宣告一個長度是MAXPLAYER 的Player array
		}
		
		
		//
		public Player[] get_player(){
		//回傳所有在牌桌上的player，意即回傳型別為Player[]的變數(instance field)變數，為getter
			return players;
		}
		public void set_dealer(Dealer d){   
			// - 將Dealer放到牌桌上 (意即將Dealer放到 型別為Dealer 的變數(instance field) 中，為變數之setter)。
			dealer=d;
		}
		
		public Card get_face_up_card_of_dealer(){
		//回傳dealer打開的那張牌，也就是第二張牌
			return dealer.getOneRoundCard().get(1);
		}
		private void ask_each_player_about_bets(){
		//請每個玩家打招呼 (提示 say_hello())
			for(int i=0;i<MAXPLAYER;i++){
				Player p=players[i];
				p.say_hello();
				pos_betArray[i]=p.make_bet();
				//請每個玩家下注 (提示 make_bet())
				//每個玩家下的注要存在pos_betArray供之後使用
			}
			
		
			
		}
		
		
		private void distribute_cards_to_dealer_and_players(){
		//發牌給玩家跟莊家，先發兩張打開的牌給玩家，再一張蓋著的牌，以及一張打開的牌給莊家。(提示: setOneRoundCard())
			for(int i=0;i<=3;i++){
			ArrayList<Card> playerCard=new ArrayList<Card>();
			playerCard.add(deck.getOneCard(true));
			playerCard.add(deck.getOneCard(true));//玩家两张打开的牌
			
			players[i].setOneRoundCard(playerCard);
			}
			ArrayList<Card> dealerCard=new ArrayList<Card>();
			dealerCard.add(deck.getOneCard(false));
			dealerCard.add(deck.getOneCard(true));//庄家一张打开一张闭着的牌
			dealer.setOneRoundCard(dealerCard);
		//發牌給莊家後，在畫面上印出莊家打開的牌"Dealer's face up card is " (提示: printCard())
			System.out.println("Dealer's face up card is");
			get_face_up_card_of_dealer().printCard();
		}
		private void ask_each_player_about_hits(){
			for(int i=0;i<MAXPLAYER;i++){
				boolean hit=false;
				ArrayList<Card> playerCard=new ArrayList<Card>();
				playerCard.add(deck.getOneCard(true));
				playerCard.add(deck.getOneCard(true));
				players[i].setOneRoundCard(playerCard);
				do{//问玩家要不要牌
					hit=players[i].hitMe(); //this
					if(hit){
						playerCard.add(deck.getOneCard(true));
						players[i].setOneRoundCard(playerCard);
						System.out.print("Hit! ");
						System.out.println(players[i].getName()+"'s Cards now:");
						for(Card c : playerCard){
							c.printCard();
						}
					}
					else{
						System.out.println(players[i].getName()+", Pass hit!");
						System.out.println(players[i].getName()+", Final Card:");
						for(Card c : playerCard){
							c.printCard();
						}
					}
				}while(hit);
				
			}
		//問每個玩家要不要牌 (提示: hit_me(Table tbl))
		//請參照HW4.java，使用do while迴圈詢問各個玩家
		//詢問順序: 按照加入牌局的順序而定 (位置)
		//如果玩家要牌，請在畫面上印出"Hit! "+ 玩家的名字+ "’s cards now: "，並把玩家要牌後的完整牌印出。最後將新的牌用setOneRoundCard()設定回玩家物件。
		//如果爆了，請不要再問玩家是否要牌
		//如果玩家不要牌了，請在畫面上印出 玩家的名字+"Pass hit!"
		}
		private void ask_dealer_about_hits(){
		//詢問莊家是否要牌，完成後，印出"Dealer's hit is over!"
			boolean hit=false;
			do{
				hit=dealer.hit_me(this); //this
				if(hit){
					dealer.getOneRoundCard().add(deck.getOneCard(true));
					
				}
				
				
			}while(hit);
			System.out.println("Dealer's hit is over!");
		}
		private void calculate_chips(){
			System.out.println("Dealer's card value is"+dealer.getTotalValue());
			
			System.out.println("Cards");
			dealer.printAllCard();
			for(int i=0;i<=3;i++){
				int p1Bet=players[i].make_bet();
				//int p2Bet=dealer.make_bet();
				System.out.println("player "+(i+1)+" cards: ");
				players[i].printAllCard();
				System.out.println("player "+(i+1)+" card value is "+players[i].getTotalValue());
			if(players[i].getTotalValue()>21 && dealer.getTotalValue()>21){
				//System.out.println("Need another game");
				players[i].getCurrentChips();
				System.out.println(players[i].getName()+"chips have no change! The Chips now is: "+players[i].getCurrentChips());
				
			}else if(players[i].getTotalValue()<=21&&dealer.getTotalValue()>21){
				//System.out.println(players[i].getName()+" wins the game");
				players[i].increaseChips(p1Bet);
				System.out.print(" GET "+p1Bet+" chips "+players[i].getName());
				
				System.out.println(" the Chips now is: "+players[i].getCurrentChips());
				
				
				//dealer.increaseChips(-p2Bet);
			}else if(players[i].getTotalValue()>21&&dealer.getTotalValue()<=21){
			//	System.out.println(dealer.getName()+" wins the game");
				//System.out.println(players[i].getName()+" lose the game");
				players[i].increaseChips(-p1Bet);
				System.out.print(" Loss "+p1Bet+" chips "+players[i].getName());
				
				System.out.println(" the Chips now is: "+players[i].getCurrentChips());
				
				
				//dealer.increaseChips(p2Bet);
			}else if(players[i].getTotalValue()>dealer.getTotalValue()&&players[i].getTotalValue()<=21){
				//System.out.println(players[i].getName()+" wins the game");
				players[i].increaseChips(p1Bet);
				System.out.print(" GET "+p1Bet+" chips "+players[i].getName());
				
				System.out.println(" the Chips now is: "+players[i].getCurrentChips());
				
				
				//dealer.increaseChips(-p2Bet);
			}else if(players[i].getTotalValue()<dealer.getTotalValue()&&dealer.getTotalValue()<=21){
				//System.out.println(dealer.getName()+" wins the game");
				//System.out.println(players[i].getName()+" lose the game");
				players[i].increaseChips(-p1Bet);
				System.out.print(" Loss "+p1Bet+" chips "+players[i].getName());
				
				System.out.println(" the Chips now is: "+players[i].getCurrentChips());
				
				
				//dealer.increaseChips(p2Bet);
			}else{
				System.out.println(players[i].getName()+" chips have no change! The Chips now is: "+players[i].getCurrentChips());
				
			}
			}
		//印出莊家的點數和牌"Dealer's card value is "+總點數+" ,Cards:"+牌們 (提示: printAllCard())
		//莊家跟每一個玩家的牌比
		//針/對每個玩家，先印出 玩家姓名+" card value is "+玩家總點數
		//看誰贏，要是莊家贏，把玩家籌碼沒收，印出", Loss "+下注籌碼數+" Chips, the Chips now is: "+玩家最新籌碼數(提示: get_current_chips())
		//要是莊家輸，則賠玩家與下注籌碼相符之籌碼，印出",Get "+下注籌碼數+" Chips, the Chips now is: "+玩家最新籌碼數(提示: get_current_chips())
		//不輸不贏，印出",chips have no change! The Chips now is: "+玩家最新籌碼數(提示: get_current_chips())
		}
		public int[] get_players_bet(){
			
			return pos_betArray;//玩家的筹码
		}
			
		
		
		public void play(){//新增一method play()如下，使用方法見HW5.java
				ask_each_player_about_bets();
				distribute_cards_to_dealer_and_players();
				ask_each_player_about_hits();
				ask_dealer_about_hits();
				calculate_chips();
			}

	}


