<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="com.servlets.model.UserAuth"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
UserAuth user = (UserAuth) request.getSession().getAttribute("user");
pageContext.setAttribute("userInfo", user);
%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>Homepage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<main>
		<div class="user-content">
			<p class="clickable-button">
				<a class="back-button" href="Logout">Logout</a>
			</p>
		</div>
		<div class="container">
			<div class="main-header">
				<h1>Bank Account Management</h1>
			</div>
			<div class="main-form">
				<div class="card-body">
					<button class="clickable-button btn-action"
						onclick="doFunction('SavingAccountDisplay')">Saving
						Account</button>
				</div>
				<div class="card-body">
					<button class="clickable-button btn-action"
						onclick="doFunction('CurrentAccountDisplay')">Current
						Account</button>
				</div>
			</div>
		</div>

		<hr>
		<div class="main-account-content">
			<iframe src="CurrentAccountDisplay" width="1056" height="300"
				id="account-content"></iframe>
		</div>
		<div class="container-new main-content">
			<a class="btn-action" onclick="openNav('deposit')">Deposit</a> <a
				class="btn-action" onclick="openNav('withdraw')">WithDraw</a> <a
				class="btn-action" onclick="openNav('save')">Save</a> <a
				class="btn-action" onclick="openNav('transfer')">Transfer</a>
		</div>
		</div>
	</main>

	<div id="myNav" class="overlay">
		<div class="overlay-content">
			<form action="CurrentAccountTask" method="post" id="bank-action">
				<div class="row">
					<div class="col-12">
						<label for="amount">Type Account</label> <select id="account-type">
							<option value="CurrentAccount">Current Account</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="row">
							<div class="col-12" style="margin-top: 30px;">
								<label for="customer_name">CUSTOMER NAME</label> <input
									type="text" name="customer_name" id="customer_name" disabled
									value="<%=user.getCusName()%>">
							</div>
						</div>
						<div class="row">
							<div class="col-6" style="margin-top: 30px;">
								<label for="to-customer-id" id="to-customer-id-label"
									style="display: none; text-align: right;">SEND TO
									CUSTOMER ID</label>
							</div>
							<div class="col-6" style="margin-top: 30px;">
								<input type="text" name="to-customer-id" id="to-customer-id"
									value="0" required style="display: none;" />
							</div>
						</div>
						<div class="row">
							<div class="col-12" style="margin-top: 30px;">
								<label for="transaction">TRANSACTION</label> <input type="text"
									name="transaction" id="transaction" value=""> <label
									for="amount">AMOUNT</label> <input type="text" name="amount"
									id="amount" required>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<input placeholder="duration" id="duration" name="duration"
									required value="0"
									style="display: none; margin-left: auto; margin-right: auto; margin-top: 30px;">
							</div>
						</div>
						<div class="row">
							<div class="col-12" style="margin-top: 30px;">
								<button type="submit" id="submit-button-name">DEPOSIT</button>
								<button type="reset" onclick="closeNav()">CANCEL</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js "
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB "
		crossorigin="anonymous "></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js "
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13 "
		crossorigin="anonymous "></script>
	<script type="text/javascript "
		src="https://cdn.jsdelivr.net/npm/toastify-js "></script>

	<script>
		function doFunction(urlSrc) {
			document.getElementById("account-content").src = urlSrc;
		}

		function openNav(value) {
			document.getElementById("myNav").style.width = "100%";
			document.getElementById("transaction").value = value;
			document.getElementById("submit-button-name").innerHTML = value
					.toUpperCase();

			if (value == 'transfer') {
				document.getElementById("to-customer-id-label").style.display = "block";
				document.getElementById("to-customer-id").style.display = "block";
				document.getElementById("submit-button-name").value = value;
			} else {
				document.getElementById("to-customer-id-label").style.display = "none";
				document.getElementById("to-customer-id").style.display = "none";
			}
			if (value == 'save') {
				document.getElementById("duration").style.display = "block";
			} else {
				document.getElementById("duration").style.display = "none";
			}
		}

		function closeNav() {
			document.getElementById("myNav").style.width = "0%";
		}
	</script>
</body>

</html>