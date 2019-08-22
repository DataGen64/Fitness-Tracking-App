/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal.service;

import FitnessPal.ConsumptionTable;
import FitnessPal.ConsumptionTablePK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author beck
 */
@Stateless
@Path("fitnesspal.consumptiontable")
public class ConsumptionTableFacadeREST extends AbstractFacade<ConsumptionTable> {

    @PersistenceContext(unitName = "MyFitnessPU")
    private EntityManager em;

    private ConsumptionTablePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;consumptionDate=consumptionDateValue;userId=userIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        FitnessPal.ConsumptionTablePK key = new FitnessPal.ConsumptionTablePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> consumptionDate = map.get("consumptionDate");
        if (consumptionDate != null && !consumptionDate.isEmpty()) {
            key.setConsumptionDate(new java.util.Date(consumptionDate.get(0)));
        }
        java.util.List<String> userId = map.get("userId");
        if (userId != null && !userId.isEmpty()) {
            key.setUserId(new java.lang.Integer(userId.get(0)));
        }
        return key;
    }

    public ConsumptionTableFacadeREST() {
        super(ConsumptionTable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ConsumptionTable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ConsumptionTable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        FitnessPal.ConsumptionTablePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ConsumptionTable find(@PathParam("id") PathSegment id) {
        FitnessPal.ConsumptionTablePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ConsumptionTable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ConsumptionTable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @GET
    @Path("findByConsumptionDate/{consumptionDate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ConsumptionTable> findByConsumptionDate(@PathParam("consumptionDate") String consumptionDate) throws ParseException
    {
        Query query = em.createNamedQuery("ConsumptionTable.findByConsumptionDate");
        List list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("consumptionDate", (sdf.parse(consumptionDate)));
        list.addAll(query.getResultList());
        return query.getResultList();
    }
    
    @GET
    @Path("findByServings/{servings}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ConsumptionTable> findByServings(@PathParam("servings") Integer servings)
    {
        Query query = em.createNamedQuery("ConsumptionTable.findByServings");
        query.setParameter("servings", servings);
        return query.getResultList();
    } 
    
}
