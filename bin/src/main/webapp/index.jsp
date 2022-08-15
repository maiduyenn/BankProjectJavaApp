<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
.container-sm {
	margin: auto;
	width: fit-content;
	padding: 30px;
	max-height: 100vh;
}

.login {
	border: 2px solid #07777721;
}

#title {
	text-align: center;
	font-size: 40px;
	margin-top: 200px;
	margin-bottom: 30px;
}

.login-panel {
	display: flex;
	justify-content: center;
}

.login-panel label {
	margin: 10px
}

.login-panel button {
	margin: 30px 150px;
}

.login-panel a {
	text-decoration: none;
}

.mid-content p {
	text-align: center;
	margin: 30px 0 0 0;
}
</style>
</head>

<body>
	<main>
		<div class="container-sm">
			<div class="main-header">
				<h1 id="title">Login Page</h1>
			</div>
			<div class="login">
				<div class="login-panel">
					<form action="LoginServlet" method="post">
						<table>
							<tr>
								<td><label for="id"><b>User ID/Customer ID</b></label></td>
								<td><input type="text" name="id" id="id" value="">
								</td>
							</tr>
							<tr>
								<td><label for="password"><b>Password</b></label></td>
								<td><input type="password" name="password" id="password"
									value=""></td>
							</tr>
						</table>
						<div class="mid-content">
							<p>
								<a href="change_password.jsp">Change password</a>
							</p>
						</div>
						<button type="submit" class="btn btn-primary" id="submit-button">Login</button>
					</form>
				</div>
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