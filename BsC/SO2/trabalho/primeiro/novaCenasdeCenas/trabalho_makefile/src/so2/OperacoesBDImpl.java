package so2;

import java.sql.*;
import java.rmi.server.UnicastRemoteObject;

public class OperacoesBDImpl extends UnicastRemoteObject implements OperacoesBD, java.io.Serializable {

    Connection con = null;
    Statement stmt = null;
    
    
    public OperacoesBDImpl(String host, String db, String user, String pw) throws java.rmi.RemoteException, Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"+ host + ":5432/" + db, user, pw);
            stmt = con.createStatement();
            if (stmt != null)
                System.out.println("ligado á BD");
            else
                System.out.println("Oops! Bitch");
        } catch(Exception e) {
            System.err.println("Oops! Something happenened when connecting!");
        }
    }
    
    
    public void addQuestionario(Questionario x) throws java.rmi.RemoteException {
        inserirBD(x);
    }
    
    public void respondeQuestionario(int numQuestionario, int[] respostas) throws java.rmi.RemoteException {
        updateBD(numQuestionario, respostas);
    }
    
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        removerBD(numQuestionario);
    }
    
    public String returnQuestionarioNome(int numQ) throws java.rmi.RemoteException{
        try {
            String nome = "";
            ResultSet rs = stmt.executeQuery("SELECT idQuest, NomeQuest FROM Questionarios WHERE idQuest=" + numQ);
            while(rs.next())
                nome = rs.getString("NomeQuest");
            
            rs.close();
                
            return nome;
        } catch(Exception e) {
            System.err.println("Oops! Something went wring with the Query!");
        }
        return null;
    }
    
    public Questionario returnQuestionario(int numQ) throws java.rmi.RemoteException{
        Questionario q = null;
        try {
            String NomeQuest = "";
            int tamanhoQ = 0;
            ResultSet rs = stmt.executeQuery("SELECT * FROM Questionarios WHERE idQuest=" + numQ);
            while(rs.next()) {
                NomeQuest = rs.getString("NomeQuest");
                tamanhoQ = rs.getInt("tamanhoQuest");
            }
                    
            Pergunta[] p = new Pergunta[tamanhoQ];
            int total = 0;
            int quantP = 0;
            String NomePergunta = "";
            int i = 0;
            rs = stmt.executeQuery("SELECT * FROM Perguntas WHERE idQuest=" + numQ + " ORDER BY idPergunta");
            while(rs.next()) {
                total = rs.getInt("total");
                quantP = rs.getInt("quantP");
                NomePergunta = rs.getString("NomePergunta");
                Pergunta pn = new Pergunta(NomePergunta, total, quantP);
                p[i] = pn;
                i++;
            }
            rs.close();
            
            q = new Questionario(NomeQuest, p);
            
            if(NomeQuest.equals(""))
                return null;
            
            return q;
        } catch(Exception e) {
            System.err.println("Oops! Something went wrong while trying to select from DB!");
        }
        return q;
    }
    
    public String listarQuestionarios() throws java.rmi.RemoteException {
        String s = "";
       
        try {
            int idQuest = 0;
            String NomeQuest = "";
            ResultSet rs = stmt.executeQuery("SELECT idQuest, NomeQuest FROM Questionarios ORDER BY idQuest");
            while(rs.next()) {
                idQuest = rs.getInt("idQuest");
                NomeQuest = rs.getString("NomeQuest");
                s += idQuest + " - " + NomeQuest + "\n";
            }
            
            rs.close();

        } catch(Exception e) {
            System.err.println("Oops! Something went wrong retrieving list from BD!");
        }
        if (s.equals(""))
            return "Nothing to see here";
        return s;
    }

    public void inserirBD(Questionario q) throws java.rmi.RemoteException {
        try {
            int idQuest = 0;
            String nome = q.getNome();
            int quant = q.getQuantidade();
            
            ResultSet rs = stmt.executeQuery("SELECT curr FROM QuantQuest");
            while(rs.next())
                idQuest = rs.getInt("curr");
            
            rs.close();
            
            idQuest++;
            stmt.executeUpdate("INSERT INTO questionarios VALUES(" + idQuest + ",'" + nome + "'," + quant + ")");
            
            for(int i = 0; i < quant; i++) {
                int j = i+1;
                stmt.executeUpdate("INSERT INTO perguntas VALUES (" +idQuest + "," + j + ",'" + q.getPergunta(j).Nome() + "',0,0)");
            }
            stmt.executeUpdate("UPDATE QuantQuest SET curr=" + idQuest);
            
        } catch(Exception e) {
            System.err.println("Oops! Something went wrong inserting!");
        }
    }
    
    public void updateBD(int numQ, int[] resp) throws java.rmi.RemoteException {
        try {
            int i = 0;
            int[] idResp = new int[resp.length];
            int[] totalResp = new int[resp.length];
            int[] quantPResp = new int[resp.length];
            ResultSet rs = stmt.executeQuery("SELECT idQuest, idPergunta, total, quantP FROM Perguntas WHERE idQuest=" + numQ + " ORDER BY idPergunta");
            while(rs.next()) {
                idResp[i] = rs.getInt("idPergunta");
                totalResp[i] = rs.getInt("total");
                quantPResp[i] = rs.getInt("quantP");
                i++;
            }

            
            rs.close();
            
            for(i = 0; i < idResp.length; i++) {
                totalResp[i] += resp[i];
                quantPResp[i] += 1;
                int j = i+1;
                stmt.executeUpdate("UPDATE Perguntas SET total=" + totalResp[i] + ",quantP=" + quantPResp[i] + " WHERE idQuest=" + numQ + " AND idPergunta=" + j);
            }
        } catch(Exception e) {
            System.err.println("Oops! Something went wrong Updating!");
        }
    }
    
    public void removerBD(int numQ) throws java.rmi.RemoteException {
        try {
            stmt.executeUpdate("DELETE FROM questionarios WHERE idQuest=" + numQ);

        } catch(Exception e) {
            System.err.println("Oops! Something went wrong removing!");
        }
    }
    
    public int returnContador() throws java.rmi.RemoteException {
        int size = 0;
        try {
            int idQuest = 0;
            ResultSet rs = stmt.executeQuery("SELECT idQuest FROM questionarios");
            
            while(rs.next()) {
                idQuest = rs.getInt("idQuest");
                size++;
            }
            
            rs.close();
            
            return size;
        } catch(Exception e) {
            System.err.println("Oops! Erro no contador!");
        }
        return size;
    }
    
    public int returnCurr() throws java.rmi.RemoteException {
        int Curr = 0;
        try {
            ResultSet rs = stmt.executeQuery("SELECT curr FROM quantquest");
            
            while(rs.next()) {
                Curr = rs.getInt("curr");
            }
            
            rs.close();
            
            return Curr;
        } catch(Exception e) {
            System.err.println("Oops! Erro no contador!");
        }
        return Curr;
    }
    
    public void close() throws SQLException {
        stmt.close();
        con.close();
    }
}