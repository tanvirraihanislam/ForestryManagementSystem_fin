package com.cg.fms.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedulerDetails")
public class Scheduler {
	
	@Id
	@Column(name="schedulerId")
	private String schedulerId;
	
	@Column(name="schedulerName")
	private String schedulerName;
	
	@Column(name="schedulerContact")
	private String schedulerContact;

	@Column(name="truckNumber")
	private String truckNumber;
	
	@OneToOne(mappedBy="scheduler")
	private Order orders;
	
	@OneToMany(mappedBy = "scheduler")
	private Set<Customer> customers;

	public Scheduler() {
		super();
	}

	public Scheduler(String schedulerId, String schedulerName, String schedulerContact, String truckNumber) {
		super();
		this.schedulerId = schedulerId;
		this.schedulerName = schedulerName;
		this.schedulerContact = schedulerContact;
		this.truckNumber = truckNumber;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getSchedulerContact() {
		return schedulerContact;
	}

	public void setSchedulerContact(String schedulerContact) {
		this.schedulerContact = schedulerContact;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Scheduler [schedulerId=" + schedulerId + ", schedulerName=" + schedulerName + ", schedulerContact="
				+ schedulerContact + ", truckNumber=" + truckNumber + ", orders=" + orders + ", customers=" + customers
				+ "]";
	}

	
	

	
	
}
