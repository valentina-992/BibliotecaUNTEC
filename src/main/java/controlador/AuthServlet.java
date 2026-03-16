package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.TipoUsuario;
import modelo.Usuario;

import java.io.IOException;

import dao.UsuarioDAO;
import daoimpl.UsuarioDAOImpl;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ("logout".equals(action)) {
			
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				session.invalidate();
			}
			
			response.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ("login".equals(action)) {
			login(request, response);
		}
		
		else if ("registro".equals(action)) {
			registrar(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = usuarioDAO.login(email, password);
		
		if (usuario != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);

            response.sendRedirect("libros");
		} else {
			
			request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String tipo = request.getParameter("tipoUsuario");

        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        
        usuario.setTipoUsuario(TipoUsuario.valueOf(tipo));

        usuarioDAO.registrar(usuario);

        response.sendRedirect("index.jsp");
    }

}
