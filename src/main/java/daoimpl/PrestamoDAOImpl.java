package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ConexionDB;
import dao.PrestamoDAO;
import modelo.Prestamo;

public class PrestamoDAOImpl implements PrestamoDAO {
	
	@Override
	public int crearPrestamo(int usuarioId) {

	    int prestamoId = 0;

	    String sql = "INSERT INTO prestamos (usuario_id, fecha_prestamo) VALUES (?, NOW())";

	    try {

	        Connection conn = ConexionDB.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	        ps.setInt(1, usuarioId);

	        ps.executeUpdate();

	        ResultSet rs = ps.getGeneratedKeys();

	        if(rs.next()){
	            prestamoId = rs.getInt(1);
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return prestamoId;
	}
	
	@Override 
	public void agregarDetalle(int prestamoId, int libroId) {
		
		String sql = "INSERT INTO detalle_prestamo (prestamo_id, libro_id) VALUES (?, ?)";
		
		try {
			
			Connection conn = ConexionDB.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, prestamoId);
			ps.setInt(2, libroId);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Prestamo> listarPorUsuario(int usuarioId) {

	    List<Prestamo> prestamos = new ArrayList<>();

	    String sql = "SELECT * FROM prestamos WHERE usuario_id = ? ORDER BY fecha_prestamo DESC";

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, usuarioId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Prestamo p = new Prestamo();

	            p.setId(rs.getInt("id"));
	            p.setUsuarioId(rs.getInt("usuario_id"));
	            p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
	            p.setFechaDevolucion(rs.getDate("fecha_devolucion"));

	            prestamos.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return prestamos;
	}
	
	@Override
	public List<String> listarLibrosPorPrestamo(int prestamoId) {

	    List<String> libros = new ArrayList<>();

	    String sql = """
	        SELECT l.titulo
	        FROM detalle_prestamo d
	        JOIN libros l ON d.libro_id = l.id
	        WHERE d.prestamo_id = ?
	    """;

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, prestamoId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            libros.add(rs.getString("titulo"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return libros;
	}
	
	@Override
	public void devolverPrestamo(int prestamoId) {

	    String sql = "UPDATE prestamos SET fecha_devolucion = NOW() WHERE id = ?";

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, prestamoId);

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public List<Integer> obtenerLibrosPorPrestamo(int prestamoId) {

	    List<Integer> libros = new ArrayList<>();

	    String sql = "SELECT libro_id FROM detalle_prestamo WHERE prestamo_id = ?";

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, prestamoId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            libros.add(rs.getInt("libro_id"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return libros;
	}



}
