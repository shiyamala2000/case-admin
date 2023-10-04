package com.kgisl.Nsurecasemanagement.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NsureCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String role;
	private String lAProposerName;
	private String documentName;
	private Date requestDate;
	private Date medicalAppointmentDate;
	private String status;
	private Date receivedDate;
	private String firstOrReTestIndicator;
    private String followUp;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getlAProposerName() {
		return lAProposerName;
	}
	public void setlAProposerName(String lAProposerName) {
		this.lAProposerName = lAProposerName;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getMedicalAppointmentDate() {
		return medicalAppointmentDate;
	}
	public void setMedicalAppointmentDate(Date medicalAppointmentDate) {
		this.medicalAppointmentDate = medicalAppointmentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getFirstOrReTestIndicator() {
		return firstOrReTestIndicator;
	}
	public void setFirstOrReTestIndicator(String firstOrReTestIndicator) {
		this.firstOrReTestIndicator = firstOrReTestIndicator;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	

    
}
