<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar libros</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card shadow">
				<div class="card-header bg-dark text-white">
					<h4 class="mb-0">Agregar nuevo libro</h4>
				</div>
				<div class="card-body">
					<form action="libros" method="post">
						<div class="mb-3">
							<label class="form-label">Título</label>
							<input type="text" name="titulo" class="form-control" required>
						</div>
						<div class="mb-3">
							<label class="form-label">Autor</label>
							<input type="text" name="autor" class="form-control" required>
        				</div>
						<div class="form-check mb-3">
							<input class="form-check-input" type="checkbox" name="disponible" checked>
							<label class="form-check-label">Disponible</label>
						</div>
						<div class="d-flex justify-content-between">
							<a href="libros" class="btn btn-secondary">Volver</a>
							<button type="submit" class="btn btn-success">Guardar libro</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>