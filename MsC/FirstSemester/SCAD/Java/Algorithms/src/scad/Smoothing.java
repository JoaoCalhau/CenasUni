package scad;

public class Smoothing {

    private final double[][] hidden;
    private final double[][] visible;
    private final double[] init;
    private final int[] chain;
    private final int k;
    

    /*
     * Example:
     * hidden = [[0.9, 0.1],
     *           [0.1, 0.9]];
     *
     * visible = [[0.8, 0.2],
     *            [0.2, 0.8]];
     *
     * init = [0.5, 0.5];
     *
     * chain = [0, 0, 1, 1, 1] (A, A, B, B, B)
     *
     * k = 3
     */
    
    
    //Simple constructor
    public Smoothing(double[][] hidden, double[][] visible, double[] init, int[] chain, int k) {
        this.hidden = hidden;
        this.visible = visible;
        this.init = init;
        this.chain = chain;
        this.k = k;
    }
    
    public double[] multiplicator(double[][] a, double[] b) {
        int aRows = a.length;
        int aColumns = a[0].length;
        int bRows = b.length;
        
        if(aColumns != bRows)
            throw new IllegalArgumentException("A: Rows " + aColumns + " did not match B: Columns " + bRows + ".");
        
        double[] c = new double[aRows];
        
        for(int i = 0; i < aRows; i++) {
            for(int j = 0; j < aColumns; j++) {
                c[i] += a[i][j] * b[j];
            }
        }
        
        return c;
    }
    
    public double[] multiplicator(double[] a, double[] b) {
        int aRows = a.length;
        
        double[] c = new double[aRows];
        
        for(int i = 0; i < aRows; i++) {
            c[i] += a[i] * b[i];
        }
        
        return c;
    }
    
    private void reverse(int[] array) {
        for(int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    //Forward Algorithm part
    private double[][] forward() {
       double fwd[][] = new double[chain.length][init.length];
       double gama = 0.0;
       
       //First step
       double[] p = multiplicator(hidden, init);
       
       for(int i = 0; i < p.length; i++) {
           p[i] *= visible[i][chain[0]];
           gama += p[i];
       }
       
       for(int i = 0; i < p.length; i++)
           fwd[0][i] = p[i] / gama;
       
       
       //Second Step
       for(int i = 1; i < fwd.length; i++) {
           gama = 0.0;
           
           p = multiplicator(hidden, fwd[i-1]);
           
           for(int j = 0; j < p.length; j++) {
               p[j] *= visible[j][chain[i]];
               gama += p[j];
           }
           
           for(int j = 0; j < p.length; j++)
               fwd[i][j] = p[j] / gama;
        }
       
       return fwd;
    }
    
    //Backward Algorithm part
    private double[][] backward() {
        /*
        double[] result = new double[2];
        int len = this.chain.length - 1;
        int numSteps = chain.length - k;
        boolean firstStep = true;
        
        for(int i = 0; i < numSteps; i++) {
            if(firstStep) {
                //First Step we use the value 1, because that probability hasnt been observed yet
                result[0] = visible[0][chain[len]] * hidden[0][0] * 1 + visible[1][chain[len]] * hidden[0][1] * 1;
                result[1] = visible[0][chain[len]] * hidden[1][0] * 1 + visible[1][chain[len]] * hidden[1][1] * 1;
                
                len--;
                
                firstStep = false;
            } else {
                //We now use the value calculated in the last iteration
                result[0] = visible[0][chain[len]] * hidden[0][0] * result[0] + visible[1][chain[len]] * hidden[0][1] * result[1];
                result[1] = visible[0][chain[len]] * hidden[1][0] * result[0] + visible[1][chain[len]] * hidden[1][1] * result[1];
                
                len--;
            }
        }
        
        return result;
        */
        
        double[][] bck = new double[chain.length][init.length];
        boolean firstStep = true;
        int[] seq = reverse(chain);
        
        for(int i =  chain.length-1; i >= 0; i--) {
            if(firstStep) {
                
            }
        }
        
        return bck;
        
    }
    
    public double[] forward_backward() {
        double[][] fwdRes = forward();
        double[][] bckRes = backward();
        double[] finalRes = new double[2];
        
        double temp1 = fwdRes[k-1][0] * bckRes[0];
        double temp2 = fwdRes[k-1][1] * bckRes[1];
        double gama = temp1 + temp2;
        
        finalRes[0] = temp1 / gama;
        finalRes[1] = temp2 / gama;
        
        return finalRes;
        
    }
    
    public String printSolutions(double[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for(int i = 0; i < array.length; i++) {
            sb.append(String.format("%.3f", array[i]));
            if(i != array.length-1)
                sb.append(", ");
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    //Simple print of bi-dimentional array
    public String printSolutions(double[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for(int i = 0; i < array.length; i++) {
            sb.append("[");
            for( int j = 0; j < array[0].length; j++) {
                sb.append(String.format("%.3f", array[i][j]));
                if(j != array[0].length-1)
                    sb.append(", ");
            }
            sb.append("]");
            if(i != array.length-1)
                sb.append(", ");
        }
        sb.append("]");
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
       /*
        * Only for testing purposes
        * To test, remove the private declaration from "Forward" and "Backward"
        */
        double hidden[][] = {{0.9, 0.1}, {0,1, 0.9}};
        double visible[][] = {{0.8, 0.2}, {0.2, 0.8}};
        double init[] = {0.5, 0.5};
        int chain[] = {0, 0, 1, 1, 1};
        int k = 3;
        
        Smoothing s = new Smoothing(hidden, visible, init, chain, k);
        
        System.out.print("Showing Forward results:   ");
        System.out.println(s.printSolutions(s.forward()));
        /*
        System.out.print("Showing Backward results:  ");
        System.out.println(s.printSolutions(s.backward()));
        */
        System.out.print("Showing Final results:     ");
        System.out.println(s.printSolutions(s.forward_backward()));
        /*
        //double[] finalRes = s.forward_backward();
        //System.out.println(finalRes[0] + finalRes[1]);
        */
    }
}
