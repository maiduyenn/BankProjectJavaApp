<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
.main-content {
	max-width: 720px;
}

.main-header {
	margin-top: 30px;
}

.main-content .main-header, .main-form-button {
	display: flex;
	justify-content: center;
	padding: 30px;
}

.main-form-button button {
	margin: 30px;
}
</style>
</head>

<body>
	<main>
		<div class="container-sm main-content">
			<div class="main-header">
				<h1>Registation</h1>
			</div>
			<div class="main-form">
				<form action="RegisterServlet" method="post">
					<div class="mb-3">
						<label for="customer-name" class="form-label">Customer
							Name</label> <input type="text" class="form-control" id="customer-name"
							name="customer-name" aria-describedby="customer-name">
					</div>
					<div class="mb-3">
						<label for="customer-address" class="form-label">Customer
							Address</label> <input type="text" class="form-control"
							id="customer-address" name="customer-address"
							aria-describedby="customer-address">
					</div>
					<div class="mb-3">
						<label for="customer-phone" class="form-label">Customer
							Phone</label> <input type="text" class="form-control" id="customer-phone"
							name="customer-phone" aria-describedby="customer-phone">
					</div>
					<div class="main-form-button">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-primary">Reset</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>

</html>