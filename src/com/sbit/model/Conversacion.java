package com.sbit.model;
// Generated 06/11/2015 12:05:22 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Conversacion generated by hbm2java
 */
@Entity
@Table(name = "conversacion", catalog = "sbit")
public class Conversacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idconversacion;

	public Conversacion() {
	}

	public Conversacion(Integer idconversacion) {
		this.idconversacion = idconversacion;
	}

	@Id

	@Column(name = "idconversacion", unique = true, nullable = false)
	public Integer getIdconversacion() {
		return this.idconversacion;
	}

	public void setIdconversacion(Integer idconversacion) {
		this.idconversacion = idconversacion;
	}

}
