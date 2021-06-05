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
		// 查找不到返回-1，查找到了返回索引值
		if (index != -1) {
			// 删除击中的网格
			locationOfCells.remove(index);

			// 判断是否全部击中
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
		// 创建网站
		DotCom dc = new DotCom();

		// 生成随机数
		int numOfDot = (int) (Math.random() * 5 + 1);

		// 产生网格
		ArrayList<String> lc = new ArrayList<String>();
		lc.add(Integer.toString(numOfDot));
		lc.add(Integer.toString(numOfDot + 1));
		lc.add(Integer.toString(numOfDot + 2));

		// 设置网格列表
		dc.setLocationOfCells(lc);

		// 开始游戏
		// 初始化值
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