package dao;

import java.util.List;

import modelo.Prestamo;

public interface PrestamoDAO {
	
	 int crearPrestamo(int usuarioId);
	 
	 void agregarDetalle(int prestamoId, int libroId);
	 
	 List<Prestamo> listarPorUsuario(int usuarioId);
	 
	 List<String> listarLibrosPorPrestamo(int prestamoId);
	 
	 void devolverPrestamo(int prestamoId);
	 
	 List<Integer> obtenerLibrosPorPrestamo(int prestamoId);

}
