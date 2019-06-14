
public class House extends Building{
	private String feature;
	
	
	public House(double size, boolean haunted, String feature) {
		this.size = size;
		this.isHaunted = haunted;
		this.feature = feature;
	}
	

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Override
	public void explore() {
		System.out.println("This house measures " + size + " sq metres with a(n) " + feature);
		if(isHaunted) System.out.println("A Ghost!");
	}
}
