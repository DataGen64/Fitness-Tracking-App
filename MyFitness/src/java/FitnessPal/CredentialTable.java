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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author beck
 */
@Entity
@Table(name = "CREDENTIAL_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CredentialTable.findAll", query = "SELECT c FROM CredentialTable c")
    , @NamedQuery(name = "CredentialTable.findByUsername", query = "SELECT c FROM CredentialTable c WHERE c.username = :username AND c.password = :password")
    , @NamedQuery(name = "CredentialTable.findUserValid", query = "SELECT c FROM CredentialTable c WHERE c.username = :username")
    , @NamedQuery(name = "CredentialTable.findByPassword", query = "SELECT c FROM CredentialTable c WHERE c.password = :password")
    , @NamedQuery(name = "CredentialTable.findBySignupDate", query = "SELECT c FROM CredentialTable c WHERE c.signupDate = :signupDate")})
public class CredentialTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.DATE)
    private Date signupDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private UserTable userId;

    public CredentialTable() {
    }

    public CredentialTable(String username) {
        this.username = username;
    }

    public CredentialTable(String username, String password, Date singUpDate, UserTable user) {
        this.username = username;
        this.password = password;
        this.signupDate = singUpDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public UserTable getUserId() {
        return userId;
    }

    public void setUserId(UserTable userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredentialTable)) {
            return false;
        }
        CredentialTable other = (CredentialTable) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FitnessPal.CredentialTable[ username=" + username + " ]";
    }
    
}
