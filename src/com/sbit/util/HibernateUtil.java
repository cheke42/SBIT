package com.sbit.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sbit.model.CondicionIva;
import com.sbit.model.Conversacion;
import com.sbit.model.Empresa;
import com.sbit.model.EstadoMensaje;
import com.sbit.model.EstadoTicket;
import com.sbit.model.Mensaje;
import com.sbit.model.Problema;
import com.sbit.model.Ticket;
import com.sbit.model.TipoUsuario;
import com.sbit.model.Usuario;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();


	private static SessionFactory buildSessionFactory() {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(CondicionIva.class);
			config.addAnnotatedClass(Conversacion.class);
			config.addAnnotatedClass(Empresa.class);
			config.addAnnotatedClass(EstadoMensaje.class);
			config.addAnnotatedClass(EstadoTicket.class);
			config.addAnnotatedClass(Mensaje.class);
			config.addAnnotatedClass(Problema.class);
			config.addAnnotatedClass(Usuario.class);
			config.addAnnotatedClass(Ticket.class);
			config.addAnnotatedClass(TipoUsuario.class);
			config.configure("hibernate.cfg.xml");
			return config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error en la creaccion de SessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public static List<Usuario> obtenerListaUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			usuarios = session.createQuery("FROM Usuario").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return usuarios;
	}


	 
	@SuppressWarnings("unchecked")
	public static List<CondicionIva> obtenerListaCondicionIva() {
		List<CondicionIva> listaCondicionIva = new ArrayList<CondicionIva>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			listaCondicionIva = session.createQuery("FROM CondicionIva").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return listaCondicionIva;
	}


	public static void traerDatosBase() {
	
	}

}