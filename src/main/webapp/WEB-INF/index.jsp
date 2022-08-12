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
    <title>Products and Categories</title>
</head>
<body class="bg-dark">
    <nav class="nav justify-content-between bg-light px-3">
        <h1><a class="link" href="/">Home Page</a></h1>
        <div class="my-auto gap-3 d-flex">
            <a class="link" href="/products">new products</a>
            <a class="link" href="/categories">new categories</a>
        </div>
    </nav>
    <div class="container mt-3">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <h3>Products</h3>
                    </div>
                    <div class="card-body">
                        <ul>
                            <c:forEach var="product" items="${products}">
                                <li><a class="link" href="/products/${product.id}">${product.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <h3>Categories</h3>
                    </div>
                    <div class="card-body">
                        <ul>
                            <c:forEach var="category" items="${categories}">
                                <li><a class="link" href="/categories/${category.id}">${category.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>