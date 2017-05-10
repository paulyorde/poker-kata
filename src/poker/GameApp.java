package poker;

public class GameApp {
	//Game game = new Game();
	
	public static void main(String[] args) {
		Player player = new Player("white");
		Game game = new Game();
		//System.out.println(player.getName());
		try {
			game.deal(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
