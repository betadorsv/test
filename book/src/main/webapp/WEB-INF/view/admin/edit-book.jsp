<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/upload.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Storri</title>
</head>

<body style="background: #111111">
<div class="nav-bar">
    <a class="logo" href="${pageContext.request.contextPath}/list-book"><img src="img/header_logo.png" alt="Stori" style="width:200px;height:40px"></a>
    <nav>
        <ul class="box-search">
            <li><input class="input-search" type="text" placeholder="Search..."></li>
            <li><a class="btn-search" href="#"><i class="fa fa-search"></i></a></li>
        </ul>
    </nav>
    <span>
    <a class="btn-upload" href="#"><button><i class="fa fa-upload" aria-hidden="true"></i></button></a>
    <a class="btn-login" href="login.html"><button>LOGIN</button></a>
        </span>
</div>
<div class="upload">
    <form:form action="/Update-Book" modelAttribute="books" method="POST" enctype="multipart/form-data">
        <form:hidden path="idBook"/>
        <ul class="form_upload">
            <li>
                <div class="name">
                    <p>Title</p>
                    <form:input  path="title" type="text" name="title"></form:input>
                </div>
            </li>
            <li>

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Author</label>

                    <select name="id_author" class="form-control" id="exampleFormControlSelect1">
                        <c:forEach var="author" items="${authors}">
                            <c:if test="${author.idAuthor==books.m_author.idAuthor}">
                                <option selected class="item" value="${author.idAuthor}">${author.author}</option>
                            </c:if>

                            <c:if test="${author.idAuthor != books.m_author.idAuthor}">
                                <option
                                        class="item" value="${author.idAuthor}">${author.author}</option>
                            </c:if>

                        </c:forEach>
                    </select>
                </div>

            </li>
            <li>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Type</label>

                    <select name="id_type" class="form-control" id="exampleFormControlSelect">
                        <c:forEach var="type" items="${types}">
                            <c:if test="${type.idType==books.m_type.idType}">
                                <option selected class="item" value="${type.idType}">${type.name_type}</option>
                            </c:if>

                            <c:if test="${type.idType != books.m_type.idType}">
                                <option
                                        class="item" value="${type.idType}">${type.name_type}</option>
                            </c:if>

                        </c:forEach>
                    </select>

                </div>
            <li>

            <li>

            <form:input  path="bookCover" type="hidden" value="${books.bookCover}"></form:input>

            <div class="custom-file">
                <p>Book Cover</p>
                <input type="file" class="custom-file-input" id="customFile" name="photo_file">
                <label class="custom-file-label" for="customFile">Choose Book Cover</label>
            </div>


            </li>
            <li>
                <form:input path="bookContent" type="hidden" value="${books.bookContent}" ></form:input>

                    <div class="custom-file">
                        <p>File Content</p>
                        <input type="file" class="custom-file-input" id="customFile1" name="content_file">
                        <label class="custom-file-label" for="customFile1">Choose Content File</label>
                    </div>



            </li>
            <li>
                <div class="description">
                    <p>Description</p>
                    <Form:textarea  path="describe"></Form:textarea>
                </div>
            </li>

            <li>
                <div class="submit">
                    <button type="submit"><i class="fa fa-upload" > UPLOAD</i></button>
                </div>
            </li>



        </ul>


    </form:form>

</div>

<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</body>
</html>
