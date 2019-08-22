/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author beck
 */
@Embeddable
public class ConsumptionTablePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSUMPTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date consumptionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;

    public ConsumptionTablePK() {
    }

    public ConsumptionTablePK(Date consumptionDate, int userId) {
        this.consumptionDate = consumptionDate;
        this.userId = userId;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumptionDate != null ? consumptionDate.hashCode() : 0);
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumptionTablePK)) {
            return false;
        }
        ConsumptionTablePK other = (ConsumptionTablePK) object;
        if ((this.consumptionDate == null && other.consumptionDate != null) || (this.consumptionDate != null && !this.consumptionDate.equals(other.consumptionDate))) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.ConsumptionTablePK[ consumptionDate=" + consumptionDate + ", userId=" + userId + " ]";
    }
    
}
