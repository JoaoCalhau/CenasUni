package so2.rest;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Singleton
@Path(value = "/turma")
public class TurmaResource {

    private Turma turma;

    /**
     * This class is annotated with @Singleton meaning that only
     * one instance of this class will be instantated per web
     * application. 
     */
    public TurmaResource() {
        turma = new Turma();   // alguns dados para testes
        turma.add(new Aluno(200,"Maria"));
        turma.add(new Aluno(201,"Manuel"));
    }

    @GET
    @Produces({"application/json", "application/xml"})
    public synchronized Turma getTurma() {
        return turma;
    }

    /* Sem a anotacao @Path, a escolha entre este metodo e o anterior faz-se pelo HTTP Method (GET/PUT)
    */
    @PUT
    @Consumes({"application/json", "application/xml"})
    public synchronized void putTurma(Turma turma) {
        this.turma = turma;
    }

    /*
	Este método é invocado se o AppServer receber um Http POST com o sufixo /add, apos o URI base deste resource.
    */
    @Path("/add")
    @POST
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public synchronized Turma addAluno(@QueryParam("numero") int numero,
				       @QueryParam("nome") String nome
					) {
        turma.add(new Aluno(numero,nome));
	return turma;
    }


}

