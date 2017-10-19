package so2.rest;

import com.sun.jersey.spi.resource.Singleton;


import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.*;
import javax.ws.rs.PUT;


@Singleton
@Path(value = "/quest")
public class QuestResource {
    
   private final QuestBd bd;
   
    public QuestResource() {
        bd = new QuestBd("alunos.di.uevora.pt", "l31621", "l31621", "12345");
    }
   
    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized ListaQuest getQuestList() {
        List<QuestImpl> list = bd.getQuestList();
        ListaQuest l = new ListaQuest(list);
        System.out.println("GET");
        return l;
    }
    
    
    @PUT
    @Consumes({"application/xml"})
    public synchronized void addQuest( QuestImpl q ) {
        List<QuestImpl> list = bd.getQuestList();
        for(QuestImpl qs : list) {
            if(qs.getNome().equals(q.getNome())) {
                System.out.println("Unccessfull PUT... Element already exists in DB");
                return;
            }
        }
        int numQ = bd.getCurr();
        q.setNumQ(numQ);
        bd.addQuest(q);
        bd.updateCurr();
        System.out.println("PUT");
    }
    
    @PUT
    @Consumes({"application/json"})
    public synchronized void updateAnswer( QuestImpl q) {
        List<QuestImpl> list = bd.getQuestList();
        if(list.isEmpty()) {
            System.out.println("PUT Unsucessfull... Nothing to answer...");
        } else {
            int index = 0;
            for(QuestImpl qs : list) {
                if(qs.getNome().equals(q.getNome()))
                    break;
                index++;
            }
            list.set(index, q);
            bd.answerQuest(q);
            System.out.println("PUT");
        }
    }
   
    @DELETE
    @Produces({"application/json", "application/xml"})
    @Consumes({"application/json", "application/xml"})
    public synchronized void removeQuest( @QueryParam("index") int index ) {
        List<QuestImpl> list = bd.getQuestList();
        if(list.isEmpty()) {
            System.out.println("DELETE Unsuccessfull... Nothing to delete");
        } else {
            if(!(index > list.size()-1)) {
                QuestImpl q = list.remove(index);
                bd.removeQuest(q);
                System.out.println("DELETE");
            } else {
                System.out.println("DELETE Unsuccessfull... No such element");
            }
        }
    }
    
}
