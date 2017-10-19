package so2.netbeans01;

import java.sql.*;

/**
 *
 * @author jsaias
 */
public class DadosEmbebidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("... inicio");

        String DB_PATH= "DB/teste";
        String DB_USER= "SA";
        String DB_PASSWORD= "";
        System.err.println("AVISO: as configuracoes (path,etc) nao podem estar no codigo fonte!");
        // neste caso, estao aqui para conveniencia e facilidade de execucao do exemplo

        
        java.sql.Connection conn = null;
        
        try {
            // Load the HSQL Database Engine JDBC driver
            // hsqldb.jar should be in the class path or made part of the current jar
            Class.forName("org.hsqldb.jdbcDriver");

            // connect to the database
            conn = DriverManager.getConnection("jdbc:hsqldb:file:"+DB_PATH, 
                    DB_USER, // username
                    DB_PASSWORD);  // password
        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.err.println("PROBLEMA por nao encontrar uma classe! Veja se tem o driver na classpath!");
            System.err.println("Adicionar hsqldb.jar na seccao Libraries");
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.err.println("PROBLEMA com o ACESSO 'a BD: "+se);
        }

        
        Statement st = null;
        try {
            st = conn.createStatement();    // statements
            int i = st.executeUpdate("insert into aluno values (8,'jose');");    // run the query
            if (i == -1) {
                System.out.println("db error ...");
            }
            else
                System.out.println("\t insert OK");
        }
        catch (SQLException se1) {
            se1.printStackTrace();
            System.err.println("PROBLEMA no insert: "+se1);
        }

        try {
            ResultSet rs = null;   // para receber as "linhas" de resultado da query
            st = conn.createStatement();         // statement objects can be reused with
            // repeated calls to execute but we
            // choose to make a new one each time
            rs = st.executeQuery("select * from aluno");    // run the query
            while (rs.next()) {
                System.out.println("RESULTADO (do select): " + rs.getInt(1)+" " + rs.getString(2));
            }
            // do something with the result set.
            st.close();    // NOTE!! if you close a statement the associated ResultSet is closed too
            // -------------------------------------------------------------
            // NOTA: se precisar daqueles valores depois de fechar o Statement ou o ResultSet, 
            //  devera guarda-los numa colecao, para usar a seguir! 
            // -------------------------------------------------------------
        }
        catch (SQLException se2) {
            se2.printStackTrace();
            System.err.println("PROBLEMA no select: "+se2);
        }

        
        // finalizar a ligacao 'a BD
        // em cenarios reais, podera evitar a repeticao de abrir/fechar,
        // usando ligacoes persistentes
        try {
            conn.close();  
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.err.println("PROBLEMA ao fechar connection");
        }
    
    }
    
}
