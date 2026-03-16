package modelo;

import java.sql.Date;

public class Prestamo {
	
	private int id;
	private int usuarioId;
	private java.util.Date fechaPrestamo;
	private Date fechaDevolucion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuario_id) {
		this.usuarioId = usuario_id;
	}
	public java.util.Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(java.util.Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	

}
