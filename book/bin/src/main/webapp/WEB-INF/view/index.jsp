<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Storri</title>
</head>

<body>
<div class="nav-bar">
    <a class="logo" href="index.html"><img src="img/header_logo.png" alt="Stori" style="width:200px;height:40px"></a>
    <nav>
        <ul class="box-search">
            <li><input class="input-search" type="text" placeholder="Search..."></li>
            <li><a class="btn-search" href="#"><i class="fa fa-search"></i></a></li>
        </ul>
    </nav>
    <span>
    <a class="btn-upload" href="href=${pageContext.request.contextPath}/upload"><button><i class="fa fa-upload" aria-hidden="true"></i></button></a>
    <a class="btn-login" href="login.html"><button>LOGIN</button></a>
        </span>
</div>
<div class="books-card">
    <ul class="list-book">
        <li>
            <div class="book-card">
                <div class="cover"><img src="img/coverbooks/dac-nhan-tam.jpg"></div>
                <div class="details">
                    <h2>Đắc Nhân Tâm <br><span>Dale Carnegie</span></h2>
                    <div class="tags">
                            <span class="self-help">SELF-HELP<span>
                    </div>
                    <div class="info">
                        <p>Đắc nhân tâm của Dale Carnegie là quyển sách duy nhất về thể loại self-help liên tục đứng đầu danh mục sách bán chạy nhất (best-selling Books) do báo The New York Times bình chọn suốt 10 năm liền.
                        </p>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</div>

</body>

</html>