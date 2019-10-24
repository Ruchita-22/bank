<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.box{
margin-top:80px;
padding:10px 50px 50px 50px;
border: 2px solid rgba(0,0,0,0.1);
}

</style>
<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">



function callAjax(id) {

	$(id).submit(function(e) {
		var frm = $(id);
		e.preventDefault();

	    var data = {}
	    var Form = this;

	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });

	    $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(callback){ 
          
            	document.getElementById('print').innerHTML="";
            	var myHTML="";
            	myHTML+="<table style=\" margin-top:45px;\"class=\"table table-striped\"><tr> <th> Account Number </th> <th> Holder's Name </th>  <th> Balance </th> <th> Status </th>  </tr>";
            	
            	
            	for(i=0;i<callback.length;i++){
            		          myHTML+= "<tr><td>"+callback[i].accountNumber+"</td><td>"+callback[i].accountHolderName+
            		          "</td><td>"+callback[i].accountBalance+"</td><td>"+callback[i].statusFlag+"</td></tr>";
            		             }
            	myHTML+="</table>";
            	
            	document.getElementById('print').innerHTML+=myHTML;
            	
                $(this).html("Success!");
            },
            error : function(){
                $(this).html("Error!");
            }
        });
		});
	}
	
	
</script>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Nucleus Software Exports</a>
    </div>
    <ul class="nav navbar-nav">
     <li class="active"><a data-toggle="pill" href="#home">Add</a></li>
      <li><a data-toggle="pill" href="#menu1">Update</a></li>
     <li><a data-toggle="pill" href="#menu2">Delete</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/SpringMVCProject/logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        </ul>
  </div>
</nav>

<div class="container">
<div class="row">
<div class="col-md-6">

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    
<div class="box">
<div class="page-header text-center">
<h3><strong>Add</strong></h3>
</div>
       <form:form class="form-horizontal" action="submit" method="POST" commandName="account" id="submitForm">
Enter Account Number <form:input class="form-control" path="accountNumber"/>
Enter Account Holder Name <form:input class="form-control" path="accountHolderName"/>
Enter Account Balance<form:input class="form-control" path="accountBalance"/>
<center><input type="submit" class="btn btn-danger btn-md" style="margin-top:10px;" onclick="callAjax('#submitForm');" value="Submit"/></center>
</form:form>
    </div>
    </div>
    
    <div id="menu1" class="tab-pane fade">
      <div class="box">
      <div class="page-header text-center">
<h3><strong>Update</strong></h3>
</div>
      <form action="update" method="post" commandName="account" id="updateForm">
      Enter Account Number  <input class="form-control" name="accountNumber" type="text"/>
      <center><input type="submit" class="btn btn-danger btn-md" style="margin-top:10px;" onclick="callAjax('#updateForm');" value="Submit"/></center>

      </form>
      </div>
      
    </div>
    <div id="menu2" class="tab-pane fade">
      <div class="box">
      <div class="page-header text-center">
<h3><strong>Delete</strong></h3>
</div>
      <form:form action="delete" method="post" commandName="account" id="deleteForm">
      Enter Account Number  <form:input class="form-control" path="accountNumber"  type="text"/>
      <center><input type="submit" class="btn btn-danger btn-md" style="margin-top:10px;" onclick="callAjax('#deleteForm');" value="Submit"/></center>

      </form:form>
      </div>
    </div>
    <div id="menu3" class="tab-pane fade">
     
    </div>
  </div>









</div>
<div class="col-md-6">

<div id="print"></div></div></div>
</div>
</body>
</html>