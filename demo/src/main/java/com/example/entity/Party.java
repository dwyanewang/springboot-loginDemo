package com.example.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_PARTY", schema = "APP")
public class Party {
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "SUBJECT", length = 50)
    private String subject;
    
    @Column(name="START_DATE") 
    private Date startDate;
    
    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "LONGITUDE", length = 100)
    private String longitude;
    
    @Column(name = "LATITUDE", length = 100)
    private String latitude;
    
    @Column(name = "INITATION", length = 100)
    private String initation;

/*    @OneToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(schema = "APP", name = "T_PARTY_ITEM", 
    joinColumns = { @JoinColumn(name = "PARTY_ID", referencedColumnName = "id", foreignKey = @ForeignKey(value= ConstraintMode.NO_CONSTRAINT))}
    //    inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName="id")}
    )*/
    
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="party")
    private Set<PartyItem> partyItems = new HashSet<PartyItem>();
    
    @Column(name = "REMARK", length = 50)
    private String reMark;
    
    @Column(name = "DETETEFLAG", length = 50)
    private String deleteFlag;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInitation() {
		return initation;
	}

	public void setInitation(String initation) {
		this.initation = initation;
	}

	public Set<PartyItem> getPartyItems() {
		return partyItems;
	}

	public void setPartyItems(Set<PartyItem> partyItems) {
		this.partyItems = partyItems;
	}

	public String getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark = reMark;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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
    
}
