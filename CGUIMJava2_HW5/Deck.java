import java.util.ArrayList;
import java.util.Random;

	
		// TODO 自动生成的方法存根	
	public	class Deck{
		
		

			private ArrayList<Card> cards;
			//TODO: Please implement the constructor (30 points)
			public Deck(int nDeck){
				cards=new ArrayList<Card>();
				//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
				//Hint: Use new Card(x,y) and 3 for loops to add card into deck
				//Sample code start
				//Card card=new Card(1,1); ->means new card as clubs ace
				//cards.add(card);
				//Sample code end
				for (int deck=1;deck<=nDeck;deck++){//几副牌
					for (Card.Suit s : Card.Suit.values()){//花色
						for(int Rank=1;Rank<=13;Rank++){//大小
							Card card=new Card(s,Rank);
							cards.add(card);//将新实体化的card加到清单（cards）里面
						}
					}
				}shuffle();//洗牌
				

			}	
			//TODO: Please implement the method to print all cards on screen (10 points)
			
				public ArrayList<Card> getAllCards(){
				return cards;
			}
				
			    public ArrayList<Card> usedCard;//用过的牌
			    
			    
			    public int nUsed;//用过牌的数量
			    public void shuffle(){
			    	
			    	openCard=new ArrayList<Card>();//将openCard实体化
			    	usedCard=new ArrayList<Card>();//将usedCard实体化
			    	for(int i=52;i>0;i--){
			    	Random n = new Random(); 
			    	int x=n.nextInt(cards.size());
			    	Card card=new Card(cards.get(x).getSuit(),cards.get(x).getRank());
			    	
			    	Card tempCard=cards.get(x);
			    	cards.set(x, cards.get(i));
			    	cards.set(i, tempCard);
			  
			    	/*随机抽取一张牌
			    	 * 把这张牌暂存在tempCard中
			    	 * 将这张牌与第i张牌互调位置
			    	 * 重复52次完成洗牌
			    	 */
			    	}nUsed=0;
			    	//将nUsed清零
			    	
			    	
			    	openCard.removeAll(openCard);//重置打开的牌
			    }
			    		    
			    public Card getOneCard(boolean isOpened){
			    	
			    	if(nUsed==52)//当52张牌发完了
			    		shuffle();//洗牌
			    	nUsed++;//每发一次牌，nUsed++
			    	if(isOpened==true){
			    		openCard.add(cards.get(0));//如果这张牌是打开的牌，则新增到openCard里面
			    			
			    	}
			    	Card card=new Card(cards.get(0).getSuit(),cards.get(0).getRank());	//每次都发最上面的牌		    	
			    	cards.add(cards.get(0));cards.remove(cards.get(0));//将发的最上面的牌放到最下面
			    	return card;
			    }
			    private ArrayList<Card> openCard;
			   // 存放此副牌中所有打開的牌，洗牌時要重置
			    
			    public ArrayList<Card> getOpenedCard(){
			    //回傳此副牌中所有打開過的牌，意即openCard
			    	return openCard;
			    	}

	}


