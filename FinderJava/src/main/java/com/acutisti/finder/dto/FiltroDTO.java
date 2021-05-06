package com.acutisti.finder.dto;

import java.io.Serializable;
import java.util.Date;

public class FiltroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date startDate;
	private Date endDate;
	private String placa;
	
	public FiltroDTO() {
	}

	public FiltroDTO(Date startDate, Date endDate, String placa) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.placa = placa;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
