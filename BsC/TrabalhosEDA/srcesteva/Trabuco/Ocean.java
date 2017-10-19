package Trabuco;

/* Ocean.java */

/**
 *  The Ocean class defines an object that models an ocean full of sharks and
 *  fish.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Ocean(int i, int j, int starveTime);
 *
 *  that creates an empty ocean having width i and height j, in which sharks
 *  starve after starveTime timesteps.
 *
 *  See the README file accompanying this project for additional details.
 */

public class Ocean {

	/**
	 *  Do not rename these constants.  WARNING:  if you change the numbers, you
	 *  will need to recompile Test4.java.  Failure to do so will give you a very
	 *  hard-to-find bug.
	 */

	public final static int EMPTY = 0;
	public final static int SHARK = 1;
	public final static int FISH = 2;

	/**
	 *  Define any variables associated with an Ocean object here.  These
	 *  variables MUST be private.
	 */
	private static Animais[][] oceano = new Animais[Ocean.width()][Ocean.height()];
	private static int starveTime, width, height;

	/**
	 *  The following methods are required for Part I.
	 */

	/**
	 *  Ocean() is a constructor that creates an empty ocean having width i and
	 *  height j, in which sharks starve after starveTime timesteps.
	 *  @param i is the width of the ocean.
	 *  @param j is the height of the ocean.
	 *  @param starveTime is the number of timesteps sharks survive without food.
	 */

	public Ocean(int i, int j, int starveTime) {
		Ocean.oceano = new Animais[i][j];
		Ocean.starveTime=starveTime;
		Ocean.width=i;
		Ocean.height=j;
		for(int m=0;m<=i;m++) {
			for(int n=0;n<=j;j++) {
				Ocean.oceano[m][n] = new Nada();
			}
		}
	}

	/**
	 *  width() returns the width of an Ocean object.
	 *  @return the width of the ocean.
	 */

	public static int width() {
		return width;
	}

	/**
	 *  height() returns the height of an Ocean object.
	 *  @return the height of the ocean.
	 */

	public static int height() {
		return height;
	}

	/**
	 *  starveTime() returns the number of timesteps sharks survive without food.
	 *  @return the number of timesteps sharks survive without food.
	 */

	public static int starveTime() {
		return starveTime;
	}

	/**
	 *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
	 *  cell is already occupied, leave the cell as it is.
	 *  @param x is the x-coordinate of the cell to place a fish in.
	 *  @param y is the y-coordinate of the cell to place a fish in.
	 */

	/*public void addFish(int x, int y) {
		if(Ocean.oceano[(int) x%Ocean.width()][(int) y%Ocean.height()].getType()== 0) {
			Ocean.oceano[(int) x%Ocean.width()][(int) y%Ocean.height()] = new Pexe();}
		else return;
	}*/
	
	
	public void addFish(int x, int y) {
		Integer numX;
		numX= new Integer(x%Ocean.width());
		Integer numY;
		numY= new Integer(y%Ocean.width());
		if(Ocean.oceano[numX][numY].getType() == 0) {
			Ocean.oceano[numX][numY] = new Pexe();}
		else return;
	}

	/**
	 *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
	 *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
	 *  just eaten.  If the cell is already occupied, leave the cell as it is.
	 *  @param x is the x-coordinate of the cell to place a shark in.
	 *  @param y is the y-coordinate of the cell to place a shark in.
	 */

	public void addShark(int x, int y) {
		Integer numX;
		numX= new Integer(x%Ocean.width());
		Integer numY;
		numY= new Integer(y%Ocean.width());
		if(Ocean.oceano[numX][numY].getType()==1) {
			Ocean.oceano[numX][numY] = new Tubaralho(starveTime());}
		else return;
	}

	/**
	 *  cellContents() returns EMPTY if cell (x, y) is empty, FISH if it contains
	 *  a fish, and SHARK if it contains a shark.
	 *  @param x is the x-coordinate of the cell whose contents are queried.
	 *  @param y is the y-coordinate of the cell whose contents are queried.
	 */

	public int cellContents(int x, int y) {
		//System.out.println(oceano[x][y].getType()==0);
		if(oceano[x][y].getType()==0) return EMPTY;
		else if(oceano[x][y].getType()==1) return SHARK;
		else return FISH;
	}

	/**
	 *  timeStep() performs a simulation timestep as described in README.
	 *  @return an ocean representing the elapse of one timestep.
	 */

