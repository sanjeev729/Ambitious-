package thread.reenterent;

public class Data {
	int info;
	String name;

	public Data() {
		info = 0;
		name = null;
	}

	public Data(int info, String name) {
		super();
		this.info = info;
		this.name = name;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
