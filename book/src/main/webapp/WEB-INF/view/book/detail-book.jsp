<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/list-book.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .container {
            margin-top: 20px;
            background-color: #0d0d0d;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>${books.title}</title>

</head>
<body style="background-color: #111111;">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="  transition: .5s;">
    <div class="container">

        <a class="logo" href="${pageContext.request.contextPath}/list-book"><img id="logobetran" src="img/header_logo.png" alt="Stori" alt="Stori"></a>


        <ul class="box-search">
            <li><input class="input-search" type="text" placeholder="Search..."></li>
            <li><a class="btn-search" href="#"><i class="fa fa-search"></i></a></li>
        </ul>

        <span class="login_link">
            <a style="text-decoration: none; color: #ffffff" href="${pageContext.request.contextPath}/login">LOGIN</a>
                </span>
        </li>
        </ul>

    </div>

</nav>

<div class="container">
    <iframe src="/FileUpload/content/${books.bookContent}" style="width:1100px; height:1000px;" frameborder="0"></iframe>
</div>


</body>
</html>