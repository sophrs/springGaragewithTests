package com.qa.soph.springGarage1App.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Vehicle")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)



public class MySpringGarage1Model implements Serializable{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		private String vehicleType;
		
		private String colour;
		private Integer price;
		private Integer yearofManufacture;
		private Boolean isBroken;
		
		@Column(nullable = false, updatable = false)
		//@Temporal(TemporalType.TIMESTAMP)
		@CreationTimestamp
		@CreatedDate
		private Date creationDate;
		
		@Column(nullable = false)
		//@Temporal(TemporalType.TIMESTAMP)
		@UpdateTimestamp
		@LastModifiedDate
		private Date lastModified;
		
		public MySpringGarage1Model() {
			
		}
		
		public MySpringGarage1Model(String vehicleType, int yearofManufacture, String colour) {
			this.vehicleType = vehicleType;
			this.yearofManufacture = yearofManufacture;
			this.colour = colour;
			
		}

	
	

		public void MySpringGarage1Model() {
		}
		
		
		public Long getId() {
			return id;
		}
		public Boolean getIsbroken() {
			return isBroken;
		}
		
		public void setIsbroken(Boolean isBroken) {
			this.isBroken = isBroken;
		}
	
		public String getColour() {
			return colour;
		}
		
		public void setColour(String colour) {
			this.colour = colour;
		}
		
		public Integer getPrice() {
			return price;
		}
		
		public void setPrice(Integer Price) {
			this.price = price;
		}
		
		public String getVehicleType() {
			return vehicleType;
		}
		
		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}
		
		public Integer getYearofManufacture() {
			return yearofManufacture;
		}
		
		public void setYearofManufacture(Integer yearofManufacture) {
			this.yearofManufacture = yearofManufacture;
		}
		
		public Date getCreationDate() {
			return creationDate;
		}
		
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		
		public Date getLastModified() {
			return lastModified;
		}
		public void setLastModified(Date lastModified) {
			this.lastModified = lastModified;
			
		}
}
