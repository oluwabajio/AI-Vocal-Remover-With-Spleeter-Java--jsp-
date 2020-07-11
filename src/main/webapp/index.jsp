<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 11/07/2020
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
  Select File to Upload:<input type="file" name="fileName">
  <br>
  <input type="submit" value="Upload">
</form>
</body>
</html>