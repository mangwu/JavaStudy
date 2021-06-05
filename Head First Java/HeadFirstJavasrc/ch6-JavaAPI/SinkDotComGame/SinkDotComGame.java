import java.io.*;
import java.util.ArrayList;

class DotCom {
	private String name;
	private ArrayList<String> dotComCells;

	public void setName(String dcn) {
		name = dcn;
	}

	public String getName() {
		return name;
	} 

	public DotCom(String dcn) {
		name = dcn;
	}

	public void setdotComCells(ArrayList<String> dcc) {
		dotComCells = dcc;
	}
	public ArrayList<String> getDotComCells() {
		return dotComCells;
	}

	public String checkYourself(String userGuess) {
		String result = "Miss";

		// �ж��Ƿ�����
		int index = dotComCells.indexOf(userGuess);
		if (index != -1) {
			result = "Hit";
			dotComCells.remove(userGuess);
			if (dotComCells.isEmpty()) {
				result = "Sunk";
			}
		}
		return result;
	}
}

class GameHelper {
	// ��Ϸ�����࣬������ȡ�û�����Ͳ�������
	public String getUserInput(String prompt) {
		System.out.print(prompt + " ");
		String result = null;
		try {
			// ������ȡ��
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			result = is.readLine();
			if (result.length() == 0) {
				return null;
			} else {
				return result;
			}
		} catch(IOException err) {
			System.out.println(err);
		}
		return result;
	}

	// ����λ��
	public void makeLocation(ArrayList<DotCom> dotComs) {
		// int x1 = (int) (Math.random() * 5);
		// int y1 = (int) (Math.random() * 5);
		// int z1 = (int) (Math.random() * 2);
		dotComs.get(0).setdotComCells(makeLocationString(1, 1, 0));
		dotComs.get(1).setdotComCells(makeLocationString(1, 3, 1));
		dotComs.get(2).setdotComCells(makeLocationString(4, 6, 0));

	}

	// ����λ���ַ�
	public ArrayList<String> makeLocationString(int x, int y, int z) {
		ArrayList<String> locationCells = new ArrayList<String>();
		int[] xNums = {x, x+1, x+2};
		int[] yNums = {y, y+1, y+2};
		String xStr = Integer.toString(x);
		String yStr = makeYToChar(y);
		// ����z�жϺ�����չ����������չ
		if (z == 0) {
			for (int cell : xNums) {
				locationCells.add(yStr + Integer.toString(cell));
			}
		} else if (z == 1) {
			for (int cell : yNums) {
				locationCells.add(makeYToChar(cell) + xStr);
			}
		}
		return locationCells;
	}

	// �滻��
	public String makeYToChar(int y) {
		switch(y) {
			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
		}
    return null;
	}
}

class DotComGameSetter {
	// �������dotcom��վ
	private ArrayList<DotCom> dotComs = new ArrayList<DotCom>();
	private GameHelper gh;

	// ����DotCom����
	public void makeDotCom() {
		dotComs.add(new DotCom("DotCom.com"));
		dotComs.add(new DotCom("Mangwu.com"));
		dotComs.add(new DotCom("Petsng.com"));
	}
	// ����GameHelper����
	public void makeGH() {
		gh = new GameHelper();
	}
	// ��������λ��
	public void makeLocation() {
		gh.makeLocation(dotComs);
	}
	// �ж���վ�Ƿ񱻻���
	public boolean isSunk(DotCom dc) {
		return dc.getDotComCells().isEmpty();
	}
	// �ж�ȫ����վ�Ƿ񱻻���
	public boolean isAllSunk() {
		boolean result = true;
		for (int i = 0; i < dotComs.size(); i++) {
			if (!dotComs.get(i).getDotComCells().isEmpty()) {
				result = false;
				break;
			}
		}
		return result;
	}

	// ��Ϸ��ʼ��
	public void gameStartSetter() {
		// ����������վ
		makeDotCom();
		// ����GH����
		makeGH();
		// ������վλ��
		makeLocation();
	}

	// ��Ϸ����
	public void gameStart() {
		int score = 0;
		boolean flag = true;
		System.out.println("Sink Game Dot Com Game Start!");
		while (flag) {
			// ��ȡ��Ҳ²�
			String userGuess = gh.getUserInput("Enter a coordinates(X for [0-6], Y for[A-G], input YX)!");
			// ������һ
			score ++;
			// ������վ���� ��ѯ�Ƿ����
			String result = "Miss";
			for (int i = 0; i < dotComs.size(); i++) {
				result = dotComs.get(i).checkYourself(userGuess);
				if (result == "Miss") {
					continue;
				}
				if (result == "Hit") {
					break;
				}
				if (result == "Sunk") {
					System.out.println("You have sunk the " + dotComs.get(i).getName() + ". Congratulations��");
					if (isAllSunk()) {
						flag = false;
            System.out.println("Game over");
            System.out.println("Your score is " + score);
					}
					break;
				}
			}
			if (result != "Sunk") {
				System.out.println(result);
			}
		}
	}

	// ��Ϸ���
	public static void main(String[] args) {
		DotComGameSetter dcgs = new DotComGameSetter();
		dcgs.gameStartSetter();
		dcgs.gameStart();
	}
}