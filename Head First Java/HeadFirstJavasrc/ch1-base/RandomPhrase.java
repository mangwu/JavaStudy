public class RandomPhrase {
	public static void main(String[] args) {
		// 术语集合
		String[] wordListOne = {"24/7", "as", "int", "boolean", "abstract", "class", "volatile", "VerifyError", "Appendable"};
		String[] wordListTwo = {"java", "javascript", "python", "dk", "manth", "AutoCloseable", "StackTraceElement", "ClassCastException"};
		String[] wordListThree = {"java", "Comparable", "continue", "LongPredicate", "char", "LongConsumer"};
		// 长度
		int one = wordListOne.length;
		int two = wordListTwo.length;
		int three = wordListThree.length;
		// 随机索引
		int random1 = (int) (Math.random() * one);
		int random2 = (int) (Math.random() * two);
		int random3 = (int) (Math.random() * three);

		// 组合
		String phrase = wordListOne[random1] + " " + wordListTwo[random2] + " " + wordListThree[random3];

		// 输出
		System.out.print(phrase);
	}
}