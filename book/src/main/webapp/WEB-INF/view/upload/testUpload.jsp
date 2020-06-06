<%@page pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form method="post" action="upload" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>Pick file #1:</td>
            <td><input type="file" name="fileUpload" size="50" /></td>
        </tr>
        <tr>
            <td>Pick file #2:</td>
            <td><input type="file" name="fileUpload" size="50" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
        </tr>
    </table>
</form>

</body>
</html>