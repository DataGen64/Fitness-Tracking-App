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
@Table(name = "REPORT_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportTable.findAll", query = "SELECT r FROM ReportTable r")
    , @NamedQuery(name = "ReportTable.findByTotalCalories", query = "SELECT r FROM ReportTable r WHERE r.totalCalories = :totalCalories")
    , @NamedQuery(name = "ReportTable.findByTotalCaloriesBurnt", query = "SELECT r FROM ReportTable r WHERE r.totalCaloriesBurnt = :totalCaloriesBurnt")
    , @NamedQuery(name = "ReportTable.findByTotalStepsTaken", query = "SELECT r FROM ReportTable r WHERE r.totalStepsTaken = :totalStepsTaken")
    , @NamedQuery(name = "ReportTable.findByDayGoal", query = "SELECT r FROM ReportTable r WHERE r.dayGoal = :dayGoal")
    , @NamedQuery(name = "ReportTable.findByUserId", query = "SELECT r FROM ReportTable r WHERE r.reportTablePK.userId = :userId")
    , @NamedQuery(name = "ReportTable.findByDate", query = "SELECT r FROM ReportTable r WHERE r.reportTablePK.date = :date")})
public class ReportTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportTablePK reportTablePK;
    @Column(name = "TOTAL_CALORIES")
    private Integer totalCalories;
    @Column(name = "TOTAL_CALORIES_BURNT")
    private Integer totalCaloriesBurnt;
    @Column(name = "TOTAL_STEPS_TAKEN")
    private Integer totalStepsTaken;
    @Column(name = "DAY_GOAL")
    private Integer dayGoal;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTable userTable;

    public ReportTable() {
    }

    public ReportTable(ReportTablePK reportTablePK) {
        this.reportTablePK = reportTablePK;
    }

    public ReportTable(int userId, Date date) {
        this.reportTablePK = new ReportTablePK(userId, date);
    }

    public ReportTablePK getReportTablePK() {
        return reportTablePK;
    }

    public void setReportTablePK(ReportTablePK reportTablePK) {
        this.reportTablePK = reportTablePK;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Integer getTotalCaloriesBurnt() {
        return totalCaloriesBurnt;
    }

    public void setTotalCaloriesBurnt(Integer totalCaloriesBurnt) {
        this.totalCaloriesBurnt = totalCaloriesBurnt;
    }

    public Integer getTotalStepsTaken() {
        return totalStepsTaken;
    }

    public void setTotalStepsTaken(Integer totalStepsTaken) {
        this.totalStepsTaken = totalStepsTaken;
    }

    public Integer getDayGoal() {
        return dayGoal;
    }

    public void setDayGoal(Integer dayGoal) {
        this.dayGoal = dayGoal;
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
        hash += (reportTablePK != null ? reportTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportTable)) {
            return false;
        }
        ReportTable other = (ReportTable) object;
        if ((this.reportTablePK == null && other.reportTablePK != null) || (this.reportTablePK != null && !this.reportTablePK.equals(other.reportTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.ReportTable[ reportTablePK=" + reportTablePK + " ]";
    }
    
}
