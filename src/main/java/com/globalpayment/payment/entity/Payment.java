package com.globalpayment.payment.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_payment")
@Setter
@Getter
@ToString
public class Payment {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

    @NotNull(message = "Amount Cannot be empty")
    @Min(value=1, message = "Amount Cannot be less than 1")
	private double amount;
	
    @NotEmpty(message = "Payment Method Cannot be empty")
	private String method;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
}
