/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal.service;

import FitnessPal.FoodTable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
@Path("fitnesspal.foodtable")
public class FoodTableFacadeREST extends AbstractFacade<FoodTable> {

    @PersistenceContext(unitName = "MyFitnessPU")
    private EntityManager em;

    public FoodTableFacadeREST() {
        super(FoodTable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FoodTable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, FoodTable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FoodTable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByFoodId/{findByFoodId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findByFoodId(@PathParam("foodId") Integer foodId)
    {
        Query query = em.createNamedQuery("FoodTable.findByFoodId");
        query.setParameter("foodId", foodId);
        return query.getResultList();
    }

    @GET
    @Path("findByFoodCatogory/{foodCatogory}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<FoodTable> findByFoodCatogory(@PathParam("foodCatogory") String foodCatogory)
    {
        Query query = em.createNamedQuery("FoodTable.findByFoodCatogory");
        query.setParameter("foodCatogory", foodCatogory);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFoodCalorie/{foodCalorie}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findByFoodCalorie(@PathParam("foodCalorie") Integer foodCalorie)
    {
        Query query = em.createNamedQuery("FoodTable.findByFoodCalorie");
        query.setParameter("foodCalorie", foodCalorie);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFoodName/{foodName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findByFoodName(@PathParam("foodName") String foodName)
    {
        Query query = em.createNamedQuery("FoodTable.findByFoodName");
        query.setParameter("foodName", foodName);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFat/{fat}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findByFat(@PathParam("fat") Integer fat)
    {
        Query query = em.createNamedQuery("FoodTable.findByFat");
        query.setParameter("fat", fat);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingAmount/{servingAmount}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({"application/json"})
    public List<FoodTable> findByServingAmount(@PathParam("servingAmount") Double servingAmount)
    {
        Query query = em.createNamedQuery("FoodTable.findByServingAmount");
        query.setParameter("servingAmount", servingAmount);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingUnit/{servingUnit}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodTable> findByServingUnit(@PathParam("servingUnit") String servingUnit)
    {
        Query query = em.createNamedQuery("FoodTable.findByServingUnit");
        query.setParameter("servingUnit", servingUnit);
        return query.getResultList();
    }
    
        // 3B - 2 parameter Dynamic Query
    
    @GET
    @Path("findByServingSize_calorie/{servingAmount}/{servingUnit}") 
    @Produces({"application/json"})
    public List<FoodTable> findByServingSize_calorie(@PathParam("servingAmount") Double servingAmount, @PathParam("servingUnit") String servingUnit)  
    {
    TypedQuery<FoodTable> q = em.createQuery("SELECT f FROM FoodTable f WHERE f.servingUnit"
            + "= :servingUnit AND f.servingAmount = :servingAmount", FoodTable.class);
    q.setParameter("servingAmount", servingAmount);
    q.setParameter("servingUnit", servingUnit);
    return q.getResultList();
    }
    
}
