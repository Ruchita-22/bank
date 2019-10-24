<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}


.box{
margin-top:80px;
padding:10px 50px 50px 50px;
border: 2px solid rgba(0,0,0,0.1);
}


</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<div class="col-md-6 col-md-offset-3">
	<div class="box">

		<div class="page-header text-center">
<h3><strong>Login</strong></h3>
</div>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form class="form-horizontal" name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>

		<div class="form-group">
    <label class="control-label col-sm-2" for="email">Username</label>
    <div class="col-sm-10"><input class="form-control" type='text' name='username'></div>
			 <label class="control-label col-sm-2" for="email">Password</label>
    <div class="col-sm-10"><input class="form-control" type='password' name='password' /></div>
			<center><button style="margin-top:10px;"class="btn btn-md btn-danger" type="submit">Login</button></center>
			

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>
</div>
</body>
</html>