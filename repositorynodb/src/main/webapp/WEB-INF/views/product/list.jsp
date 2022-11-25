
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Listing product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body>
    <h1>Products</h1>
    <p><a href="new">Add new product</a></p>
    <p>There are ${products.size()} products in this list.</p>
    <table border="1">
        <tr>
            <td>Code</td>
            <td>Name</td>
            <td>Name</td>
            <td>Price</td>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.getId()}</td>
                <td><a href="view?id=${product.getId()}"> ${product.getName()}</a></td>
                 <td><a href="viewpathvariable/${product.getId()}"> ${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td><a href="edit?id=${product.getId()}">Edit</a></td>
                <td><a href="delete?id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    
    
    
    <script type="text/javascript" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
