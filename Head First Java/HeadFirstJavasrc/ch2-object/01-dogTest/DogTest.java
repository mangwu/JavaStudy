class Dog {
	int size;
	String name;
	String breed;

	void bark() {
		System.out.print("������������");
	}
}

class DogTestDrive {
	public static void main(String[] args) {
		// ��������
		Dog d = new Dog();
		// �洢�������
		d.size = 40;
		d.name = "xiaohui";
		// ���ö��󷽷�
		d.bark();
	}
}