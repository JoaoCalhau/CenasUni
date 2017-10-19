import java.util.LinkedList;

public class Serio {
	LinkedList<String> ll;

	public Serio() {
		ll = new LinkedList<String>();
	}

	public void insert(String s) {
		int i = 0;

		if (ll.size() == 0)
			ll.add(0, s);
		else {
			for (String ss : ll) {
				i++;
				if (s.compareTo(ss) > 0) {
					ll.add(i, s);
					break;
				} else if(s.compareTo(ss) < 0) {
					ll.add(i-1, s);
					break;
				} else {
					ll.add(i, s);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Serio cenas = new Serio();

		for(int i = 0; i < args.length; i++) {
			cenas.insert(args[i]);
		}

		System.out.println(cenas.ll.toString());
	}
}

