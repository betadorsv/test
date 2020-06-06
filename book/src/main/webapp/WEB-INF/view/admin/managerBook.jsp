<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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

    <title>Administration Manager</title>
</head>
<body>
<div class="nav-bar">
    <a class="logo" href="${pageContext.request.contextPath}/list-book"><img src="img/header_logo.png" alt="Stori" style="width:200px;height:40px"></a>
    <nav>
        <ul class="box-search">
            <li><input class="input-search" type="text" placeholder="Search..."></li>
            <li><a class="btn-search" href="#"><i class="fa fa-search"></i></a></li>
        </ul>
    </nav>
    <span>

        </span>
</div>

<div class="container" style="padding: 20px ">
    <h2 style="color: white;"> Books Manager</h2>
    <p>Add, edit, delete book</p>
    <input type="button" value="Add Book" onclick="window.location.href='showFormForAdd';return false;" class="btn btn-success" style="margin-bottom: 20px;" />
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Type</th>
            <th>Author</th>

            <th>Cover</th>
            <th>Content</th>
            <th>Describe</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="bk" items="${books}">
        <tbody>

                <!--Update-->
                <c:url var="updatelink" value="/showFormForUpdate">
                <c:param name="BookId" value="${bk.idBook}"/>
                </c:url>

                <!--Delete-->
                <c:url var="deletelink" value="/DeleteBook">
                    <c:param name="BookId" value="${bk.idBook}"/>
                </c:url>
        <tr>
            <td>${bk.idBook}</td>
            <td>${bk.title}</td>
            <td>${bk.m_type.name_type}</td>
            <td>${bk.m_author.author}</td>
            <td><img src="/FileUpload/image/${bk.bookCover}" alt="${bk.bookCover}" style="width:60px;height:100px"></td>
            <td>${bk.bookContent}</td>
            <td>${bk.describe}</td>
            <td><span style="display: inline-block"><a href="${updatelink}"><button type="button" class="btn btn-outline-warning">Edit</button></a>
            </span></td>
            <th><a href="${deletelink}"
            onclick="if(!(confirm('Bạn có Chắn chắn muốn xóa sách này?'))) return false"
            ><button type="button" class="btn btn-outline-danger">Delete</button></a></th>
        </tr>

        </tbody>
        </c:forEach>
    </table>
</div>

</body>
</html>