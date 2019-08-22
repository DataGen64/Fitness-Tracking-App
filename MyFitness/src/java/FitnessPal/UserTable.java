/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessPal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author beck
 */
@Entity
@Table(name = "USER_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u")
    , @NamedQuery(name = "UserTable.findByUserid", query = "SELECT u FROM UserTable u WHERE u.userid = :userid")
    , @NamedQuery(name = "UserTable.findByFname", query = "SELECT u FROM UserTable u WHERE u.fname = :fname")
    , @NamedQuery(name = "UserTable.findByLname", query = "SELECT u FROM UserTable u WHERE u.lname = :lname")
    , @NamedQuery(name = "UserTable.findByEmail", query = "SELECT u FROM UserTable u WHERE u.email = :email")
    , @NamedQuery(name = "UserTable.findByHeight", query = "SELECT u FROM UserTable u WHERE u.height = :height")
    , @NamedQuery(name = "UserTable.findByWeight", query = "SELECT u FROM UserTable u WHERE u.weight = :weight")
    , @NamedQuery(name = "UserTable.findByAddress", query = "SELECT u FROM UserTable u WHERE u.address = :address")
    , @NamedQuery(name = "UserTable.findByPostcode", query = "SELECT u FROM UserTable u WHERE u.postcode = :postcode")
    , @NamedQuery(name = "UserTable.findByActivityLevel", query = "SELECT u FROM UserTable u WHERE u.activityLevel = :activityLevel")
    , @NamedQuery(name = "UserTable.findByStepsPerMile", query = "SELECT u FROM UserTable u WHERE u.stepsPerMile = :stepsPerMile")
    , @NamedQuery(name = "UserTable.findByGender", query = "SELECT u FROM UserTable u WHERE u.gender = :gender")
    , @NamedQuery(name = "UserTable.findByDob", query = "SELECT u FROM UserTable u WHERE u.dob = :dob")
    ,@NamedQuery(name = "UserTable.find_password_with_lname", query = "SELECT s.password FROM CredentialTable s WHERE s.userId.lname = :lname")})
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LNAME")
    private String lname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEIGHT")
    private int height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT")
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "POSTCODE")
    private String postcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_LEVEL")
    private int activityLevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPS_PER_MILE")
    private int stepsPerMile;
    @Size(max = 5)
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTable")
    private Collection<ReportTable> reportTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<CredentialTable> credentialTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTable")
    private Collection<ConsumptionTable> consumptionTableCollection;

    public UserTable() {
    }

    public UserTable(Integer userid) {
        this.userid = userid;
    }

    public UserTable(Integer userid, String fname, String lname, String email, int height, int weight, String address, String postcode, int activityLevel, int stepsPerMile, Date date, String gender) {
        this.userid = userid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.postcode = postcode;
        this.activityLevel = activityLevel;
        this.stepsPerMile = stepsPerMile;
        this.dob = date;
        this.gender = gender;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getStepsPerMile() {
        return stepsPerMile;
    }

    public void setStepsPerMile(int stepsPerMile) {
        this.stepsPerMile = stepsPerMile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<ReportTable> getReportTableCollection() {
        return reportTableCollection;
    }

    public void setReportTableCollection(Collection<ReportTable> reportTableCollection) {
        this.reportTableCollection = reportTableCollection;
    }

    @XmlTransient
    public Collection<CredentialTable> getCredentialTableCollection() {
        return credentialTableCollection;
    }

    public void setCredentialTableCollection(Collection<CredentialTable> credentialTableCollection) {
        this.credentialTableCollection = credentialTableCollection;
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
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTable)) {
            return false;
        }
        UserTable other = (UserTable) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.UserTable[ userid=" + userid + " ]";
    }
    
}
