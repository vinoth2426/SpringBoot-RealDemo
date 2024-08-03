package com.ra.busBooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date filterDate;

	private String toDesination;

	private String fromDesination;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(Date filterDate) {
		this.filterDate = filterDate;
	}

	public String getToDesination() {
		return toDesination;
	}

	public void setToDesination(String toDesination) {
		this.toDesination = toDesination;
	}

	public String getFromDesination() {
		return fromDesination;
	}

	public void setFromDesination(String fromDesination) {
		this.fromDesination = fromDesination;
	}

}
