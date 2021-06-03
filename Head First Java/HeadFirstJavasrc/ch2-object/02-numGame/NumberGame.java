// 玩家
class Player {
	int guessedNum = 0;
	String playerName;
	boolean isRight = false;

	Player(String name) {
		playerName = name; 
	}
	public void guess() {
		guessedNum = (int) (Math.random() * 10);
		System.out.println(playerName + " guesses " + guessedNum);
	}
}

// 游戏
class GuessGame {
	Player p1;
	Player p2;
	Player p3;

	public void gameStart() {
		int x = 0;
		while(x < 10) {
			// 创建玩家
			playerJoin();
			// 生成随机数字
			int randomNum = randomNumberGenerator();
			System.out.println("生成随机数字"+ randomNum);

			p1.guess();
			p2.guess();
			p3.guess();
			// 数字猜中判断
			p1.isRight = numberIsRight(p1, randomNum);
			p2.isRight = numberIsRight(p2, randomNum);
			p3.isRight = numberIsRight(p3, randomNum);

			// 有一个猜中就中止游戏
			boolean flag = isOver();
			if (flag) {
				break;
			}
			x += 1;
		}
		

	}
	// 参与玩家
	public void playerJoin() {
		p1 = new Player("p1");
		p2 = new Player("p2");
		p3 = new Player("p3");
	}
	// 生成数字
	public int randomNumberGenerator() {
		return (int) (Math.random() * 10);
	}
	// 玩家是否猜中
	public boolean numberIsRight(Player p, int randomNum) {
		boolean isRight = p.guessedNum == randomNum;
		System.out.println(p.playerName + " guesses " + isRight);
		return isRight;
	}
	// 是否结束游戏
	public boolean isOver() {
		if (p1.isRight || p2.isRight || p3.isRight) {
			System.out.print("we have winner ");
			if (p1.isRight) {
				System.out.print(p1.playerName);
			}
			if (p2.isRight) {
				System.out.print(p1.playerName);
			}
			if (p3.isRight) {
				System.out.print(p1.playerName);
			}
			System.out.println("");
			return true;
		} else {
			return false;
		}
	}


}
// 启动游戏入口
class GameLaucher {
	public static void main(String[] args) {
		GuessGame gg = new GuessGame();
		gg.gameStart();
	}
}