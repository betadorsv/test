<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/slideshow.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
   <style>
       .footer {
           background-color: #222;
           color: rgb(255, 187, 0);
           font-size: 14px;
           bottom: 0;

           left: 0;
           right: 0;
           text-align: center;
           z-index: 999;
       }

       .footer p {
           margin: 10px 0;
       }
   </style>
    <script type="text/javascript">
        $(window).on('scroll', function() {
            if ($(window).scrollTop()) {
                $('nav').addClass('black');
            } else {
                $('nav').removeClass('black');
            }
        })
    </script>
    <title>Storri</title>

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
            <c:if test="${user != null}">
                    <c:if test="${user.roles.equals('admin')}">
                <div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    ${user.user_name}
  </a>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/managerBook">ManagerBook</a>
                    <a class="dropdown-item" href="#">Logout</a>
                </div>
            </div>
                    </c:if>
                <c:if test="${user.roles.equals('user')}">
                <div class="dropdown">
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ${user.user_name}
             </a>
              <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">

                    <a class="dropdown-item" href="#">Logout</a>
                </div>
            </div>
                </c:if>

            </c:if>
              <c:if test="${user == null}">
            <a style="text-decoration: none; color: #ffffff" href="${pageContext.request.contextPath}/login">LOGIN</a>
              </c:if>
                </span>
        </li>
        </ul>

    </div>

</nav>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="img/1.png" alt="Second slide">

        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="img/2.png" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="img/3.png" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>



<div class="container" style="
    background-color: #0d0d0d;">

    <h3>Tất cả sách</h3>
    <div class="row row-cols-6">
        <c:forEach var="bk" items="${books}">

            <c:url var="booklink" value="/showbook">
                <c:param name="BookId" value="${bk.idBook}"/>
            </c:url>

        <div class="col">
            <div class="colu">
            <div class="image">
                <img src="/FileUpload/image/${bk.bookCover}" class="w-100" alt="${bk.bookCover}">
            </div>
            <div class="detail">

                <a href="${booklink}">
                    <h2>${bk.title}</h2>
                </a>
                <span class="badge badge-warning">${bk.m_type.name_type}</span>
                <p></p>
                <p>${bk.describe}</p>
            </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
<footer class="footer">
    <p>
        <br>
    <strong>Trần Trí Viễn </strong>
        <br>
       <strong>N17DCAT076 </strong>
        <br>

    </p>
</footer>


</body>
</html>