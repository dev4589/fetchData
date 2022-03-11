package training.fetchData;

public class NestedClass {

	public static void main(String args[]) {
		Hello h = new Hello();
		h.hello();
		Hello.Run r = h.new Run();
		r.run();
		h.methodInner();

	}
}

class Hello {
	void hello() {
		System.out.println("hello");
		World w = new World();
		w.world();
	}

	public class Run {
		void run() {
			System.out.println("run");
		}
	}

	private class World {
		void world() {
			System.out.println("world");
		}
	}

	void methodInner() {
		class InnerMethod {
			public void print() {
				System.out.println("inner class");
			}
		}
		InnerMethod inn = new InnerMethod();
		inn.print();
	}
}
