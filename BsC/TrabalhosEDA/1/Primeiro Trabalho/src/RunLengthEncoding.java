import java.util.ListIterator;

/* RunLengthEncoding.java */

/**
 *  The RunLengthEncoding class defines an object that run-length encodes an
 *  Ocean object.  Descriptions of the methods you must implement appear below.
 *  They include constructors of the form
 *
 *      public RunLengthEncoding(int i, int j, int starveTime);
 *      public RunLengthEncoding(int i, int j, int starveTime,
 *                               int[] runTypes, int[] runLengths) {
 *      public RunLengthEncoding(Ocean ocean) {
 *
 *  that create a run-length encoding of an Ocean having width i and height j,
 *  in which sharks starve after starveTime timesteps.
 *
 *  The first constructor creates a run-length encoding of an Ocean in which
 *  every cell is empty.  The second constructor creates a run-length encoding
 *  for which the runs are provided as parameters.  The third constructor
 *  converts an Ocean object into a run-length encoding of that object.
 *
 *  See the README file accompanying this project for additional details.
 */

public class RunLengthEncoding {

	/**
	 *  Define any tempiables associated with a RunLengthEncoding object here.
	 *  These tempiables MUST be private.
	 */

	DoublyLinkedList<Runs> Lista; //put as private later
	private int contador=-1;
	private int i, j, starveTime;


	/**
	 *  The following methods are required for Part II.
	 */

	/**
	 *  RunLengthEncoding() (with three parameters) is a constructor that creates
	 *  a run-length encoding of an empty ocean having width i and height j,
	 *  in which sharks starve after starveTime timesteps.
	 *  @param i is the width of the ocean.
	 *  @param j is the height of the ocean.
	 *  @param starveTime is the number of timesteps sharks survive without food.
	 */

	public RunLengthEncoding(int i, int j, int starveTime) {
		this.i=i;
		this.j=j;
		this.starveTime=starveTime;
		int num=i*j;
		Lista = new DoublyLinkedList<Runs>();
		Lista.add(new Runs(0, num));
	}

	/**
	 *  RunLengthEncoding() (with five parameters) is a constructor that creates
	 *  a run-length encoding of an ocean having width i and height j, in which
	 *  sharks starve after starveTime timesteps.  The runs of the run-length
	 *  encoding are taken from two input arrays.  Run i has length runLengths[i]
	 *  and species runTypes[i].
	 *  @param i is the width of the ocean.
	 *  @param j is the height of the ocean.
	 *  @param starveTime is the number of timesteps sharks survive without food.
	 *  @param runTypes is an array that represents the species represented by
	 *         each run.  Each element of runTypes is Ocean.EMPTY, Ocean.FISH,
	 *         or Ocean.SHARK.  Any run of sharks is treated as a run of newborn
	 *         sharks (which are equivalent to sharks that have just eaten).
	 *  @param runLengths is an array that represents the length of each run.
	 *         The sum of all elements of the runLengths array should be i * j.
	 */

	public RunLengthEncoding(int i, int j, int starveTime, int[] runTypes, int[] runLengths) {
		this.i=i;
		this.j=j;
		this.starveTime=starveTime;
		Lista = new DoublyLinkedList<Runs>();
		for (int n=0;n<runTypes.length;n++) {
			if (runTypes[n] == Ocean.EMPTY) Lista.add(new Runs(0, runLengths[n]));
			else if (runTypes[n] == Ocean.SHARK) Lista.add(new Runs(1, runLengths[n], starveTime));
			else if (runTypes[n] == Ocean.FISH) Lista.add(new Runs(2, runLengths[n]));
		}
	}

