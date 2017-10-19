package so2.rest;

import java.util.List;
import so2.rest.*;

public class mainCenas {
    public static void main(String[] args) {
        
       NewJerseyClient client = new NewJerseyClient();
       
       
       /*
       QuestImpl q = new QuestImpl("Bananas");
       q.addPergunta("Ainda mais cenas");
       q.addPergunta("Ainda mais coisas");
       q.addPergunta("Ainda mais bananas");
       
       client.addQuest_JSON(q);
       */
       
       ListaQuest l = new ListaQuest();
       l = client.getQuestList_JSON(l.getClass());
       
       List<QuestImpl> lq = l.getLista();
       
       for(QuestImpl q : lq)
            System.out.println(q.getNome());
       
       
       
       /*
       ListaQuest l = new ListaQuest();
       
       l = client.getQuestList_JSON(l.getClass());
       
       for(QuestImpl q2 : l.getLista()) {
           System.out.println(q2.getNome());
           for(PergQuest p : q2.getPerg())
               System.out.println(" -" + p.getNome());
       }
       
       client.removeQuest("1");
       */
       client.close();
    }
}
