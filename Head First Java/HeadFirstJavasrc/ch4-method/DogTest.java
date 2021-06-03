class Dog {
	private String name;
	private int size;
	char a;

	Dog (String dName) {
		name = dName;
	}
	public void setName(String dName) {
		name = dName;
	}
	public String getName() {
		return name;
	}

	public void setSize(int dSize) {
		size = dSize;
	}
	public int getSize() {
		return size;
	}

	public boolean equals(Dog d) {
		if (name.equals(d.name) && size == d.size) {
			return true;
		} else {
			return false;
		}
	}

}

class DogTestDrive {
	public static void main(String[] args) {
		Dog d = new Dog("jinmao");
		// try {
		// 	d.name = "zangao";
		// } catch(Error e) {
		// 	System.out.println(e);
		// }
		System.out.println(d.getName());
		d.setName("zangao");
		System.out.println(d.getName());
		System.out.println(d.getSize());
		d.setSize(5);
		System.out.println(d.getSize());
		String c = "gousheng";
		d.setName(c);
		System.out.println(d.getName());
		
		System.out.println(d.a);
		String a = new String("123456");
		String b = new String("123456");
		System.out.println(a.equals(b));

		Dog d1 = new Dog("abc");
		Dog d2 = new Dog("abc");
		d1.setSize(5);
		d2.setSize(5);
		System.out.println(d1.equals(d2));

	}
}