	/**
	 *  restartRuns() and nextRun() are two methods that work together to return
	 *  all the runs in the run-length encoding, one by one.  Each time
	 *  nextRun() is invoked, it returns a different run (represented as a
	 *  TypeAndSize object), until every run has been returned.  The first time
	 *  nextRun() is invoked, it returns the first run in the encoding, which
	 *  contains cell (0, 0).  After every run has been returned, nextRun()
	 *  returns null, which lets the calling program know that there are no more
	 *  runs in the encoding.
	 *
	 *  The restartRuns() method resets the enumeration, so that nextRun() will
	 *  once again enumerate all the runs as if nextRun() were being invoked for
	 *  the first time.
	 *
	 *  (Note:  Don't worry about what might happen if nextRun() is interleaved
	 *  with addFish() or addShark(); it won't happen.)
	 */

	/**
	 *  restartRuns() resets the enumeration as described above, so that
	 *  nextRun() will enumerate all the runs from the beginning.
	 */

	public void restartRuns() {
		contador=-1;
	}

	/**
	 *  nextRun() returns the next run in the enumeration, as described above.
	 *  If the runs have been exhausted, it returns null.  The return value is
	 *  a TypeAndSize object, which is nothing more than a way to return two
	 *  integers at once.
	 *  @return the next run in the enumeration, represented by a TypeAndSize
	 *          object.
	 */

	public TypeAndSize nextRun() {
		int count=0;
		Runs sol = new Runs(0,0);
		if (contador == Lista.size()) {
			return null;
		}else {
			if (contador == -1) {contador=0;}
			for (Runs r : Lista) {
				if(count==contador) {
					sol=r;
					break;
				}
				count++;
			}
			contador++;
			return new TypeAndSize(sol.getType(), sol.getLength());
		}
	}

	/**
	 *  toOcean() converts a run-length encoding of an ocean into an Ocean
	 *  object.  You will need to implement the three-parameter addShark method
	 *  in the Ocean class for this method's use.
	 *  @return the Ocean represented by a run-length encoding.
	 */

	public Ocean toOcean() {
		Ocean newOcean = new Ocean(this.i, this.j, this.starveTime);
		int countX=0;
		int countY=0;
		for (Runs r : Lista) {
			if (r.toString().substring(0,1).compareTo(".")==0) {
				for (int i=0;i<Integer.parseInt(r.toString().substring(1));i++) {
					if (countX==newOcean.width()-1) {
						countX=0;
						countY++;
					}else {
						countX+=1;
					}
				}
			}else if (r.toString().substring(0,1).compareTo("F")==0) {
				for (int i=0;i<Integer.parseInt(r.toString().substring(1));i++) {
					if (countX==newOcean.width()-1) {
						newOcean.addFish(countX, countY);
						countX=0;
						countY++;
					}else {
						newOcean.addFish(countX, countY);
						countX+=1;
					}
				}
			}else if (r.toString().substring(0,1).compareTo("S")==0) {
				for (int i=0;i<Integer.parseInt(r.toString().substring(3));i++) {
					if (countX==newOcean.width()-1) {
						newOcean.addShark(countX, countY, Integer.parseInt(r.toString().substring(1, 2)));
						countX=0;
						countY++;
					}else {
						newOcean.addShark(countX, countY, Integer.parseInt(r.toString().substring(1, 2)));
						countX+=1;
					}
				}
			}
		}
		return newOcean;
	}

	/**
	 *  The following method is required for Part III.
	 */

	/**
	 *  RunLengthEncoding() (with one parameter) is a constructor that creates
	 *  a run-length encoding of an input Ocean.  You will need to implement
	 *  the sharkFeeding method in the Ocean class for this constructor's use.
	 *  @param sea is the ocean to encode.
	 * @throws ExceptionMessage 
	 */

