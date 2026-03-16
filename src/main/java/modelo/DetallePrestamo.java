package modelo;

public class DetallePrestamo {
	
	private int id;
	private int prestamoId;
	private int libroId;
	
	public DetallePrestamo() {}
	
	public DetallePrestamo(int prestamoId, int libroId) {
		this.prestamoId = prestamoId;
		this.libroId = libroId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}
	public int getLibroId() {
		return libroId;
	}
	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}
	
	

}
