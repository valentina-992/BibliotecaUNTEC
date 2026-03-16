package dao;

import modelo.Usuario;

public interface UsuarioDAO {
	
	void registrar(Usuario usuario);
	Usuario login(String email, String password);

}
