package com.freedomPass.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TBL_USER_COMPANY_INFO_LOCATIONS")
@XmlRootElement
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UserCompanyInfoLocations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GenericGenerator(name = "SEQ_GEN", strategy = "com.freedomPass.project.model.SequenceIdGenerator")
    @GeneratedValue(generator = "SEQ_GEN")
    private Long id;

    @Basic(optional = false)
    @Column(name = "LOCATION_INDEX")
    private Integer locationIndex;

    @Basic(optional = false)
    @Column(name = "longitude")
    @Size(max = 30, message = "validation.userInfo.infoRange")
    private String longitude;

    @Basic(optional = false)
    @Column(name = "latitude")
    @Size(max = 30, message = "validation.userInfo.infoRange")
    private String latitude;

    @JsonIgnore
    @JoinColumn(name = "USER_COMPANY_INFO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserCompanyInfo userCompanyInfo;

    public Integer getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(Integer locationIndex) {
        this.locationIndex = locationIndex;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCompanyInfo getUserCompanyInfo() {
        return userCompanyInfo;
    }

    public void setUserCompanyInfo(UserCompanyInfo userCompanyInfo) {
        this.userCompanyInfo = userCompanyInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCompanyInfoLocations)) {
            return false;
        }
        UserCompanyInfoLocations other = (UserCompanyInfoLocations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String userCompanyInfoString = "";
        if (Hibernate.isInitialized(userCompanyInfo)) {
            userCompanyInfoString = Objects.toString(userCompanyInfo);
        }
        return "\"com.freedomPass.project.model.UserProfile\" : {\"id\" : \"" + id + "\","
                + "\"latitude\" : \"" + latitude + "\","
                + "\"longitude\" : \"" + longitude + "\","
                + "\"userProfileId\" : " + userCompanyInfoString + "}";
    }
}
