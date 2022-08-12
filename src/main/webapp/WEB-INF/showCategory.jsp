<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/js/bootstrap.min.js" defer></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript" src="/js/app.js" defer></script>
    <title>${category.name}</title>
</head>
<body class="bg-dark text-light">
    <nav class="nav bg-light px-3">
        <h1><a class="link" href="/">Home Page</a></h1>
    </nav>
    <div class="container text-center mt-5">
        <header>
            <h1>${category.name}</h1>
        </header>
        <div class="line"></div>
        <div class="container mt-5">
            <h3>Products</h3>
            <ul>
                <c:forEach var="product" items="${products}">
                    <li><a class="text-light link-white" href="/products/${product.id}">${product.name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="line"></div>
        <div class="container mt-5">
            <h3>Add Products</h3>
            <form action="/categories/${category.id}" method="post">
                <select class="form-control" name="product_id">
                    <option class="form-control" value="">------Select-----</option>
                    <c:forEach var="product" items="${notIncludedProducts}">
                        <option class="form-control" value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="SUBMIT">
            </form>
        </div>
    </div>
</body>
</html>