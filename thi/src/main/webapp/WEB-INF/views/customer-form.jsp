<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">Khách hàng</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Thêm khách</div>
				</div>
				<c:if test="${message != null}">
		          <span class="message">${message}</span>
		      </c:if>
				<div class="panel-body">
					<form:form action="saveCustomer" cssClass="form-horizontal"
						method="post" modelAttribute="customer">

						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-md-3 control-label">SDT</label>
							<div class="col-md-9">
								<form:input path="phone" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="cccd" class="col-md-3 control-label">Số CMND/CCCD</label>
							<div class="col-md-9">
								<form:input path="cccd" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="date" class="col-md-3 control-label">Ngày sinh</label>
							<div class="col-md-9">
								<form:input path="date" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="province" class="col-md-3 control-label">Province</label>
							<div class="col-md-9">
								<form:select path = "province">
				                     <form:option value = "" label = "Select"/>
				                     <c:forEach var="provin" items="${provinces}">
      									<form:option value="${provin.id }" label="${provin.name}" 
      									selected="${provin.id==customer.province.id?'selected':''}"
      									/>
   									 </c:forEach>
   
				                  </form:select> 
							</div>
						</div>
						<div class="form-group">
							<label for="province" class="col-md-3 control-label">Hobbies</label>
							<div class="col-md-9">
								
								<form:select path = "hobbies" multiple="true" 
									itemValue="id"  itemLabel="name" items="${hobbies}">
								</form:select> 
							</div>
						</div>
  
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>