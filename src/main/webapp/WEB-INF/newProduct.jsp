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
    <title>New Product</title>
</head>
<body class="bg-dark">
    <nav class="nav bg-light">
        <h1><a class="link" href="/">Home Page</a></h1>
    </nav>
    <div class="container w-50 mt-3">
        <div class="card bg-light">
            <div class="card-header">
                <h1>New Product</h1>
            </div>
            <div class="card-body">
                <form:form action="/products" method="post" modelAttribute="product">
                    <div class="mb-3">
                        <form:label class="form-label" path="name">Name</form:label>
                        <form:errors path="name"/>
                        <form:input class="form-control" path="name" type="text"/>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="price">Price</form:label>
                        <form:errors path="price"/>
                        <form:input type="text" class="form-control" path="price"/>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="description">Description</form:label>
                        <form:errors path="description"/>
                        <form:textarea class="form-control" path="description" type="text"/>
                    </div>
                    <div class="text-end">
                        <input class="btn btn-outline-dark shadow mt-2" type="submit" value="SUBMIT">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>