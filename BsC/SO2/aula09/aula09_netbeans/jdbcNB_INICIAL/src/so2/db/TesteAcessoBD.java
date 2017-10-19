package so2.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jsaias
 */
public class TesteAcessoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // coloque os argumentos
        
        // PostgresConnector pc = new PostgresConnector( ?? );
        // NOTA: se isto nao fosse uma domonstacao, nao PODIA ter configuracoes no codigo fonte!!!
        
        if (args.length < 4) {
            System.err.println("To few arguments");
        }
        
        PostgresConnector pc = new PostgresConnector(args[0], args[1], args[2], args[3]);
        // estabelecer a ligacao ao SGBD
        pc.connect();
        Statement stmt = pc.getStatement();

	// *******************
        // update/insert
        try {
            stmt.executeUpdate("insert into personl99999 values(23627,'Cenas','2016-04-18 10:47:00')");
           // AQUI: operacao para inserir um registo com o seu nome...

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems on insert...");
        }

	// ******************
        // query	
        try {
            
            ResultSet rs = stmt.executeQuery("SELECT id,name,birth,extract(hour from birth) as hh from personl99999 order by birth");

            while (rs.next()) {
                int id= rs.getInt("id");
                String name = rs.getString("name");
                java.sql.Timestamp birth= rs.getTimestamp("birth");  
                java.sql.Time time= rs.getTime("birth");
 
                System.out.println("Id: "+id+"  name: "+name+
                                   "  birth: "+birth+ "   time: "+time);
            }
            rs.close(); // muito importante depois da consulta!
            // AQUI: codigo para realizar a CONSULTA
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }

        // desligar do SGBD:
        pc.disconnect();
    }


}
