package so2.rest;

import java.util.*;
import java.sql.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "bd")
public class QuestBd {
   
   @XmlElement(required = true)
   Connection con = null;
   @XmlElement(required = true)
   Statement stmt = null;
   
   public QuestBd(String host, String db, String user, String pw) {
       try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"+ host + ":5432/" + db, user, pw);
            stmt = con.createStatement();
            if (stmt != null)
                System.out.println("Ligado á BD");
            else
                System.out.println("Oops! Could not connect...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Oops! Exception when connecting..");
        }
   }
   
   //FUNCA
   public void addQuest( QuestImpl q ) {
       try {
            int idQuest = q.getNumQ();
            String nome = q.getNome();
            int quant = q.size();
            
            stmt.executeUpdate("INSERT INTO questionarios VALUES(" + idQuest + ",'" + nome + "'," + quant + ")");
            int j = 1;
            for(PergQuest p : q.getPerg()) {
                stmt.executeUpdate("INSERT INTO perguntas VALUES (" + idQuest + "," + j + ",'" + p.getNome() + "',0,0)");
                j++;
            }
            
        } catch(Exception e) {
            System.err.println("Oops! Something went wrong inserting!");
        }
   }
   
   //FUNCA
   public void answerQuest( QuestImpl q ) {
       try {
            for(int i = 0; i < q.getPerg().size(); i++) {
                int j = i+1;
                stmt.executeUpdate("UPDATE Perguntas SET total=" + q.getPerg().get(i).getRespostas() + ",quantP=" + q.getPerg().get(i).getTotal() + " WHERE idQuest=" + q.getNumQ() + " AND idPergunta=" + j);
            }
            
            
        } catch(Exception e) {
            System.err.println("Oops! Something went wrong Updating!");
        }
    }
   
   //FUNCA
   public void removeQuest( QuestImpl q ) {
       try {
           stmt.executeUpdate("DELETE FROM questionarios WHERE idQuest=" + q.getNumQ());
        
       } catch (Exception e) {
           System.err.println("Oops! Something went wrong removing!");
       }
   }
   
   //FUNCA
   public List<QuestImpl> getQuestList() {
       try {
        List<QuestImpl> l = new ArrayList<>();
        QuestImpl q;
        
        String name;
        int total;
        int size;
        int quantP;
        List<Integer> numQ = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT idQuest, NomeQuest, tamanhoQuest FROM questionarios");
        
        int j = 0;
        while(rs.next()) {
            numQ.add(rs.getInt("idQuest"));
            name = rs.getString("NomeQuest");
            size = rs.getInt("tamanhoQuest");
            q = new QuestImpl(name);
            q.setNumQ(numQ.get(j++));
            q.setMaxSize(size);
            l.add(q);
        }
        
        
        for(int i : numQ) {
            List<PergQuest> lp = new ArrayList<>();
            rs = stmt.executeQuery("SELECT NomePergunta, total, quantP FROM perguntas WHERE idQuest=" + i + "ORDER BY idPergunta");
            while(rs.next()) {
              name = rs.getString("NomePergunta");
              total = rs.getInt("total");
              quantP = rs.getInt("quantP");
              PergQuest p = new PergQuest(name);
              p.setResposta(total);
              p.setTotal(quantP);
              lp.add(p);
            }
            for(QuestImpl qs : l)
                if(qs.getNumQ() == i)
                    qs.setPerg(lp);
                
        }
        
        rs.close();
 
        if(!l.isEmpty()) {
            System.out.println("Updated from BD");
            return l;
        } else {
            System.out.println("Nothing to update from BD");
            return new ArrayList<>();
        }
       } catch (Exception e) {
           System.out.println("Nothing to update from BD");
           return new ArrayList<>();
       }
   }
   
   public int getCurr() {
       try {
        int curr = 0;

        ResultSet rs = stmt.executeQuery("SELECT curr FROM quantquest");

        while(rs.next())
            curr = rs.getInt("curr");
        
        rs.close();

        return curr;
       } catch (Exception e) {
           System.err.println("get curr error");
           return 0;
       }
   }
   
   public void updateCurr() {
       try {
        int curr = 0;

        ResultSet rs = stmt.executeQuery("SELECT curr FROM quantquest");

        while(rs.next())
            curr = rs.getInt("curr");

        rs.close();
        curr++;

        stmt.executeUpdate("UPDATE QuantQuest SET curr=" + curr);
   
       } catch (Exception e) {
           System.err.println("Erro no curr");
       }
   }
   
}
