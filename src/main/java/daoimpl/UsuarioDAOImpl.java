package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ConexionDB;
import dao.UsuarioDAO;
import modelo.TipoUsuario;
import modelo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public void registrar(Usuario usuario) {

	    String sql = "INSERT INTO usuarios (nombre, email, password, tipo_usuario) VALUES (?, ?, ?, ?)";

	    try {

	        Connection conn = ConexionDB.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, usuario.getNombre());
	        ps.setString(2, usuario.getEmail());
	        ps.setString(3, usuario.getPassword());
	        ps.setString(4, usuario.getTipoUsuario().name());

	        ps.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Usuario login(String email, String password) {
		Usuario usuario = null;

	    String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";

	    try {

	        Connection conn = ConexionDB.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()){

	            usuario = new Usuario();

	            usuario.setId(rs.getInt("id"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setPassword(rs.getString("password"));

	            usuario.setTipoUsuario(
	                TipoUsuario.valueOf(rs.getString("tipo_usuario"))
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return usuario;
	}


}
