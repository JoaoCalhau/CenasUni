package Trabuco;

public class Animais {
	private static int type;
	int starveTime;
	Animais(int type) {
		Animais.setType(type);
	}
	static int getType() {
		return type;
	}
	int getStarveTime() {
		return starveTime;
	}
	Tubaralho decrementStarveTime() {
		return new Tubaralho(starveTime-1);
	}
	public static void setType(int type) {
		Animais.type = type;
	}
}