import java.util.ArrayList;

class ArrayListTestDrive {
	public static void main(String[] args) {
		String[] strList = new String[5];
		ArrayList<String> arrStrList = new ArrayList<String>();

		strList[0] = "mangwu";
		strList[1] = "wumang";
		strList[2] = "wumangwu";

		arrStrList.add("mangwu");
		arrStrList.add("wumangwu");
		arrStrList.add(1, "wumang");

		System.out.println(arrStrList.get(1) + " " + arrStrList.get(2));
	}
}