package so2.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.glassfish.grizzly.http.server.HttpServer;




public class MainAppServerTest {


    private HttpServer httpServer;

    private WebResource r;

    @Before
    public void setUp() throws Exception {
        httpServer = MainAppServer.startServer();

        ClientConfig cc = new DefaultClientConfig();

        Client c = Client.create(cc);
        r = c.resource(MainAppServer.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {  // o que fazer no final
        httpServer.stop();             // desligar o servidor
    }



    // *******************************************
    // *******************************************
    // ZONA com os testes...
    // note a anotacao @Test e o assertXxx que tem a(s) validacao(oes) a observar em cada teste.

    /**
     * Test checks that the application.wadl is reachable.
     */
    @Test
    public void testApplicationWadl() {
        String applicationWadl = r.path("application.wadl").get(String.class);
        assertTrue("Something wrong. Returned wadl length is not > 0",
                applicationWadl.length() > 0);
    }


    /**
     * Test check GET on the "turma" resource in "application/json" format.
     */
    @Test
    public void testGetOnTurmaJSONFormat() {
        // get the initial representation
        Turma t = r.path("turma").
                accept("application/json").get(Turma.class);
        // testar a presenca de pelo menos 2 alunos
        assertEquals("O numero de alunos nao e' o esperado na turma!!!",
                2, t.size());
    }


    /**
     * Test checks GET on "turma" resource with mime-type "application/xml".
     */
    @Test
    public void testGetOnTurmaXMLFormat() {
        // get the initial representation
        Turma t = r.path("turma").
                accept("application/xml").get(Turma.class);
        // testar a presenca de pelo menos 2 alunos
        assertEquals("O numero de alunos nao e' o esperado na turma!!!",
                2, t.size());
    }

    /**
     * Testar a insercao de novo aluno...
     */
    @Test
    public void testPostToTurmaXMLFormat() {
        // get the initial representation
        Turma t = r.path("turma/add").
                queryParam("numero", "205").
                queryParam("nome", "Sofia").
                accept("application/xml").post(Turma.class);
        // testar a presenca de pelo menos 2 alunos
        assertEquals("O numero de alunos nao e' o esperado na turma!!!",
                3, t.size());
    }



    /**
     * Test checks PUT on "turma" resource with mime-type "application/xml".
     */
    @Test
    public void testPutOnFlightsXMLFormat() {
        Aluno a3= new Aluno(300,"Carla");
	Aluno a4= new Aluno(301,"Dinis");
	Turma t= new Turma();
	t.add(a3);
	t.add(a4);


        // substituir a turma por outra lista de alunos
        r.path("turma").type("application/XML").put(t);

        // testar a nova info...
	Turma t2 = r.path("turma").
                accept("application/xml").get(Turma.class);
        // testar a presenca de pelo menos 2 alunos
        assertEquals("O numero de alunos nao e' o esperado na turma!!!",
                2, t2.size());
        //check nome do primeiro
        assertEquals("Nome do primeiro aluno nao e' o esperado",
                true, t2.getAlunos().get(0).getNome().equals("Carla") );
	
	System.err.println(t2.getAlunos().get(1).getNome());
    }

}
