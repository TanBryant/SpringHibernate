<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<%@ page isELIgnored="false"%>
 
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-12">
   <h3 class="text-center">
  	Nguyen Nhat Tan - CNTT-K18
	</h3>
   <hr />

   <input type="button" value="Add Product"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" /> <br />
   <br />
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Product List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Product Name</th>
       <th>Decription</th> 
       <th>Category</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our Products -->
      <c:forEach var="tempProduct" items="${products}">

       <!-- construct an "update" link with Product id -->
       <c:url var="updateLink" value="/product/updateForm">
        <c:param name="productId" value="${tempProduct.id}" />
       </c:url>

       <!-- construct an "delete" link with Product id -->
       <c:url var="deleteLink" value="/product/delete">
        <c:param name="productId" value="${tempProduct.id}" />
       </c:url>

       <tr>
        <td>${tempProduct.productName}</td>
        <td>${tempProduct.decription}</td> 
		<td>${tempProduct.category.categoryName}</td>
        <td style="style="width:200px;"">
          	<a class="btn btn-primary" style="width:40%;" href="${updateLink}">Update</a>
         	<a class="btn btn-danger" style="width:40%;" href="${deleteLink}" 
         	onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false">
         	Delete
         	</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <div class="footer">
 
 </div>
</body>

</html>