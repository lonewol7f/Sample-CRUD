<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  
  User: lonewol7f
  Date: 28/07/2021
  Time: 18:44
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher List</title>
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
        <h2>Teachers List</h2>
    </div>
</div>

<div class="container">
    <div class="mt-5 mb-5">
        <%-- put new button: add customer --%>
        <input type="button" value="Add Teacher" onclick="window.location.href='addForm'; return false;"
               class="btn btn-primary"/>
    </div>
    <div style="display: flex; justify-content: center">
        <c:if test="${fn:length(teachers) > 0}">
            <table class="table table-hover">
                <thead class="table-primary">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Name</th>
                <th>Action</th>
                </thead>


                    <%-- Loop over and print customers --%>
                <c:forEach var="tempTeacher" items="${teachers}">

                    <%-- construct an 'update' link with xustomer id --%>
                    <c:url var="updateLink" value="/teachers/update">
                        <c:param name="teacherId" value="${tempTeacher.id}"/>
                    </c:url>

                    <%-- construct an 'delete' link with xustomer id --%>
                    <c:url var="deleteLink" value="/teachers/delete">
                        <c:param name="teacherId" value="${tempTeacher.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempTeacher.firstName}</td>
                        <td>${tempTeacher.lastName}</td>
                        <td>${tempTeacher.email}</td>
                        <td>
                                <%-- display the update link --%>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure, You want to delete this customer?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${fn:length(teachers) == 0}">
            <div class="text-center border border-2 rounded" style="padding: 50px; font-family: 'Ubuntu Mono'; font-size: 50px; width: fit-content">
                <p>Nothing to show</p>
            </div>
        </c:if>
    </div>
</div>

</body>
</html>
