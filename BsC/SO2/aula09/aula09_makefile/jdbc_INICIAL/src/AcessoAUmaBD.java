import java.sql.*;

public class AcessoAUmaBD {



    public static void main(String[] args) {

	if (args.length<4) {
	    System.err.println("FALTAM OS ARGUMENTOS: host bd user password");
	    System.exit(1);
	}
	
	
	// valores devem ser recebidos como argumento:
	// dados para ligar 'a BD
	// nao podem estar no codigo fonte
	// podem ser lidos de um ficheiro de propriedades

	String USER= args[2], PWD= args[3];
	String PG_HOST= args[0], PG_DB =args[1];
	
	
	Connection con= null;
	Statement stmt= null;			
	
	try {
	    Class.forName ("org.postgresql.Driver");	    
	    // url = "jdbc:postgresql://host:port/database",
	    con = DriverManager.getConnection("jdbc:postgresql://"+PG_HOST+":5432/"+PG_DB,
					      USER,
					      PWD);
	    
	    stmt = con.createStatement();
	    
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("Problems setting the connection");
	}
	
	

	// *******************
	// update/insert
	try {
	    // APENAS se a tabela nao existe:
	    //stmt.executeUpdate("create table personl99999 (id int4, name varchar(64), birth timestamp)");
	    
	    stmt.executeUpdate("insert into personl99999 values(1,'Ola','2000-01-01')");

	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("Problems on insert...");
	}
	
	
	
	
	
	// ******************
	// query	
	try {
	    ResultSet rs = stmt.executeQuery("SELECT id,name,birth,birth as hh from personl99999 order by birth");
	    while (rs.next()) {
		int id= rs.getInt("id");
		String name = rs.getString("name");
		java.sql.Timestamp birth= rs.getTimestamp("birth");
		

		java.sql.Time time= rs.getTime("birth");

		
		System.out.println("Id: "+id+"  name: "+name+
				   "  birth: "+birth+ "   time: "+time);
	    }
	    rs.close();
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("Problems retrieving data from db...");
	}
	

	// importante: fechar a ligacao 'a BD
	try {
	    stmt.close();
	    con.close();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }


}
