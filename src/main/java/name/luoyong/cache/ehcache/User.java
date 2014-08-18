package name.luoyong.cache.ehcache;

public class User {

	private int count = 0;
	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		count++;
		return name + "  " + count;
	}

}
