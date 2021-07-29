<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  
  User: lonewol7f
  Date: 29/07/2021
  Time: 09:37
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Form</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="h3 text-center">Save Course</h3>
    <c:url var="saveLink" value="/teachers/courses/save">
        <c:param name="teacherId" value="${course.teacher.id}"/>
    </c:url>
    <div class="container border border-2 rounded-1" style="width: 60%; margin-top: 20px">
        <form:form action="${saveLink}" modelAttribute="course" method="post">
            <form:hidden path="id"/>

            <div class="mb-3" style="margin-top: 5px">
                <form:label path="name" cssClass="form-label">Course Name:</form:label>
                <form:input path="name" cssClass="form-control"/>
            </div>

            <button type="submit" class="btn btn-success">Save</button>

        </form:form>
    </div>
</div>
<div class="container">
    <c:url var="backToList" value="/teachers/courses">
        <c:param name="teacherId" value="${course.teacher.id}"/>
    </c:url>
    <p><a href="${backToList}">Back to course List</a></p>
</div>
</body>
</html>
