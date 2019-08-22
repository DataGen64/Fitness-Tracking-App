/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author beck
 */
@Entity
@Table(name = "FOOD_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodTable.findAll", query = "SELECT f FROM FoodTable f")
    , @NamedQuery(name = "FoodTable.findByFoodId", query = "SELECT f FROM FoodTable f WHERE f.foodId = :foodId")
    , @NamedQuery(name = "FoodTable.findByFoodCatogory", query = "SELECT f FROM FoodTable f WHERE f.foodCatogory = :foodCatogory")
    , @NamedQuery(name = "FoodTable.findByFoodCalorie", query = "SELECT f FROM FoodTable f WHERE f.foodCalorie = :foodCalorie")
    , @NamedQuery(name = "FoodTable.findByServingUnit", query = "SELECT f FROM FoodTable f WHERE f.servingUnit = :servingUnit")
    , @NamedQuery(name = "FoodTable.findByFat", query = "SELECT f FROM FoodTable f WHERE f.fat = :fat")
    , @NamedQuery(name = "FoodTable.findByFoodName", query = "SELECT f FROM FoodTable f WHERE f.foodName = :foodName")
    , @NamedQuery(name = "FoodTable.findByServingAmount", query = "SELECT f FROM FoodTable f WHERE f.servingAmount = :servingAmount")})
public class FoodTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOOD_ID")
    private Integer foodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FOOD_CATOGORY")
    private String foodCatogory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOOD_CALORIE")
    private int foodCalorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SERVING_UNIT")
    private String servingUnit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAT")
    private int fat;
    @Size(max = 100)
    @Column(name = "FOOD_NAME")
    private String foodName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVING_AMOUNT")
    private BigDecimal servingAmount;
    @OneToMany(mappedBy = "foodId")
    private Collection<ConsumptionTable> consumptionTableCollection;

    public FoodTable() {
    }

    public FoodTable(Integer foodId) {
        this.foodId = foodId;
    }

    public FoodTable(Integer foodId, String foodCatogory, int foodCalorie, String servingUnit, int fat, BigDecimal servingAmount) {
        this.foodId = foodId;
        this.foodCatogory = foodCatogory;
        this.foodCalorie = foodCalorie;
        this.servingUnit = servingUnit;
        this.fat = fat;
        this.servingAmount = servingAmount;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodCatogory() {
        return foodCatogory;
    }

    public void setFoodCatogory(String foodCatogory) {
        this.foodCatogory = foodCatogory;
    }

    public int getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(int foodCalorie) {
        this.foodCalorie = foodCalorie;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(BigDecimal servingAmount) {
        this.servingAmount = servingAmount;
    }

    @XmlTransient
    public Collection<ConsumptionTable> getConsumptionTableCollection() {
        return consumptionTableCollection;
    }

    public void setConsumptionTableCollection(Collection<ConsumptionTable> consumptionTableCollection) {
        this.consumptionTableCollection = consumptionTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodTable)) {
            return false;
        }
        FoodTable other = (FoodTable) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.FoodTable[ foodId=" + foodId + " ]";
    }
    
}
