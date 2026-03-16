package daoimpl;

import dao.LibroDAO;
import modelo.Libro;
import config.ConexionDB;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LibroDAOImpl implements LibroDAO {
	
	@Override
	public List<Libro> listar() {
		
		List<Libro> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM libros WHERE disponible = true";
		
		try (Connection conn = ConexionDB.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			
			while (rs.next() ) {
				Libro libro = new Libro();
				
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setDisponible(rs.getBoolean("disponible"));
				
				lista.add(libro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@Override
	public Libro buscarPorId(int id) {
		
		Libro libro = null;
		
		String sql = "SELECT * FROM libros WHERE id=?";
		
		try (Connection conn = ConexionDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				libro = new Libro();
				
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setDisponible(rs.getBoolean("disponible"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return libro;
	}
	
	@Override
	public void guardar(Libro libro) {
		String sql = "INSERT INTO libros (titulo, autor, disponible) VALUES (?, ?, ?)";
		
		try (Connection conn = ConexionDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setBoolean(3, libro.isDisponible());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarDisponibilidad(int id, boolean disponible) {

	    String sql = "UPDATE libros SET disponible = ? WHERE id = ?";

	    try {

	        Connection conn = ConexionDB.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setBoolean(1, disponible);
	        ps.setInt(2, id);

	        ps.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void actualizar(Libro libro) {

	    String sql = "UPDATE libros SET titulo=?, autor=?, disponible=? WHERE id=?";

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, libro.getTitulo());
	        ps.setString(2, libro.getAutor());
	        ps.setBoolean(3, libro.isDisponible());
	        ps.setInt(4, libro.getId());

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void eliminar(int id) {

	    String sql = "DELETE FROM libros WHERE id=?";

	    try (Connection conn = ConexionDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



}
