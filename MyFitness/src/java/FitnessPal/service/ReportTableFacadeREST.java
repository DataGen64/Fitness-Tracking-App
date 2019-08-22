/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal.service;

import FitnessPal.ReportTable;
import FitnessPal.ReportTablePK;
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
@Path("fitnesspal.reporttable")
public class ReportTableFacadeREST extends AbstractFacade<ReportTable> {

    @PersistenceContext(unitName = "MyFitnessPU")
    private EntityManager em;

    private ReportTablePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;userId=userIdValue;date=dateValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        FitnessPal.ReportTablePK key = new FitnessPal.ReportTablePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> userId = map.get("userId");
        if (userId != null && !userId.isEmpty()) {
            key.setUserId(new java.lang.Integer(userId.get(0)));
        }
        java.util.List<String> date = map.get("date");
        if (date != null && !date.isEmpty()) {
            key.setDate(new java.util.Date(date.get(0)));
        }
        return key;
    }

    public ReportTableFacadeREST() {
        super(ReportTable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ReportTable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ReportTable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        FitnessPal.ReportTablePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReportTable find(@PathParam("id") PathSegment id) {
        FitnessPal.ReportTablePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findByDate(@PathParam("date") String date) throws ParseException
    {
        Query query = em.createNamedQuery("ReportTable.findByDate");
         List list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("date", (sdf.parse(date)));
        list.addAll(query.getResultList());
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalCalories/{totalCalories}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findByTotalCalories(@PathParam("totalCalories") Integer totalCalories)
    {
        Query query = em.createNamedQuery("ReportTable.findByTotalCalories");
        query.setParameter("totalCalories", totalCalories);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalCaloriesBurnt/{totalCaloriesBurnt}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findByTotalCaloriesBurnt(@PathParam("totalCaloriesBurnt") Integer totalCaloriesBurnt)
    {
        Query query = em.createNamedQuery("ReportTable.findByTotalCaloriesBurnt");
        query.setParameter("totalCaloriesBurnt", totalCaloriesBurnt);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalStepsTaken/{totalStepsTaken}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findByTotalStepsTaken(@PathParam("totalStepsTaken") Integer totalStepsTaken)
    {
        Query query = em.createNamedQuery("ReportTable.findByTotalStepsTaken");
        query.setParameter("totalStepsTaken", totalStepsTaken);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDayGoal/{dayGoal}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ReportTable> findByDayGoal(@PathParam("dayGoal") Integer dayGoal)
    {
        Query query = em.createNamedQuery("ReportTable.findByDayGoal");
        query.setParameter("dayGoal", dayGoal);
        return query.getResultList();
    }
    
}
