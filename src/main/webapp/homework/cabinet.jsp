<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Lesson-18</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <p>Hello ${pageContext.request.remoteUser}</p>
    <a href="/adminMode">AdminMode</a>
</body>
</html>