public class Teste {
	public static void main(String[] args) throws ExceptionMessage {
		RunLengthEncoding cenas = new RunLengthEncoding(4, 5, 3);
		System.out.println(cenas.Lista.toString());
		System.out.println("");
		int[] runTypes = {0, 1, 2, 0, 1};
		int[] runLengths = {2, 5, 3, 1, 1};
		RunLengthEncoding cenas2 = new RunLengthEncoding(3, 4, 3, runTypes, runLengths);
		System.out.println(cenas2.Lista.toString());
		System.out.println("");
		cenas2.restartRuns();
		System.out.println(cenas2.nextRun());
		System.out.println("");
		System.out.println(cenas2.nextRun());
		System.out.println("");
		System.out.println(cenas2.nextRun());
		System.out.println("");
		System.out.println(cenas2.nextRun());
		System.out.println("");
		System.out.println(cenas2.nextRun());
		System.out.println("");
		System.out.println(cenas2.nextRun());
		System.out.println("");
		cenas2.restartRuns();
		System.out.println(cenas2.nextRun());
		System.out.println("");
		cenas2.toOcean();
		/*for (int y=0;y<4;y++)
			for (int x=0;x<3;x++) {
				System.out.println(cenas2.toOcean().cellContents(x, y));
			}*/
		RunLengthEncoding cenas3 = new RunLengthEncoding(cenas2.toOcean());
		System.out.println(cenas3.Lista.toString());
	}
}