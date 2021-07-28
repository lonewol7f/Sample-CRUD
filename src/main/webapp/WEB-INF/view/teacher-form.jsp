<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  
  User: lonewol7f
  Date: 28/07/2021
  Time: 18:54
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Form</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="text-center">
    <div>
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div class="container">
    <h3 class="h3 text-center">Save Customer</h3>
    <div class="container border border-2 rounded-1" style="width: 60%; margin-top: 20px">
        <form:form action="save" modelAttribute="teacher" method="post">
            <form:hidden path="id"/>

            <div class="mb-3" style="margin-top: 5px">
                <form:label path="firstName" cssClass="form-label">First Name:</form:label>
                <form:input path="firstName" cssClass="form-control"/>
            </div>

            <div class="mb-3">
                <form:label path="lastName" cssClass="form-label">Last Name:</form:label>
                <form:input path="lastName" cssClass="form-control"/>
            </div>

            <div class="mb-3">
                <form:label path="email" cssClass="form-label">Email:</form:label>
                <form:input path="email" cssClass="form-control"/>
            </div>

            <button type="submit" class="btn btn-success">Save</button>

        </form:form>
    </div>
</div>
<div class="container">
    <p><a href="${pageContext.request.contextPath}/teachers/list">Back to List</a> </p>
</div>

</body>
</html>
