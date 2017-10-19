package Trabuco;

public class Tubaralho extends Animais {
	int starveTime;
	Tubaralho(int starveTime) {
		super(1);
		this.starveTime=starveTime;
	}
	int getType() {
		return type;
	}
	int getStarveTime() {
		return starveTime;
	}
	Tubaralho decrementStarveTime() {
		return new Tubaralho(starveTime-1);
	}
}