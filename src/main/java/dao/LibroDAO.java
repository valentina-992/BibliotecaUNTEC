package dao;

import java.util.List;

import modelo.Libro;

public interface LibroDAO {
	
	List<Libro> listar();
	Libro buscarPorId(int id);
	void guardar(Libro libro);
	void actualizarDisponibilidad(int id, boolean disponible);
	void actualizar(Libro libro);
	void eliminar(int id);

}
