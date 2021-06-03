import java.io.*;
class SimpleDotCom {
	private int[] locationCells;
	private int numOfHits = 0;

	public void setLocationCells(int[] lc) {
		locationCells = lc;
	}

	public String checkYourself(String userGuess) {
		// 字符串转为数字
		int guess = Integer.parseInt(userGuess);

		// 猜测结果
		String result = "Miss";

		// 遍历LC
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
		// 创建SimpleDotCom对象
		SimpleDotCom sdc = new SimpleDotCom();
		// 调用setter设置网格位置
		int[] locations = {4, 5, 6};
		sdc.setLocationCells(locations);

		// 创建多个假的猜测，测试checkYourself方法
		String userGuess1 = "2";
		String userGuess2 = "4";
		String userGuess3 = "5";
		String userGuess4 = "6";
		String result1 = sdc.checkYourself(userGuess1);
		String result2 = sdc.checkYourself(userGuess2);
		String result3 = sdc.checkYourself(userGuess3);
		String result4 = sdc.checkYourself(userGuess4);

		// 列出结果，观察是否一致
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
		// 创建游戏

		SimpleDotCom sdc = new SimpleDotCom();

		//设置网站网格位置
		int numOfRandom = (int) (Math.random() * 5 + 1);
		int[] locationCells = {numOfRandom, numOfRandom + 1, numOfRandom + 2};
		sdc.setLocationCells(locationCells);

		// 初始化游戏数据
		int numOfGuess = 0;
		boolean isKill = false;

		// 开始游戏
		while (!isKill) {
			// 获取玩家输入
			String pInput = GameHelper.getUserInput("enter your guess:");
			// 获取猜测结果
			String result = sdc.checkYourself(pInput);
			// 增加猜测次数
			numOfGuess++;

			// 判断是否击沉
			if (result.equals("Kill")) {
				isKill = true;
				System.out.println("your score is " + numOfGuess);
				System.out.println("Game over.");
			}
		}

	}
}