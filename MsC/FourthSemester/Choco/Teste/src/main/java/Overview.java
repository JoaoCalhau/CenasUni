import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

/**
 * Trivial example showing how to use Choco Solver
 * to solve the equation system
 * x + y < 5
 * x * y = 4
 * with x in [0,5] and y in {2, 3, 8}
 *
 * @author Charles Prud'homme, Jean-Guillaume Fages
 * @since 9/02/2016
 */
public class Overview {

    public static void main(String[] args) {
        // 1. Create a Model
        Model model = new Model("my first problem");
        // 2. Create variables
        IntVar x = model.intVar("X", 0, 5);                 // x in [0,5]
        IntVar y = model.intVar("Y", new int[]{2, 3, 8});   // y in {2, 3, 8}
        // 3. Post constraints
        model.arithm(x, "+", y, "<", 5).post(); // x + y < 5
        model.times(x,y,4).post();              // x * y = 4
        // 4. Solve the problem
        model.getSolver().solve();
        // 5. Print the solution
        System.out.println(x); // Prints X = 2
        System.out.println(y); // Prints Y = 2
    }
}