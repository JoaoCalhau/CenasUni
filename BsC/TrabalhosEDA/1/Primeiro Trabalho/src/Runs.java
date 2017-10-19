public class Runs {
	int runLength, runType, starveTime;
	
	public Runs(int runType, int runLength) {
		this.runType = runType;
		this.runLength = runLength;
	}
	
	public Runs(int runType, int runLength, int starveTime) {
		this.runType = runType;
		this.runLength = runLength;
		this.starveTime = starveTime;
	}
	
	public void incremetLength() {
		this.runLength++;
	}
	
	public int getType() {
		return this.runType;
	}
	
	public int getStarveTime() {
		return this.starveTime;
	}
	
	public int getLength() {
		return this.runLength;
	}
	
	public String toString() {
		if (this.runType == 0) {return "."+this.runLength;}
		else if (this.runType == 1) {return "S"+this.starveTime+","+this.runLength;}
		else {return "F"+this.runLength;}
	}
}
