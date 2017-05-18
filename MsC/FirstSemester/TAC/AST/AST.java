public class AST {
	public Name name;
	public Type type; //type can be (int, real, bool, void, error)

	//add methods
}

public class IdAST extends AST {
	public String identifier;
	public ID_data data; //Symbol Table data

	//add methods
}

public class PrintAST extends AST {
	public AST expression;

	//add methods
}

