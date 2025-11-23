package br.com.fiap;

import br.com.fiap.beans.Lead;
import br.com.fiap.bo.LeadBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.ArrayList;

@Path("/contato")
public class LeadResource {

    private LeadBO leadBO = new LeadBO();

    // GET - Listar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selecionarRs() {
        try {
            ArrayList<Lead> lista = leadBO.selecionarBo();
            return Response.ok(lista).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    // GET por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorIdRs(@PathParam("id") int id) {
        try {
            Lead lead = leadBO.buscarPorIdBo(id);
            if(lead == null) return Response.status(Response.Status.NOT_FOUND).build();
            return Response.ok(lead).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    // POST - Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Lead lead, @Context UriInfo uriInfo) {
        try {
            leadBO.inserirBo(lead);
            return Response.status(Response.Status.CREATED).entity("Mensagem enviada com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // PUT - Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Lead lead, @PathParam("id") int id) {
        try {
            lead.setId(id);
            leadBO.atualizarBo(lead);
            return Response.ok().entity("Contato atualizado!").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    // DELETE - Deletar
    @DELETE
    @Path("/{id}")
    public Response deletarRs(@PathParam("id") int id) {
        try {
            leadBO.deletarBo(id);
            return Response.ok().entity("Contato removido!").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
