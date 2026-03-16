package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Libro;
import modelo.Prestamo;
import modelo.TipoUsuario;
import modelo.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.LibroDAO;
import daoimpl.LibroDAOImpl;
import dao.PrestamoDAO;
import daoimpl.PrestamoDAOImpl;

/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	
	private LibroDAO libroDAO = new LibroDAOImpl();
	private PrestamoDAO prestamoDAO = new PrestamoDAOImpl();

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String action = request.getParameter("action");
    	
    	HttpSession session = request.getSession(false);
    	
    	if (session == null || session.getAttribute("usuario") == null) {
    	    response.sendRedirect("index.jsp");
    	    return;
    	}
    	
    	if (action == null) {
    		
    		listarLibros(request, response);
    	}
    	
    	else if ("nuevo".equals(action)) {
    		mostrarFormularioNuevo(request, response);
    	}

    	else if ("editar".equals(action)) {
    		mostrarFormularioEditar(request, response);
    	}
    	else if ("eliminar".equals(action)) {
    	    eliminarLibro(request, response);
    	}


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
		    response.sendRedirect("index.jsp");
		    return;
		}
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario == null || usuario.getTipoUsuario() != TipoUsuario.TRABAJADOR) {
			
			response.sendRedirect("libros");
			return;
		}
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		
		boolean disponible = request.getParameter("disponible") != null;
		
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setDisponible(disponible);
		
		String action = request.getParameter("action");

		if ("actualizar".equals(action)) {
		    actualizarLibro(request, response);
		    return;
		}
		
		libroDAO.guardar(libro);
		
		response.sendRedirect("libros");
	}
	
	private void listarLibros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Libro> libros = libroDAO.listar();
		request.setAttribute("libros", libros);
		
		HttpSession session = request.getSession(false);

	    if (session != null) {

	        List<Integer> carrito = (List<Integer>) session.getAttribute("carrito");

	        if (carrito != null) {

	            List<Libro> librosCarrito = new ArrayList<>();

	            for (Integer id : carrito) {

	                Libro libro = libroDAO.buscarPorId(id);

	                if (libro != null) {
	                    librosCarrito.add(libro);
	                }
	            }

	            request.setAttribute("librosCarrito", librosCarrito);
	        }
	    }

	    List<Integer> carrito = null;

	    if (session != null) {
	        carrito = (List<Integer>) session.getAttribute("carrito");
	    }

	    request.setAttribute("carrito", carrito);
	    
	    request.getRequestDispatcher("libros.jsp").forward(request, response);
	}
	
	private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("agregarLibro.jsp").forward(request, response);
	}

	private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Libro libro = libroDAO.buscarPorId(id);
		
		request.setAttribute("libro", libro);
		
		request.getRequestDispatcher("editarLibro.jsp").forward(request, response);
	}

	private void actualizarLibro(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    int id = Integer.parseInt(request.getParameter("id"));

	    String titulo = request.getParameter("titulo");
	    String autor = request.getParameter("autor");

	    boolean disponible = request.getParameter("disponible") != null;

	    Libro libro = new Libro();

	    libro.setId(id);
	    libro.setTitulo(titulo);
	    libro.setAutor(autor);
	    libro.setDisponible(disponible);

	    libroDAO.actualizar(libro);

	    response.sendRedirect("libros");
	}

	private void eliminarLibro(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {

	    int id = Integer.parseInt(request.getParameter("id"));

	    libroDAO.eliminar(id);

	    response.sendRedirect("libros");
	}


}
