package training.collections;

public enum EnumWithValue {
	FIRST(1), SECOND(2);

	private int val;

	EnumWithValue(int val) {
		this.val=val;
	}

	public static EnumWithValue returnEnum(int i) {
		switch (i) {
		case 1:
			return FIRST;
		case 2:
			return SECOND;
		default:
			break;
		}
		return FIRST;
	}

	public int getVal() {
		return val;
	}

}
