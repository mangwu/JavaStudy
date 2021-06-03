class Dog {
	int size;
	String name;
	String breed;

	void bark() {
		System.out.print("汪，汪，汪！");
	}
}

class DogTestDrive {
	public static void main(String[] args) {
		// 创建对象
		Dog d = new Dog();
		// 存储对象变量
		d.size = 40;
		d.name = "xiaohui";
		// 调用对象方法
		d.bark();
	}
}