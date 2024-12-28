<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Change Product Details</h1>

				<form action="${pageContext.request.contextPath }/handle-product" method="post">
				  <input type="hidden" name="id" value="${product.id }"/>
					<div class="form-group">
						<label for="name">Product</label> <input type="text"
							placeholder="Enter the product name here" name="name"
							class="form-control" id="name" value="${product.name }">
					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea placeholder="Enter the product description here"
							name="description" row="5" class="form-control" id="description">${product.description }</textarea>
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="text"
							placeholder="Product Price" name="price" class="form-control"
							id="price" value="${product.price }">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-warning">Update</button>
					</div>

				</form>

			</div>

		</div>




	</div>


</body>
</html>