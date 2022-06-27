package training.fetchData;

class EnumData {
	enum EnumSize{SMALL,MEDIUM, LARGE};
	EnumSize size;
	
	enum EnumShape{TRIANGLE,SQAURE,CIRCLE};
	EnumShape shape;
}

public class TryEnum{
	public enum Color{RED,ORANGE,YELLO};
	public static void main(String args[]) {
		EnumData data=new EnumData();
		data.size=EnumData.EnumSize.SMALL;
		data.shape=EnumData.EnumShape.CIRCLE;
		Color color=Color.ORANGE;
	 	System.out.println("Size: "+data.size);
	 	System.out.println("Shape: "+data.shape);
	 	System.out.println("Color: "+color instanceof String);
	}
}