<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca UNTEC</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<jsp:include page="navbar.jsp" />

<body>

<div class="container mt-4">

	<c:if test="${sessionScope.usuario == null}">
	    <c:redirect url="index.jsp"/>
	</c:if>

	<h4 class="mb-4" style="color: grey;">Bienvenid@ ${sessionScope.usuario.nombre} </h4>

	<c:if test="${not empty librosCarrito}">

		<h3 class="mt-4">Carrito de préstamo</h3>
	    
	    <ul class="list-group mb-3">
	        <c:forEach var="libro" items="${librosCarrito}">
	            <li class="list-group-item d-flex justify-content-between align-items-center">
	            	${libro.titulo} - ${libro.autor}
	            
		            <a href="prestamos?action=eliminarCarrito&id=${libro.id}" class="btn btn-sm btn-outline-danger">
		 				Eliminar
					</a>
	
				</li>
	        </c:forEach>
	    </ul>
	
	    <a href="prestamos?action=confirmarPrestamo" class="btn btn-success mb-5">
	        Confirmar préstamo
	    </a>

	</c:if>


	<h2>Libros disponibles</h2>

	<table class="table table-striped table-hover">
	
		<thead class="table-dark">
		
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Acciones</th>
			</tr>
		
		</thead>
	
		<tbody>
		
			<c:forEach var="libro" items="${libros}">
			
				<tr>
					<td>${libro.titulo}</td>
					<td>${libro.autor}</td>
					<td>
						<c:choose>
							<c:when test="${carrito != null && carrito.contains(libro.id)}">
								<button class="btn btn-secondary btn-sm" disabled>
								Ya agregado
								</button>
							</c:when>
				
							<c:otherwise>
								<a href="prestamos?action=agregarCarrito&id=${libro.id}" class="btn btn-primary btn-sm">
								Agregar al préstamo
								</a>
							</c:otherwise>
						</c:choose>
				
						<c:if test="${sessionScope.usuario.tipoUsuario == 'TRABAJADOR'}">
							<a href="libros?action=editar&id=${libro.id}" class="btn btn-warning btn-sm">
							Editar
							</a>
							
							<button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal"
							data-id="${libro.id}" data-titulo="${libro.titulo}">		
							Eliminar	
							</button>			
						</c:if>
				
					</td>
				</tr>
				
			</c:forEach>
			
		</tbody>
		
	</table>

</div>
	<div class="modal fade" id="confirmDeleteModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
					Confirmar eliminación
					</h5>
	
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<div class="modal-body">
					<p>
					¿Seguro que deseas eliminar el libro
					<strong id="tituloLibro"></strong>?
					</p>
				</div>

				<div class="modal-footer">
					<button class="btn btn-secondary" data-bs-dismiss="modal">
					Cancelar
					</button>

					<a id="btnEliminar" class="btn btn-danger">
						Eliminar
					</a>
				</div>

			</div>
		</div>
	</div>


<script>
	const modal = document.getElementById('confirmDeleteModal');
	
	modal.addEventListener('show.bs.modal', function (event) {
	
	const button = event.relatedTarget;
	
	const libroId = button.getAttribute('data-id');
	const titulo = button.getAttribute('data-titulo');
	
	document.getElementById("tituloLibro").textContent = titulo;
	
	document.getElementById("btnEliminar").href =
	"libros?action=eliminar&id=" + libroId;
	
	});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>