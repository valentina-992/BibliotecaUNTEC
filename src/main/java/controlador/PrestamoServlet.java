package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.LibroDAO;
import dao.PrestamoDAO;
import daoimpl.LibroDAOImpl;
import daoimpl.PrestamoDAOImpl;

@WebServlet("/prestamos")
public class PrestamoServlet extends HttpServlet {
	
	private PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
	private LibroDAO libroDAO = new LibroDAOImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		String action = request.getParameter("action");
		
		if ("agregarCarrito".equals(action)) {
			agregarAlCarrito(request, response);
		}
		
		else if ("verCarrito".equals(action)) {
			mostrarCarrito(request, response);
		}
		
		else if ("eliminarCarrito".equals(action)) {
			eliminarDelCarrito(request, response);
		}
		
		else if ("confirmarPrestamo".equals(action)) {
			confirmarPrestamo(request, response);
		}
		
		else if ("misPrestamos".equals(action)) {
			mostrarPrestamos(request, response);
		}
		
		else if ("devolver".equals(action)) {
			devolverPrestamo(request, response);
		}
	}

	private void agregarAlCarrito(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		int libroId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		List<Integer> carrito = (List<Integer>) session.getAttribute("carrito");
		
		if (carrito == null) {
			carrito = new ArrayList<>();
		}
		
		if (!carrito.contains(libroId)) {
			carrito.add(libroId);
		}
		
		session.setAttribute("carrito", carrito);
		
		response.sendRedirect("libros");
	}
	
	private void mostrarCarrito(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		List<Integer> carrito = (List<Integer>) session.getAttribute("carrito");
		
		List<Libro> librosCarrito = new ArrayList<>();
		
		if (carrito != null) {
			
			for (Integer id: carrito) {
				
				Libro libro = libroDAO.buscarPorId(id);
				
				if (libro != null) {
					librosCarrito.add(libro);
				}
			}
		}
		
		request.setAttribute("librosCarrito", librosCarrito);
		
		request.getRequestDispatcher("carrito.jsp").forward(request, response);		
	}
	
	private void eliminarDelCarrito(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		int libroId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			List<Integer> carrito = (List<Integer>) session.getAttribute("carrito");
			
			if (carrito != null) {
				
				carrito.remove(Integer.valueOf(libroId));
				
				session.setAttribute("carrito", carrito);
			}
		}
		
		response.sendRedirect("prestamos?action=verCarrito");
	}
	
	private void confirmarPrestamo(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		HttpSession session = request.getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		List<Integer> carrito = (List<Integer>) session.getAttribute("carrito");
		
		if (carrito == null || carrito.isEmpty()) {
			response.sendRedirect("libros");
			return;
		}
		
		int prestamoId = prestamoDAO.crearPrestamo(usuario.getId());
		
		for (Integer libroId: carrito) {
			
			prestamoDAO.agregarDetalle(prestamoId, libroId);
			
			libroDAO.actualizarDisponibilidad(libroId, false);
		}
		
		session.removeAttribute("carrito");
		
		response.sendRedirect("libros");
	}
	
	private void mostrarPrestamos(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		List<Prestamo> prestamos = prestamoDAO.listarPorUsuario(usuario.getId());
		
		Map<Integer, List<String>> librosPorPrestamo = new HashMap<>();
		
		for (Prestamo p : prestamos) {
			
			List<String> libros = prestamoDAO.listarLibrosPorPrestamo(p.getId());
			
			librosPorPrestamo.put(p.getId(), libros);
		}
		
		request.setAttribute("prestamos", prestamos);
		request.setAttribute("librosPorPrestamo", librosPorPrestamo);
		
		request.getRequestDispatcher("misPrestamos.jsp").forward(request, response);
	}
	
	private void devolverPrestamo(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		int prestamoId = Integer.parseInt(request.getParameter("id"));
		
		List<Integer> libros = prestamoDAO.obtenerLibrosPorPrestamo(prestamoId);
		
		for (Integer libroId: libros) {
			
			libroDAO.actualizarDisponibilidad(libroId, true);
		}
		
		prestamoDAO.devolverPrestamo(prestamoId);
		
		response.sendRedirect("prestamos?action=misPrestamos");
	}

}
