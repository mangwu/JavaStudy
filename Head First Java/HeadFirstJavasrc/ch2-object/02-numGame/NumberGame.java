// ���
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

// ��Ϸ
class GuessGame {
	Player p1;
	Player p2;
	Player p3;

	public void gameStart() {
		int x = 0;
		while(x < 10) {
			// �������
			playerJoin();
			// �����������
			int randomNum = randomNumberGenerator();
			System.out.println("�����������"+ randomNum);

			p1.guess();
			p2.guess();
			p3.guess();
			// ���ֲ����ж�
			p1.isRight = numberIsRight(p1, randomNum);
			p2.isRight = numberIsRight(p2, randomNum);
			p3.isRight = numberIsRight(p3, randomNum);

			// ��һ�����о���ֹ��Ϸ
			boolean flag = isOver();
			if (flag) {
				break;
			}
			x += 1;
		}
		

	}
	// �������
	public void playerJoin() {
		p1 = new Player("p1");
		p2 = new Player("p2");
		p3 = new Player("p3");
	}
	// ��������
	public int randomNumberGenerator() {
		return (int) (Math.random() * 10);
	}
	// ����Ƿ����
	public boolean numberIsRight(Player p, int randomNum) {
		boolean isRight = p.guessedNum == randomNum;
		System.out.println(p.playerName + " guesses " + isRight);
		return isRight;
	}
	// �Ƿ������Ϸ
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
// ������Ϸ���
class GameLaucher {
	public static void main(String[] args) {
		GuessGame gg = new GuessGame();
		gg.gameStart();
	}
}