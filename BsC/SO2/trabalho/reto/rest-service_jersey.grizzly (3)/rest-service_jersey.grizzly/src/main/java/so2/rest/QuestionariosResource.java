package so2.rest;

import com.sun.jersey.spi.resource.Singleton;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Singleton
@Path(value = "/questionarios")
public class QuestionariosResource {

    private ArrayList<Questionarios> questList;
    BaseDeDados bDados;

    /**
     * This class is annotated with @Singleton meaning that only
     * one instance of this class will be instantated per web
     * application. 
     */
    public QuestionariosResource() {
        bDados = new BaseDeDados("alunos.di.uevora.pt", "l29329", "l29329", "12345");
        questList = bDados.getQuestList();
    }

    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized ListQuest getQuestList() {
        return new ListQuest(questList);
    }

    @PUT
    @Consumes({"application/json", "application/xml"})
    public synchronized void putQuestList(Questionarios cenas, @QueryParam("responderOuNao") int responderOuNao) {
        //adiciona
        if(responderOuNao == 0){
            int numQuest = bDados.getActual();
            cenas.setNumQUest(numQuest);
            questList.add(cenas);
            bDados.putQuest(cenas);
            bDados.actActual();
        }
        // responde
        else if(responderOuNao == 1){
            for(int i = 0; i < questList.size(); i++){
                if(questList.get(i).getNumQuest() == cenas.getNumQuest()){
                    questList.set(i, cenas);
                    bDados.updateQuest(cenas);
                    break;
                }
            }
            bDados.updateQuest(cenas);
        }
        else{
            System.out.println("Accao desconhecida...");
        }
    }

    @DELETE
    @Produces({"application/json", "application/xml"})
    public synchronized void deleteQuestList(@QueryParam("index") int index) {
        int cenas = questList.get(index).getNumQuest();
        questList.remove(index);
        bDados.deleteQuest(cenas);
    }
}