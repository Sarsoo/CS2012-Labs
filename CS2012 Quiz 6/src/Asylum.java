
public class Asylum extends Building{
	private String name;
	
	
	public Asylum(double size, boolean haunted, String name) {
		this.size = size;
		this.isHaunted = haunted;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void explore() {
		System.out.println("The asylum " + name + " measures " + size + " sq metres");
		if(isHaunted) System.out.println("A Ghost!");
	}
}
