
public abstract class Building {
	protected double size;
	protected boolean isHaunted;
	
	
	public abstract void explore();
	
	
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public boolean isHaunted() {
		return isHaunted;
	}
	public void setHaunted(boolean isHaunted) {
		this.isHaunted = isHaunted;
	}
}
