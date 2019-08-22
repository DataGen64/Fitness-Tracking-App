/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal.service;

import FitnessPal.UserTable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@Path("fitnesspal.usertable")
public class UserTableFacadeREST extends AbstractFacade<UserTable> {

    @PersistenceContext(unitName = "MyFitnessPU")
    private EntityManager em;

    public UserTableFacadeREST() {
        super(UserTable.class);
    }

    @POST
    @Override
    @Produces({"application/json"})
    public void create(UserTable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Produces({"application/json"})
    public void edit(@PathParam("id") Integer id, UserTable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public UserTable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<UserTable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<UserTable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces({"application/json"})
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     @GET
    @Path("findByFname/{fname}")
    @Produces({"application/json"})
    public List<UserTable> findByFname(@PathParam("fname") String fname)
    {
        Query query = em.createNamedQuery("UserTable.findByFname");
        query.setParameter("fname", fname);
        return query.getResultList();
    }

    @GET
    @Path("findByLname/{lname}")
    @Produces({"application/json"})
    public List<UserTable> findByLname(@PathParam("lname") String lname)
    {
        Query query = em.createNamedQuery("UserTable.findByLname");
        query.setParameter("lname", lname);
        return query.getResultList();
    }    

    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<UserTable> findByEmail(@PathParam("email") String email)
    {
        Query query = em.createNamedQuery("UserTable.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }  
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<UserTable> findByDob(@PathParam("dob") String dob) throws ParseException
    {
        Query query = em.createNamedQuery("UserTable.findByDob");
        List list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("dob", (sdf.parse(dob)));
        list.addAll(query.getResultList());
        return query.getResultList();
    } 

    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<UserTable> findByHeight(@PathParam("height") Double height)
    {
        Query query = em.createNamedQuery("UserTable.findByHeight");
        query.setParameter("height", height);
        return query.getResultList();
    }  
    
    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<UserTable> findByWeight(@PathParam("weight") Double weight)
    {
        Query query = em.createNamedQuery("UserTable.findByWeight");
        query.setParameter("weight", weight);
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<UserTable> findByGender(@PathParam("gender") String gender)
    {
        Query query = em.createNamedQuery("UserTable.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    } 
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<UserTable> findByAddress(@PathParam("address") String address)
    {
        Query query = em.createNamedQuery("UserTable.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }   
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<UserTable> findByPostcode(@PathParam("postcode") String postcode)
    {
        Query query = em.createNamedQuery("UserTable.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }  
    
    
    @GET
    @Path("findByActivityLevel/{activityLevel}")
    @Produces({"application/json"})
    public List<UserTable> findByActivityLevel(@PathParam("activityLevel") Integer activityLevel)
    {
        Query query = em.createNamedQuery("UserTable.findByActivityLevel");
        query.setParameter("activityLevel", activityLevel);
        return query.getResultList();
    }   
    
    @GET
    @Path("findByStepsPerMile/{stepsPerMile}")
    @Produces({"application/json"})
    public List<UserTable> findByStepsPerMile(@PathParam("stepsPerMile") Integer stepsPerMile)
    {
        Query query = em.createNamedQuery("UserTable.findByStepsPerMile");
        query.setParameter("stepsPerMile", stepsPerMile);
        return query.getResultList();
    }

     // 3C - Dynamic query with implicit join
    @GET
    @Path("find_username_with_Fname/{fname}")
    @Produces({"application/json"})
    public String find_username_with_Fname(@PathParam("fname") String fname)
    {
        TypedQuery <String> q = em.createQuery("SELECT s.username FROM CredentialTable s WHERE s.userId.fname = :fname", String.class);
        q.setParameter("fname", fname);
        String x = q.getSingleResult();
        return x;
    }
    
    // 3d - Static Query with Implicit join
    @GET
    @Path("find_password_with_lname/{lname}")
    @Produces({"application/json"})
    public String find_SignupDate_with_lname(@PathParam("lname") String lname)
    {
        Query query = em.createNamedQuery("UserTable.find_password_with_lname");
        query.setParameter("lname", lname);
        String x = (String) query.getSingleResult();
        return x;
    }
    
    //4A
    @GET
    @Path("getCalBurned/{userid}")
    @Produces({"application/json"})
    public BigDecimal getCalBurned(@PathParam("userid") Integer userid)
    {
            TypedQuery<BigDecimal> query1 = em.createQuery("SELECT u.stepsPerMile FROM UserTable u WHERE u.userid"
            + "= :userid", BigDecimal.class);
            query1.setParameter("userid", userid);
            TypedQuery<BigDecimal> query2 = em.createQuery("SELECT u.weight FROM UserTable u WHERE u.userid"
            + "= :userid", BigDecimal.class);
            query2.setParameter("userid", userid);
            
    BigDecimal x = query1.getSingleResult();
    BigDecimal y = query2.getSingleResult();
    BigDecimal n1 = new BigDecimal("0.49");
    //Double q1 = new Double(x);
    //BigDecimal n2 = new BigDecimal(q1);
               
    BigDecimal result = y.multiply(n1).divide(x); 
    return result;
    }
    
    
}