	public RunLengthEncoding(Ocean sea) {
		Ocean oceano = sea;
		this.i = oceano.width();
		this.j = oceano.height();
		this.starveTime = oceano.starveTime();
		Lista = new DoublyLinkedList<Runs>();
		int var=0;
		int animalType = 0;
		animalType = oceano.cellContents(0, 0);
		if (animalType == 1) {Lista.add(new Runs(1, 1, oceano.sharkFeeding(0, 0)));}
		if (animalType == 0) {Lista.add(new Runs(0, 1));}
		if (animalType == 2) {Lista.add(new Runs(2, 1));}
		ListIterator<Runs> iterador = Lista.iterator();
		Runs anterior;
		anterior = iterador.next();
		for (int y=0;y<this.j;y++) {
			for (int x=0;x<this.i;x++) {
				if (x==0 && y==0) {
					continue;
				}else {
					animalType = oceano.cellContents(x, y);
					if (animalType == anterior.getType()) {
						if (animalType == 1) {
							int feed = oceano.sharkFeeding(x, y);
							if (feed == anterior.getStarveTime()) {
								anterior.incremetLength();
								iterador.set(anterior);
							}else {
								Runs outro = new Runs(1, 1, oceano.sharkFeeding(x, y));
								Lista.add(outro);
								var++;
								iterador = Lista.iterator();
								int temp = var;
								while (temp > 0) {
									anterior = iterador.next();
									temp--;
								}
							}
						}else if (animalType == 2 || animalType == 0) {
							anterior.incremetLength();
							iterador.set(anterior);
						}
					}else {
						if (animalType == 1) {
							Runs outro = new Runs(1, 1, oceano.sharkFeeding(x, y));
							Lista.add(outro);
							var++;
							iterador = Lista.iterator();
							int temp = var;
							while (temp >= 0) {
								anterior = iterador.next();
								temp--;
							}
						}else {
							Runs outro = new Runs(animalType, 1);
							Lista.add(outro);
							var++;
							iterador = Lista.iterator();
							int temp = var;
							while (temp >= 0) {
								anterior = iterador.next();
								temp--;
							}
						}
					}
				}
			}
		}
		check();
	}

	/**
	 *  The following methods are required for Part IV.
	 */

	/**
	 *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
	 *  cell is already occupied, leave the cell as it is.  The final run-length
	 *  encoding should be compressed as much as possible; there should not be
	 *  two consecutive runs of sharks with the same degree of hunger.
	 *  @param x is the x-coordinate of the cell to place a fish in.
	 *  @param y is the y-coordinate of the cell to place a fish in.
	 * @throws ExceptionMessage 
	 */

	public void addFish(int x, int y) {
		// Your solution here, but you should probably leave the following line
		//   at the end.
		check();
	}

	/**
	 *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
	 *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
	 *  just eaten.  If the cell is already occupied, leave the cell as it is.
	 *  The final run-length encoding should be compressed as much as possible;
	 *  there should not be two consecutive runs of sharks with the same degree
	 *  of hunger.
	 *  @param x is the x-coordinate of the cell to place a shark in.
	 *  @param y is the y-coordinate of the cell to place a shark in.
	 * @throws ExceptionMessage 
	 */

	public void addShark(int x, int y) {
		// Your solution here, but you should probably leave the following line
		//   at the end.
		check();
	}

	/**
	 *  check() walks through the run-length encoding and prints an error message
	 *  if two consecutive runs have the same contents, or if the sum of all run
	 *  lengths does not equal the number of cells in the ocean.
	 * @throws ExceptionMessage 
	 */

	public void check() {
		Runs last = new Runs(0,0);
		int count=0;
		for (Runs r : Lista) {
			if (count==0) {
				last=r;
				count++;
			}else {
				if (r.getType()==1 && last.getType()==1 && r.getStarveTime()==last.getStarveTime()) {
					System.out.println("Something's wrong.... Your encoding may be bad!");
				}else if (r.getType() == last.getType() && r.getType() !=1) {
					System.out.println("Something's wrong.... Your encoding may be bad!");
				}else {
					last=r;
					count++;
				}
			}
		}
		System.out.println("Congrats! Your encoding is PERFECT!");
	}

}