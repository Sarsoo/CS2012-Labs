package logic;

public class Coordinate {
	private int row;
	private int column;
	private char state;
//	private Label label;
	
	public Coordinate(int row, int column, char state) {
		this.row = row;
		this.column = column;
		this.state = state;
	}
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass())
			return false;
		
		Coordinate coord = (Coordinate) obj;
		if(column == coord.getColumn() && row == coord.getRow()) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return "(" + row + ", " + column + ") " + state;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	
	public void increaseRow() {
		row++;
	}
	
	public void decreaseRow() {
		row--;
	}
	
	public void increaseCol() {
		column++;
	}
	
	public void decreaseCol() {
		column--;
	}

//	public Label getLabel() {
//		return label;
//	}
//
//	public void setLabel(Label label) {
//		this.label = label;
//	}
}
