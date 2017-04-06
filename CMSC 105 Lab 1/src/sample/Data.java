package sample;

public class Data {
	private String value;
	private int index;
	
	public Data(String value, int index){
		this.value = value;
		this.index = index;
	}
	
	public Data(){
		
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setData(String data) {
		this.value = data;
	}
}
