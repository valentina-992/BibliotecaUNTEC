<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Préstamos</title>
<link rel="icon" type="image/svg+xml" href="img/2379396.svg">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<jsp:include page="navbar.jsp" />
	
	<div class="container mt-4">
	
	<h2>Mis préstamos</h2>
	
		<div class="row">
		
			<c:forEach var="p" items="${prestamos}">
			
				<div class="col-md-6 col-lg-4 mb-4">
					<div class="card shadow-sm">
						<div class="card-body">
						
						<h5 class="card-title">
							Préstamo #${p.id}
						</h5>
				
						<p class="card-text">
				
							<strong>Fecha préstamo:</strong> ${p.fechaPrestamo}<br>
							
							<strong>Estado:</strong>
							
							<c:choose>
							
								<c:when test="${empty p.fechaDevolucion}">
									<span class="badge bg-warning text-dark">
									Activo
									</span>
								</c:when>
								
								<c:otherwise>
									<span class="badge bg-success">
									Devuelto
									</span>
								</c:otherwise>
							
							</c:choose>
				
						</p>			
						<hr>
				
						<strong>Libros:</strong>
				
						<ul class="list-group list-group-flush mt-2">
				
							<c:forEach var="libro" items="${librosPorPrestamo[p.id]}">
					
								<li class="list-group-item">
									${libro}
								</li>
					
							</c:forEach>
				
						</ul>
				
						<br>
				
						<c:if test="${empty p.fechaDevolucion}">
				
							<a href="prestamos?action=devolver&id=${p.id}"
							class="btn btn-outline-danger btn-sm">
								Devolver libros
							</a>
				
						</c:if>
				
						</div>
					</div>
				</div>
			
			</c:forEach>
		
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>