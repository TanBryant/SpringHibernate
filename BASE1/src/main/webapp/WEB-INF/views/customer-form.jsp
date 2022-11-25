<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Nguyen Nhat Tan - CNTT-K18 </title> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7" style="margin: 0 auto;">
   <h3  style="color:red">Nguyen Nhat Tan - CNTT-K18</h3>
   <div class="panel panel-info"> 
    <div class="panel-body">
     <form:form action="saveCustomer" cssClass="form-horizontal"
      method="post" modelAttribute="customer">

      <!-- need to associate this data with Product id -->
      <form:hidden path="id" />

		<div class="form-group">
			 <label for="customerType" class="col-md-3 control-label">CustomerType</label>
			 <div class="col-md-9">
				 <form:select path="customerType.id" cssClass="form-control">
					 <c:forEach var="customerType" items="${customerTypes}" varStatus="loop">
						 <option value="${customerType.id}"
						 	<c:if test="${customerType.id == customer.customerType.id}">selected</c:if>>
						 ${customerType.name}
						 </option>
					</c:forEach>
	 			</form:select>
			</div>
		</div>

      <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	Full Name</label>
       <div class="col-md-9">
        <form:input path="fullname" cssClass="form-control" />
       </div>
      </div> 
      
      <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	BirtDay</label>
       <div class="col-md-9">
        <form:input path="birtday" type="date" cssClass="form-control" />
       </div>
      </div>  
      <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	Sex</label>
       <div class="col-md-9">
        <form:input path="sex" cssClass="form-control" />
       </div>
      </div> 
      
	  <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	Phone Number</label>
       <div class="col-md-9">
        <form:input path="phone" cssClass="form-control" />
       </div>
      </div> 
      <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	CMND</label>
       <div class="col-md-9">
        <form:input path="cmnd" cssClass="form-control" />
       </div>
      </div> 
	<div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="name" class="col-md-3 control-label">
       	Address</label>
       <div class="col-md-9">
        <form:input path="address" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9 mt-3">
        <form:button class="btn btn-primary" style="width:100%">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>