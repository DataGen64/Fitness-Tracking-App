/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal.service;

import FitnessPal.CredentialTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author beck
 */
@Stateless
@Path("fitnesspal.credentialtable")
public class CredentialTableFacadeREST extends AbstractFacade<CredentialTable> {

    @PersistenceContext(unitName = "MyFitnessPU")
    private EntityManager em;

    public CredentialTableFacadeREST() {
        super(CredentialTable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CredentialTable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, CredentialTable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CredentialTable find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CredentialTable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CredentialTable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
//    @GET
//    @Path("findByUsername/{username}")
//    @Produces({"application/json"})
//    public List<CredentialTable> findByUsername(@PathParam("username") String username)
//    {
//        Query query = em.createNamedQuery("CredentialTable.findByUsername");
//        query.setParameter("username", username);
//        return query.getResultList();
//    }
    
    @GET
    @Path("findByUsername/{username}/{password}")
    @Produces({"application/json"})
    public String findByUsername(@PathParam("username") String username, @PathParam("password") String password)
    {
        Query query = em.createNamedQuery("CredentialTable.findByUsername");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<CredentialTable> list = query.getResultList();
        //CredentialTable c = new CredentialTable();
       if (list.toString() != "[]")
        return list.get(0).getUserId().getFname() ; 
       else 
        return "";
    }
    
    @GET
    @Path("findUserValid/{username}")
    @Produces({"application/json"})
    public String findByUserName(@PathParam("username") String username)
    {
        Query query = em.createNamedQuery("CredentialTable.findUserValid");
        query.setParameter("username", username);
        List<CredentialTable> list = query.getResultList();
        //CredentialTable c = new CredentialTable();
       if (list.toString() != "[]")
        return list.get(0).getUserId().getFname() ; 
       else 
        return "";
    }
    
    @GET
    @Path("findBySignupDate/{signupDate}")
    @Produces({"application/json"})
    public List<CredentialTable> findBySignupDate(@PathParam("signupDate") String signupDate) throws ParseException
    {
        Query query = em.createNamedQuery("CredentialTable.findBySignupDate");
        List list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("signupDate", (sdf.parse(signupDate)));
        list.addAll(query.getResultList());
        return query.getResultList();
    }
    
    @GET
    @Path("findByPassword/{password}")
    @Produces({"application/json"})
    public List<CredentialTable> findByPassword(@PathParam("password") String password)
    {
        Query query = em.createNamedQuery("CredentialTable.findByPassword");
        query.setParameter("password", password);
        return query.getResultList();
    }
    
}
