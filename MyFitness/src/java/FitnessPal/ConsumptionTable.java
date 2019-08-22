/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author beck
 */
@Entity
@Table(name = "CONSUMPTION_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumptionTable.findAll", query = "SELECT c FROM ConsumptionTable c")
    , @NamedQuery(name = "ConsumptionTable.findByConsumptionDate", query = "SELECT c FROM ConsumptionTable c WHERE c.consumptionTablePK.consumptionDate = :consumptionDate")
    , @NamedQuery(name = "ConsumptionTable.findByServings", query = "SELECT c FROM ConsumptionTable c WHERE c.servings = :servings")
    , @NamedQuery(name = "ConsumptionTable.findByUserId", query = "SELECT c FROM ConsumptionTable c WHERE c.consumptionTablePK.userId = :userId")})
public class ConsumptionTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsumptionTablePK consumptionTablePK;
    @Column(name = "SERVINGS")
    private Integer servings;
    @JoinColumn(name = "FOOD_ID", referencedColumnName = "FOOD_ID")
    @ManyToOne
    private FoodTable foodId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTable userTable;

    public ConsumptionTable() {
    }

    public ConsumptionTable(ConsumptionTablePK consumptionTablePK) {
        this.consumptionTablePK = consumptionTablePK;
    }

    public ConsumptionTable(Date consumptionDate, int userId) {
        this.consumptionTablePK = new ConsumptionTablePK(consumptionDate, userId);
    }

    public ConsumptionTablePK getConsumptionTablePK() {
        return consumptionTablePK;
    }

    public void setConsumptionTablePK(ConsumptionTablePK consumptionTablePK) {
        this.consumptionTablePK = consumptionTablePK;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public FoodTable getFoodId() {
        return foodId;
    }

    public void setFoodId(FoodTable foodId) {
        this.foodId = foodId;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public void setUserTable(UserTable userTable) {
        this.userTable = userTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumptionTablePK != null ? consumptionTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumptionTable)) {
            return false;
        }
        ConsumptionTable other = (ConsumptionTable) object;
        if ((this.consumptionTablePK == null && other.consumptionTablePK != null) || (this.consumptionTablePK != null && !this.consumptionTablePK.equals(other.consumptionTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.ConsumptionTable[ consumptionTablePK=" + consumptionTablePK + " ]";
    }
    
}
