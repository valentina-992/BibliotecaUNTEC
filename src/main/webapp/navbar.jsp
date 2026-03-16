<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="libros">
		<i class="bi bi-book-half"></i>
		BibliotecaUNTEC
		</a>
		<button class="navbar-toggler" type="button"
		data-bs-toggle="collapse"
		data-bs-target="#navbarNav">
		<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto">
				<li class="nav-item">
					<a class="nav-link" href="libros">
					Libros
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="prestamos?action=misPrestamos">
					Mis préstamos
					</a>
				</li>
					<c:if test="${sessionScope.usuario.tipoUsuario == 'TRABAJADOR'}">
						<li class="nav-item">
							<a class="nav-link" href="libros?action=nuevo">
							Agregar libro
							</a>
						</li>
					</c:if>
				<li class="nav-item">
					<a class="nav-link" href="prestamos?action=verCarrito">
					Carrito
					<span class="badge bg-primary">
					${sessionScope.carrito != null ? sessionScope.carrito.size() : 0}
					</span>
					</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link disabled">
					<i class="bi bi-person-circle"></i>
					${sessionScope.usuario.nombre}
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link text-danger"
					href="auth?action=logout">
					Cerrar sesión
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

</body>
</html>