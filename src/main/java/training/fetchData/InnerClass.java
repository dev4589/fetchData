package training.fetchData;


public class InnerClass extends forth{
	public static void main(String args[]) {
		Back b = new Back() {
			public void back() {
				System.out.println("main back");
			}
		};
		b.back();
		forth f = new forth();
		f.back();
		InnerClass l = new InnerClass();
		l.back();
	}

	public void back() {
		System.out.println("not forth");
	}

}

class forth extends Back {
	public void back() {
		System.out.println("back");
	}
}

class Back {
	public void back() {
		System.out.println("not back");
	}
}