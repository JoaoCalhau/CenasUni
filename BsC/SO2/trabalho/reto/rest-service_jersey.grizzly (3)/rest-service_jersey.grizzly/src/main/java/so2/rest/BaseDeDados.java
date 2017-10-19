/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2.rest;

import java.sql.*;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "basededados")
public class BaseDeDados {
    @XmlElement(required = true)
    Connection connection = null;
    @XmlElement(required = true)
    Statement statement = null;
    
    // ligar a base de dados
    public BaseDeDados(String host, String baseDeDados, String utilizador, String password){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":5432/"+baseDeDados,utilizador,password);
            statement = connection.createStatement();
            System.err.println("You are connected...");
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("BUMM...");
            e.printStackTrace();
        }
    }
    
    // retorna a lista de todos os questionarios existentes na base de dados assim como toda a sua informacao
    // GET
    public ArrayList<Questionarios> getQuestList(){
        try{
            ArrayList<Questionarios> listaQuestionarios = new ArrayList<>();
            Questionarios questionario;
            
            ResultSet rs = statement.executeQuery("SELECT numQuest,nomeQuest FROM Questionario");
            int numQuest = 0;
            String nomeQuest = "";
            
            while(rs.next()){
                numQuest = rs.getInt("numQuest");
                nomeQuest = rs.getString("nomeQuest");
                ArrayList<Pergunta> b = new ArrayList<>();
                questionario = new Questionarios(nomeQuest,b);
                questionario.setNumQUest(numQuest);
                listaQuestionarios.add(questionario);
            }
            rs.close();
            System.out.println("inseriu quest");
            
            int numPergunta = 0;
            String perg = "";
            int resposta = 0;
            int cont = 0;
            ArrayList<Pergunta> q = new ArrayList<>();
            for(int j = 0; j < listaQuestionarios.size(); j++){
                
                ResultSet rs1 = statement.executeQuery("SELECT numQuest, numPergunta, perg, resposta, cont FROM Pergunta ORDER BY numQuest, numPergunta");
                
                while(rs1.next()){
                    numQuest = rs1.getInt("numQuest");
                    numPergunta = rs1.getInt("numPergunta");
                    perg = rs1.getString("perg");
                    resposta = rs1.getInt("resposta");
                    cont = rs1.getInt("cont");
                    if(listaQuestionarios.get(j).getNumQuest() == numQuest){
                        Pergunta p = new Pergunta(perg);
                        p.setResposta(resposta);
                        p.setCount(cont);
                        q.add(p);
                    }
                }
                
                int k = 0;
                for(Questionarios cenas: listaQuestionarios){
                    if(cenas.getNumQuest() == listaQuestionarios.get(k).getNumQuest()){
                        cenas.setPergunta(q);
                    }
                    k++;
                }
            rs1.close();
            }
            System.out.println("get");
            System.out.println(listaQuestionarios.size());
            return listaQuestionarios;
            
        }
        catch (Exception e){
            System.err.println("BUM...GET didnt work...");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    // adicinar um novo questionario a base de dados
    // PUT
    public void putQuest(Questionarios cenas){
        try{
            String c = cenas.getNomeQuest();
            int num = cenas.getNumQuest();
            
            statement.executeUpdate("INSERT INTO Questionario VALUES(" + num + ",'" + c + "')");
            
            int nump = 1;
            for(Pergunta p: cenas.getPerguntas()){
                System.out.println(cenas.getPerguntas().size());
                statement.executeUpdate("INSERT INTO Pergunta VALUES(" + num + "," + nump + ",'" + p.getPerg() + "',0,0)");
                nump++;
            }
            
            System.out.println("put");
        }
        catch (Exception e){
            System.err.println("BUM...PUT didnt work...");
            e.printStackTrace();
        }
    }
    
    // apagar um certo questionario da base de dados
    //DELETE
    public void deleteQuest(int cenas){
        try{
            statement.executeUpdate("DELETE FROM Questionario WHERE numQuest=" + cenas);
            System.out.println("delete");
        }
        catch (Exception e){
            System.err.println("BUM...DELETE didnt work...");
            e.printStackTrace();
        }
    }
    
    // faz apdate a base de dados
    // UPDATE
    public void updateQuest(Questionarios q){
        try{
            for(int i = 0; i < q.getPerguntas().size(); i++){
                statement.executeUpdate("UPDATE Perguntas SET resposta=" + q.getPerguntas().get(i).getResposta() + ", cont = " + q.getPerguntas().get(i).getCount() + " WHERE numQuest = " + q.getNumQuest() + ", numPerg = " + i);
                }
            System.out.println("update");
        }
        catch (Exception e){
            System.err.println("BUM...UPDATE didnt work...");
            e.printStackTrace();
        }
    }
    
    public int getActual(){
        try{
            int contador = 0;
            
            ResultSet rs = statement.executeQuery("SELECT contador FROM Contador");
            
            while(rs.next()){
                contador = rs.getInt("contador");
            }
            rs.close();
            
            return contador;
        }catch (Exception e){
            System.err.println("BUM...Contador didnt work...");
            e.printStackTrace();
            return 0;
        }
    }
    
    public int actActual(){
        try{
            int contador = 0;
            
            ResultSet rs = statement.executeQuery("SELECT contador FROM Contador");
            
            while(rs.next()){
                contador = rs.getInt("contador");
            }
            rs.close();
            contador++;
            
            statement.executeUpdate("UPDATE Contador SET contador = " + contador);
            
            return contador;
        }catch (Exception e){
            System.err.println("BUM...Contador didnt act...");
            e.printStackTrace();
            return 0;
        }
    }
}
