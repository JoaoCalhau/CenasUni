package so2;

import java.sql.*;

public class PostgresConnector {
    
    private String PG_HOST;
    private String PG_DB;
    private String USER;
    private String PWD;
    
    Connection con = null;
    Statement stmt = null;
    
    public PostgresConnector(String host, String db, String user, String pw) {
        PG_HOST = host;
        PG_DB = db;
        USER = user;
        PWD = pw;
    }
    
    public void connect() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            
            con = DriverManager.getConnection("jdbc:posrtgresql://" + PG_HOST + ":5432/" + PG_DB,
                    USER,
                    PWD);
            
            stmt = con.createStatement();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Problems setting the connection");
        }   
    }
    
    public void disconnect() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Oops! Something went wrong!");
        }
    }

    public Statement getStatement() {
        return stmt;
    }
}
