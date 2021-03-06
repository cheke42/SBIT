package com.sbit.model;
// Generated 06/11/2015 12:05:22 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "sbit")
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private TipoUsuario tipoUsuario;
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	private Set<Ticket> ticketsForIdCliente = new HashSet<Ticket>(0);
	private Set<Ticket> ticketsForIdOperador = new HashSet<Ticket>(0);

	public Usuario() {
	}

	public Usuario(TipoUsuario tipoUsuario, String nombre, String apellido, String usuario, String password,
			Set<Ticket> ticketsForIdCliente, Set<Ticket> ticketsForIdOperador) {
		this.tipoUsuario = tipoUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.password = password;
		this.ticketsForIdCliente = ticketsForIdCliente;
		this.ticketsForIdOperador = ticketsForIdOperador;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", length = 45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "usuario", length = 45)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdCliente")
	public Set<Ticket> getTicketsForIdCliente() {
		return this.ticketsForIdCliente;
	}

	public void setTicketsForIdCliente(Set<Ticket> ticketsForIdCliente) {
		this.ticketsForIdCliente = ticketsForIdCliente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdOperador")
	public Set<Ticket> getTicketsForIdOperador() {
		return this.ticketsForIdOperador;
	}

	public void setTicketsForIdOperador(Set<Ticket> ticketsForIdOperador) {
		this.ticketsForIdOperador = ticketsForIdOperador;
	}

}
