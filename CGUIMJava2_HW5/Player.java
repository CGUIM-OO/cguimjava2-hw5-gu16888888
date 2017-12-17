import java.util.ArrayList;

public class Player extends Person{
	//public boolean hit_me(Table tbl){
		
	//}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}	
	private String name;//玩家姓名
	private int chips;//玩家有的籌碼
	private int bet;//玩家此局下注的籌碼
	private ArrayList<Card> oneRoundCard;//此牌局的卡
	
	public Player(String name, int chips){
		this.name=name;//this指定玩家name
		this.chips=chips;//this指定玩家有的筹码
	}//Player constructor，新增Player物件時，需要姓名、擁有的籌碼等兩個參數
	
	public String getName(){
	//name的getter
	return name;
		}
	public int make_bet(){//下注
		bet=1;//基本下注：一次1元
		if(chips>=1)
			return bet;
		else
			return 0;
		
	/*检查是否还有钱
	 * 有钱 return bet
	 * 没钱就不能继续下注， return 0
	 */
	
	}
	//public void setOneRoundCard(ArrayList<Card> cards){
	//設定此牌局所得到的卡 setter
		
	//oneRoundCard=cards;//此牌局得到的卡为cards
	//}
	public boolean hitMe(){
	/*是否要牌，是回傳true，不再要牌則回傳false
	基本參考條件：16點以下要牌，17點以上不要牌
	提示：用oneRoundCard來算*/
		boolean hM;
		if (getTotalValue()<=16)//如果总点数小于等于16，则要牌；否则停止要牌
			hM=true;
		else
			hM=false;	
		return hM;  //回传true or false
	}
	/*public int getTotalValue(){
	//回传此牌局所得的卡数加总
		int ToalValue=0;
		int len=oneRoundCard.size();
		for(int i=len-1;i>=0;i--){
			if(oneRoundCard.get(i).getRank()>10)
				ToalValue+=10;//如果抽到J、Q、K 则算为10点  其余均与Rank相同
			else ToalValue=ToalValue+oneRoundCard.get(i).getRank();
		}
		return ToalValue;//回传此牌局所得的卡数加总
	}
	*/
	public int getCurrentChips(){
	//回傳玩家現有籌碼
		return chips;
	}
	public void increaseChips (int diff){
	//玩家籌碼變動，setter
		chips=chips+diff;
	}
	public void say_hello(){
	//玩家Say Hello
	System.out.println("Hello, I am " + name + ".");
	System.out.println("I have " + chips + " chips.");
	}

	@Override
	public boolean hit_me(Table table) {
		// TODO 自动生成的方法存根
		return false;
	}
}
