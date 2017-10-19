public class Oceano {
	int type, starveTime;
	
	Oceano(int type, int starveTime) {
		this.starveTime=starveTime;
		this.type=type;
	}
	
	Oceano(int type) {
		this.type=type;
	}
	
	int getType() {
		return type;
	}
	
	int getStarveTime() {
		return this.starveTime;
	}
	
	int decrementStarveTime() {
		return this.starveTime-1;
	}
}