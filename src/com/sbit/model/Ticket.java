package com.sbit.model;
// Generated 06/11/2015 12:05:22 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ticket generated by hbm2java
 */
@Entity
@Table(name = "ticket", catalog = "sbit")
public class Ticket implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idticket;
	private EstadoTicket estadoTicket;
	private Usuario usuarioByIdCliente;
	private Usuario usuarioByIdOperador;
	private Date fechaCreacion;
	private Date fechaCierre;

	public Ticket() {
	}

	public Ticket(EstadoTicket estadoTicket, Usuario usuarioByIdCliente, Usuario usuarioByIdOperador,
			Date fechaCreacion, Date fechaCierre) {
		this.estadoTicket = estadoTicket;
		this.usuarioByIdCliente = usuarioByIdCliente;
		this.usuarioByIdOperador = usuarioByIdOperador;
		this.fechaCreacion = fechaCreacion;
		this.fechaCierre = fechaCierre;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idticket", unique = true, nullable = false)
	public Integer getIdticket() {
		return this.idticket;
	}

	public void setIdticket(Integer idticket) {
		this.idticket = idticket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	public EstadoTicket getEstadoTicket() {
		return this.estadoTicket;
	}

	public void setEstadoTicket(EstadoTicket estadoTicket) {
		this.estadoTicket = estadoTicket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Usuario getUsuarioByIdCliente() {
		return this.usuarioByIdCliente;
	}

	public void setUsuarioByIdCliente(Usuario usuarioByIdCliente) {
		this.usuarioByIdCliente = usuarioByIdCliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_operador")
	public Usuario getUsuarioByIdOperador() {
		return this.usuarioByIdOperador;
	}

	public void setUsuarioByIdOperador(Usuario usuarioByIdOperador) {
		this.usuarioByIdOperador = usuarioByIdOperador;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cierre", length = 19)
	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

}
