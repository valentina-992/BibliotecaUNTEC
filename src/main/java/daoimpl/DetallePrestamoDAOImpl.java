package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import config.ConexionDB;
import dao.DetallePrestamoDAO;

public class DetallePrestamoDAOImpl implements DetallePrestamoDAO {
	
	public void agregarLibro(int prestamoId, int libroId) {

	    String sql = "INSERT INTO detalle_prestamo (prestamo_id, libro_id) VALUES (?, ?)";

	    try {

	        Connection conn = ConexionDB.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, prestamoId);
	        ps.setInt(2, libroId);

	        ps.executeUpdate();

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	}


}
