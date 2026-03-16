<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar libro</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp"/>

<div class="container mt-5">
	<h2>Editar Libro</h2>
	
	<form action=libros?action=actualizar" method="post">
		<input type="hidden" name="id" value="${libro.id}">
		
		<div class="mb-3">
			<label class="form-label">Título</label>
			<input type="text" name="titulo" class="form-control" value="${libro.titulo}" required>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Autor</label>
			<input type="text" name="autor" class="form-control" value="${libro.autor}" required>
		</div>
		
		<div class="form-check mb-3">
			<input class="form-check-input" type="checkbox" name="disponible" ${libro.disponible ? "checked" : ""}>
			<label class= "form-check-label">Disponible</label>
		</div>
		
		<button class="btn btn-primary">Actualizar</button>
		
		<a href="libros" class="btn btn-secondary">Cancelar</a>
	</form>

</div>

</body>
</html>