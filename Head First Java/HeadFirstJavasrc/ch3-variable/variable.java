class Dog {
	int a = 1;
	public void bark() {
		System.out.println("汪！");
	}
}

class DogTestDrive {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.bark();

		d = null;
		System.out.println(d);
	}
}