	public Ocean timeStep() {
		Ocean newOcean = new Ocean(width(), height(), starveTime());
		for (int i=0;i<=width()-1;i++) {
			for (int j=0;j<=height()-1;j++) {
				
				//Nada...
				if (oceano[i][j].getType()==0) {
					if (i==0 && j==0) {
						if (oceano[width()-1-1][height()-1-1].getType()==2 || 
								oceano[i][height()-1-1].getType()==2 || 
								oceano[i+1][height()-1].getType()==2 || 
								oceano[i+1][j].getType()==2 || 
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 || 
								oceano[width()-1][j+1].getType()==2 || 
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (((oceano[width()-1][height()-1].getType()==2 && oceano[i][height()-1].getType()==2) ||
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][height()-1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[width()-1][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][height()-1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i+1][j].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][height()-1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[i+1][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[i][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][j].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i+1][j+1].getType()==2 && oceano[i][j+1].getType()==2) ||
								(oceano[i+1][j+1].getType()==2 && oceano[width()-1][j+1].getType()==2) || 
								(oceano[i+1][j+1].getType()==2 && oceano[width()-1][j].getType()==2) || 
								(oceano[i][j+1].getType()==2 && oceano[width()-1][j+1].getType()==2) ||
								(oceano[i][j+1].getType()==2 && oceano[width()-1][j].getType()==2) ||
								(oceano[width()-1][j+1].getType()==2 && oceano[width()-1][j].getType()==2)) &&
								(oceano[width()-1][height()-1].getType()==1 || 
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();
							
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==0){
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[0][height()-1].getType()==2 || 
								oceano[0][0].getType()==2 ||
								oceano[0][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (((oceano[i-1][height()-1].getType()==1 && oceano[i][height()-1].getType()==1) ||
								(oceano[i-1][height()-1].getType()==1 && oceano[0][height()-1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][height()-1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[0][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[0][height()-1].getType()==1 || 
								oceano[0][0].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==height()-1) {

						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[0][j-1].getType()==2 || 
								oceano[0][j].getType()==2 ||
								oceano[0][0].getType()==2 || 
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[0][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i][0].getType()==1) ||
								(oceano[0][0].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[0][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[i-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][0].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0 && j==height()-1){

						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 || 
								oceano[width()-1][0].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[width()-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i][0].getType()==1) ||
								(oceano[i+1][0].getType()==1 && oceano[width()-1][0].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[width()-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[width()-1][j].getType()==1) ||
								(oceano[width()-1][j].getType()==1 && oceano[width()-1][j].getType()==1)) &&
								(oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[width()-1][0].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==0) {
						
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][height()-1].getType()==1 && oceano[i][height()-1].getType()==1) ||
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][height()-1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][height()-1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][height()-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1) {
						
						if (oceano[i-1][j-1].getType()==2 || 
								oceano[i][j-1].getType()==2 ||
								oceano[0][j-1].getType()==2 ||
								oceano[0][j].getType()==2 || 
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 || 
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];	
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[0][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[0][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==height()-1){
							
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 || 
								oceano[i-1][0].getType()==2 || 
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][0].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[0][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][0].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][0].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][0].getType()==1 && oceano[i-1][0].getType()==1) ||
								(oceano[i][0].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][0].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0) {
						
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 || 
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (((oceano[width()-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[width()-1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[width()-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[width()-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[width()-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[width()-1][j].getType()==1) ||
								(oceano[width()-1][j+1].getType()==1 && oceano[width()-1][j].getType()==1)) &&
								(oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else {
						
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = oceano[i][j];		
						
						}else if (((oceano[i-1][j-1].getType()==1 && oceano[i][j-1].getType()==1) ||
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i-1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j-1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j-1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i+1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i][j+1].getType()==1) ||
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) || 
								(oceano[i+1][j+1].getType()==1 && oceano[i-1][j].getType()==1) || 
								(oceano[i][j+1].getType()==1 && oceano[i-1][j+1].getType()==1) ||
								(oceano[i][j+1].getType()==1 && oceano[i-1][j].getType()==1) ||
								(oceano[i-1][j+1].getType()==1 && oceano[i-1][j].getType()==1)) &&
								(oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1)) {newOcean.oceano[i][j] = new Pexe();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}

				
				//Pexes...
				}else if (oceano[i][j].getType()==2) {
					if (i==0 && j==0) {
						if ((oceano[width()-1][height()-1].getType()==2 || oceano[width()-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[i+1][height()-1].getType()==2 || oceano[i+1][height()-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[width()-1][j+1].getType()==2 || oceano[width()-1][j+1].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (oceano[width()-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
							
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==0){
						if ((oceano[i-1][height()-1].getType()==2 || oceano[i-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[0][height()-1].getType()==2 || oceano[0][height()-1].getType()==0) && 
								(oceano[0][0].getType()==2 || oceano[0][0].getType()==0) && 
								(oceano[0][j+1].getType()==2 || oceano[0][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
								
						}else if (oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[0][height()-1].getType()==1 || 
								oceano[0][0].getType()==1 ||
								oceano[0][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1 && j==height()-1) {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[0][j-1].getType()==2 || oceano[0][j-1].getType()==0) && 
								(oceano[0][j].getType()==2 || oceano[0][j].getType()==0) && 
								(oceano[0][0].getType()==2 || oceano[0][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[i-1][0].getType()==2 || oceano[i-1][0].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 || 
								oceano[0][j].getType()==1 ||
								oceano[0][0].getType()==1 || 
								oceano[i][0].getType()==1 ||
								oceano[i-1][0].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
						
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0 && j==height()-1){
						if ((oceano[width()-1][j-1].getType()==2 || oceano[width()-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][0].getType()==2 || oceano[i+1][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[width()-1][0].getType()==2 || oceano[width()-1][0].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 || 
								oceano[width()-1][0].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==0) {
						if ((oceano[i-1][height()-1].getType()==2 || oceano[i-1][height()-1].getType()==0) && 
								(oceano[i][height()-1].getType()==2 || oceano[i][height()-1].getType()==0) && 
								(oceano[i+1][height()-1].getType()==2 || oceano[i+1][height()-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][height()-1].getType()==1 ||
								oceano[i][height()-1].getType()==1 ||
								oceano[i+1][height()-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==width()-1) {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[0][j-1].getType()==2 || oceano[0][j-1].getType()==0) && 
								(oceano[0][j].getType()==2 || oceano[0][j].getType()==0) && 
								(oceano[0][j+1].getType()==2 || oceano[0][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 || 
								oceano[i][j-1].getType()==1 ||
								oceano[0][j-1].getType()==1 ||
								oceano[0][j].getType()==1 || 
								oceano[0][j+1].getType()==1 || 
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 || 
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();	
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (j==height()-1){
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][0].getType()==2 || oceano[i+1][0].getType()==0) && 
								(oceano[i][0].getType()==2 || oceano[i][0].getType()==0) && 
								(oceano[i-1][0].getType()==2 || oceano[i-1][0].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
							
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 || 
								oceano[i+1][j-1].getType()==1 ||
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][0].getType()==1 ||
								oceano[i][0].getType()==1 || 
								oceano[i-1][0].getType()==1 || 
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else if (i==0) {
						if ((oceano[width()-1][j-1].getType()==2 || oceano[width()-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[width()-1][j+1].getType()==2 || oceano[width()-1][j+1].getType()==0) && 
								(oceano[width()-1][j].getType()==2 || oceano[width()-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[width()-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 ||
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 || 
								oceano[i+1][j+1].getType()==1 ||
								oceano[i][j+1].getType()==1 ||
								oceano[width()-1][j+1].getType()==1 ||
								oceano[width()-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}else {
						if ((oceano[i-1][j-1].getType()==2 || oceano[i-1][j-1].getType()==0) && 
								(oceano[i][j-1].getType()==2 || oceano[i][j-1].getType()==0) && 
								(oceano[i+1][j-1].getType()==2 || oceano[i+1][j-1].getType()==0) && 
								(oceano[i+1][j].getType()==2 || oceano[i+1][j].getType()==0) && 
								(oceano[i+1][j+1].getType()==2 || oceano[i+1][j+1].getType()==0) && 
								(oceano[i][j+1].getType()==2 || oceano[i][j+1].getType()==0) && 
								(oceano[i-1][j+1].getType()==2 || oceano[i-1][j+1].getType()==0) && 
								(oceano[i-1][j].getType()==2 || oceano[i-1][j].getType()==0)) {newOcean.oceano[i][j] = oceano[i][j];
						
						}else if (oceano[i-1][j-1].getType()==1 ||
								oceano[i][j-1].getType()==1 || 
								oceano[i+1][j-1].getType()==1 || 
								oceano[i+1][j].getType()==1 ||
								oceano[i+1][j+1].getType()==1 || 
								oceano[i][j+1].getType()==1 ||
								oceano[i-1][j+1].getType()==1 ||
								oceano[i-1][j].getType()==1) {newOcean.oceano[i][j] = new Nada();		
								
						}else {newOcean.oceano[i][j] = new Tubaralho(starveTime());}
						
					}
					
				//Tubaralhos...
				}else if ((oceano[i][j].getType()==1)){
					if (i==0 && j==0) {
						if (oceano[width()-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==width()-1 && j==0){
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 || 
								oceano[0][height()-1].getType()==2 ||
								oceano[0][0].getType()==2 ||
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==width()-1 && j==height()-1) {
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[0][j-1].getType()==2 || 
								oceano[0][j].getType()==2 || 
								oceano[0][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}
						}
					}else if (i==0 && j==height()-1){
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[width()-1][0].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (j==0) {
						if (oceano[i-1][height()-1].getType()==2 ||
								oceano[i][height()-1].getType()==2 ||
								oceano[i+1][height()-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (i==width()-1) {
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[0][j-1].getType()==2 ||
								oceano[0][j].getType()==2 ||
								oceano[0][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 ||
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (j==height()-1){
						if (oceano[i-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][0].getType()==2 ||
								oceano[i][0].getType()==2 ||
								oceano[i-1][0].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else if (i==0) {
						if (oceano[width()-1][j-1].getType()==2 ||
								oceano[i][j-1].getType()==2 || 
								oceano[i+1][j-1].getType()==2 || 
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 ||
								oceano[i][j+1].getType()==2 ||
								oceano[width()-1][j+1].getType()==2 ||
								oceano[width()-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}else {
						if (oceano[i-1][j-1].getType()==2 || 
								oceano[i][j-1].getType()==2 ||
								oceano[i+1][j-1].getType()==2 ||
								oceano[i+1][j].getType()==2 ||
								oceano[i+1][j+1].getType()==2 || 
								oceano[i][j+1].getType()==2 || 
								oceano[i-1][j+1].getType()==2 ||
								oceano[i-1][j].getType()==2) {newOcean.oceano[i][j] = new Tubaralho(starveTime());
						}else {
							if (oceano[i][j].starveTime == 1) {
								newOcean.oceano[i][j] = new Nada();
							}else {
								newOcean.oceano[i][j] = new Tubaralho(oceano[i][j].starveTime-1);
							}						}
					}
				}
			}
		}
		return newOcean;
	}

	/**
	 *  The following method is required for Part II.
	 */

	/**
	 *  addShark() (with three parameters) places a shark in cell (x, y) if the
	 *  cell is empty.  The shark's hunger is represented by the third parameter.
	 *  If the cell is already occupied, leave the cell as it is.  You will need
	 *  this method to help convert run-length encodings to Oceans.
	 *  @param x is the x-coordinate of the cell to place a shark in.
	 *  @param y is the y-coordinate of the cell to place a shark in.
	 *  @param feeding is an integer that indicates the shark's hunger.  You may
	 *         encode it any way you want; for instance, "feeding" may be the
	 *         last timestep the shark was fed, or the amount of time that has
	 *         passed since the shark was last fed, or the amount of time left
	 *         before the shark will starve.  It's up to you, but be consistent.
	 */

	public void addShark(int x, int y, int feeding) {
		if (oceano[x][y].getType()==0) {oceano[x][y] = new Tubaralho(feeding);}
		else return;
	}

	/**
	 *  The following method is required for Part III.
	 */

	/**
	 *  sharkFeeding() returns an integer that indicates the hunger of the shark
	 *  in cell (x, y), using the same "feeding" representation as the parameter
	 *  to addShark() described above.  If cell (x, y) does not contain a shark,
	 *  then its return value is undefined--that is, anything you want.
	 *  Normally, this method should not be called if cell (x, y) does not
	 *  contain a shark.  You will need this method to help convert Oceans to
	 *  run-length encodings.
	 *  @param x is the x-coordinate of the cell whose contents are queried.
	 *  @param y is the y-coordinate of the cell whose contents are queried.
	 */

	public int sharkFeeding(int x, int y) {
		if (oceano[x][y].getType()==1) {return oceano[x][y].getStarveTime();}
		else return -1;
	}

}
