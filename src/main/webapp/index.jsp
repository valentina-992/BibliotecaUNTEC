<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de sesión</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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
					<h2>Iniciar sesión</h2>
				</div>
				<div class="card-body">
					<form action="auth" method="post">
						
						<input type="hidden" name="action" value="login">
					
						<div class="mb-3">
							<label class="form-label">Correo:</label>
							<input type="email" name="email" class="form-control" required>
						</div>
						
						<div class="mb-3">
							<label class="form-label">Contraseña:</label>
							<input type="password" name="password" class="form-control" required>
						</div>
						
						<button type="submit" name="action" value="login" class="btn btn-success">
						Ingresar
						</button>
						
					</form>
					
					<c:if test="${error != null}">
					<div class="alert alert-danger mt-3" role="alert">
  						${error}
					</div>
					</c:if>
					
					<hr>
					
					<a href="registro.jsp">¿Aún no tienes cuenta? Registrate aquí.</a>
					
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>