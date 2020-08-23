package reflectionex;


interface B{
	public void display();
}

interface D{
	public void show();
}


public class Y implements B,D {
    private int info;
    public String name;
    static String age;
    public Y() {
		
	}
	
	public Y(int i){}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getAge() {
		return age;
	}

	public static void setAge(String age) {
		Y.age = age;
	}

	public int getInfo() {
		return info;
	}

	private void setInfo(int info) {
		this.info = info;
	}

	@Override
	public void display() {
		
		
	}

	@Override
	public void show() {
		System.out.println(info);
		
	}
	
	

}
