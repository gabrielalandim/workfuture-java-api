package br.com.fiap;

import br.com.fiap.beans.Vaga;
import br.com.fiap.bo.VagaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/vaga")
public class VagaResource {
    private VagaBO vagaBO = new VagaBO();

    @GET
    @Produces({"application/json"})
    public ArrayList<Vaga> selecionarRs() throws ClassNotFoundException, SQLException {
        return this.vagaBO.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response buscarPorId(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        Vaga vaga = this.vagaBO.buscarPorIdBo(id);
        if(vaga == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(vaga).build();
    }

    @POST
    @Consumes({"application/json"})
    public Response inserirRs(Vaga vaga, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        this.vagaBO.inserirBo(vaga);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({"application/json"})
    public Response atualizarRs(Vaga vaga, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        vaga.setId(id);
        this.vagaBO.atualizarBo(vaga);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({"application/json"})
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        this.vagaBO.deletarBo(id);
        return Response.ok().build();
    }
}