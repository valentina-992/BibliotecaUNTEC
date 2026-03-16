<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
	<div class="container">
		<span class="navbar-brand mb-0 h1">
		<i class="bi bi-book-half"></i>
		BibliotecaUNTEC
		</span>
	</div>
</nav>

<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card shadow">
				<div class="card-header bg-dark text-white">
					<h2>Registro de usuario</h2>
				</div>
				<div class="card-body">
					<form action="auth" method="post">
					<input type="hidden" name="action" value="registro">
					<div class="mb-3">
						<label class="form-label">Nombre:</label>
						<input type="text" name="nombre" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Correo:</label>
						<input type="email" name="email" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Contraseña:</label>
						<input type="password" name="password" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Tipo de usuario:</label>
						<select name="tipoUsuario" class="form-select">
							<option value="" disabled selected>Seleccione tipo de usuario</option>
						    <option value="ESTUDIANTE">Estudiante</option>
						    <option value="TRABAJADOR">Trabajador</option>
						</select>
					</div>
					<button type="submit" class="btn btn-success">Registrarse</button>
					<a href="index.jsp" class="btn btn-secondary">Volver al login</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>