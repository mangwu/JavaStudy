import java.io.*;
import java.util.ArrayList;
class GameHelper {
	public static String getUserInput(String prompt) {
		System.out.print(prompt + " ");
		String userGuess = null;

		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			userGuess = is.readLine();
			if (userGuess.length() == 0) {
				return null;
			} else {
				return userGuess;
			}
		} catch(IOException err) {
			System.out.println(err);
		}
		return userGuess;
	}
}


class DotCom {
	private ArrayList<String> locationOfCells;


	void setLocationOfCells(ArrayList<String> lc) {
		locationOfCells = lc;
	}

	String checkYourself(String userGuess) {
		// int userGuessNum = Integer.parseInt(userGuess);
		String result = "Miss";

		int index = locationOfCells.indexOf(userGuess);
		// ���Ҳ�������-1�����ҵ��˷�������ֵ
		if (index != -1) {
			// ɾ�����е�����
			locationOfCells.remove(index);

			// �ж��Ƿ�ȫ������
			if (locationOfCells.isEmpty()) {
				result = "Kill";
			} else {
				result = "Hit";
			}
		}
		System.out.println(result);
		return result;
	}

}

class DotComGame {
	public static void main(String[] args) {
		// ������վ
		DotCom dc = new DotCom();

		// ���������
		int numOfDot = (int) (Math.random() * 5 + 1);

		// ��������
		ArrayList<String> lc = new ArrayList<String>();
		lc.add(Integer.toString(numOfDot));
		lc.add(Integer.toString(numOfDot + 1));
		lc.add(Integer.toString(numOfDot + 2));

		// ���������б�
		dc.setLocationOfCells(lc);

		// ��ʼ��Ϸ
		// ��ʼ��ֵ
		int score = 0;
		boolean isKill = false;

		while (!isKill) {
			String userGuess = GameHelper.getUserInput("ender a number: ");
			String result = dc.checkYourself(userGuess);
			score ++;
			if (result.equals("Kill")) {
				isKill = true;
				System.out.println("Game Over.");
				System.out.println("Your score is " + score);
			}

		}
	}
}