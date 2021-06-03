import java.io.*;
class SimpleDotCom {
	private int[] locationCells;
	private int numOfHits = 0;

	public void setLocationCells(int[] lc) {
		locationCells = lc;
	}

	public String checkYourself(String userGuess) {
		// �ַ���תΪ����
		int guess = Integer.parseInt(userGuess);

		// �²���
		String result = "Miss";

		// ����LC
		for (int i = 0; i < locationCells.length; i++) {
			if (guess == locationCells[i]) {
				result = "Hit";
				locationCells[i] = 0;
				numOfHits++;
				if (numOfHits == locationCells.length) {
					result = "Kill";
				}
				break;
			}
		}
		System.out.println(result);
		return result;
	}
}

class SimpleDotComTestDrive {
	public static void main(String[] args) {
		// ����SimpleDotCom����
		SimpleDotCom sdc = new SimpleDotCom();
		// ����setter��������λ��
		int[] locations = {4, 5, 6};
		sdc.setLocationCells(locations);

		// ��������ٵĲ²⣬����checkYourself����
		String userGuess1 = "2";
		String userGuess2 = "4";
		String userGuess3 = "5";
		String userGuess4 = "6";
		String result1 = sdc.checkYourself(userGuess1);
		String result2 = sdc.checkYourself(userGuess2);
		String result3 = sdc.checkYourself(userGuess3);
		String result4 = sdc.checkYourself(userGuess4);

		// �г�������۲��Ƿ�һ��
		if (result1.equals("Miss") && result2.equals("Hit") && result3.equals("Hit") && result4.equals("Kill")) {
			System.out.println("test passed");
		} else {
			System.out.println("test failed");
		}
	}
}

class GameHelper {
	public static String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		} catch (IOException err) {
			System.out.println("IOException:" + err);
		}
		return inputLine;
	}
}
class SimpleDotComGame {
	public static void main(String[] args) {
		// ������Ϸ

		SimpleDotCom sdc = new SimpleDotCom();

		//������վ����λ��
		int numOfRandom = (int) (Math.random() * 5 + 1);
		int[] locationCells = {numOfRandom, numOfRandom + 1, numOfRandom + 2};
		sdc.setLocationCells(locationCells);

		// ��ʼ����Ϸ����
		int numOfGuess = 0;
		boolean isKill = false;

		// ��ʼ��Ϸ
		while (!isKill) {
			// ��ȡ�������
			String pInput = GameHelper.getUserInput("enter your guess:");
			// ��ȡ�²���
			String result = sdc.checkYourself(pInput);
			// ���Ӳ²����
			numOfGuess++;

			// �ж��Ƿ����
			if (result.equals("Kill")) {
				isKill = true;
				System.out.println("your score is " + numOfGuess);
				System.out.println("Game over.");
			}
		}

	}
}