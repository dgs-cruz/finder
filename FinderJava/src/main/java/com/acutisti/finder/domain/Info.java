package com.acutisti.finder.domain;

import java.io.Serializable;
import java.util.Date;

public class Info implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date startDate;
	private Date endDate;
	private String duration;
	private Car car;
	private POI poi;
	
	public Info() {
	}
	
	public Info(Date startDate, Date endDate, String duration, Car car, POI poi) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.car = car;
		this.poi = poi;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration() {
		
		
		if (this.getStartDate() != null && this.getEndDate() != null) {
			long difference = this.getEndDate().getTime() - this.getStartDate().getTime();
			
			long second = (difference / 1000) % 60;
		    long minute = (difference / (1000 * 60)) % 60;
		    long hour = (difference / (1000 * 60 * 60)) % 24;
		    long day = (difference / (1000*60*60*24));

		    String time = String.format("%02dd%02dh%02dm%02ds", day, hour, minute, second);
		    
		    this.duration = time;
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public POI getPoi() {
		return poi;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
