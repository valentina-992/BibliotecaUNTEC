<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="container mt-5">

<h2 class="mb-4">Carrito de préstamo</h2>

<c:choose>

<c:when test="${empty carrito}">

<div class="alert alert-info mt-4 text-center">

<h4>Tu carrito está vacío 🛒</h4>

<a href="libros" class="btn btn-primary mt-3">
Ver libros
</a>

</div>

</c:when>

<c:otherwise>

<div class="row">

<c:forEach var="libro" items="${librosCarrito}">

<div class="col-md-6 col-lg-4 mb-4">

<div class="card shadow-sm h-100">

<div class="card-body">

<h5 class="card-title">
${libro.titulo}
</h5>

<p class="card-text">
Autor: ${libro.autor}
</p>

<a href="libros?action=quitarCarrito&id=${libro.id}"
class="btn btn-outline-danger btn-sm">

❌ Quitar

</a>

</div>

</div>

</div>

</c:forEach>

</div>

<div class="text-end mt-4">

<a href="libros" class="btn btn-secondary me-2">
Seguir viendo libros
</a>

<a href="libros?action=confirmarPrestamo"
class="btn btn-success">

Confirmar préstamo

</a>

</div>

</c:otherwise>

</c:choose>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>