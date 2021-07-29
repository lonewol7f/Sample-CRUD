<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  
  User: lonewol7f
  Date: 29/07/2021
  Time: 09:07
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses List</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="mt-5 mb-5">

        <c:url var="addCourseLink" value="/teachers/courses/addCourse">
            <c:param name="teacherId" value="${teacherId}"/>
        </c:url>
        <%-- put new button: add course --%>
        <a href="${addCourseLink}" style="text-decoration: none; color: white"><button class="btn btn-primary">Add Course</button></a>
    </div>
    <div style="display: flex; justify-content: center">
        <c:if test="${fn:length(courses) > 0}">
            <table class="table table-hover">
                <thead class="table-primary">
                <th>Course Id</th>
                <th>Course Name</th>
                <th>Action</th>
                </thead>


                    <%-- Loop over and print teachers --%>
                <c:forEach var="tempCourse" items="${courses}">

                    <%-- construct an 'update' link with teacher id --%>
                    <c:url var="updateLink" value="/teachers/courses/update">
                        <c:param name="courseId" value="${tempCourse.id}"/>
                    </c:url>

                    <%-- construct an 'delete' link with teacher id --%>
                    <c:url var="deleteLink" value="/teachers/courses/delete">
                        <c:param name="courseId" value="${tempCourse.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCourse.id}</td>
                        <td>${tempCourse.name}</td>
                        <td>
                                <%-- display the update link --%>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure, You want to delete this course?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${fn:length(courses) == 0}">
            <div class="text-center border border-2 rounded"
                 style="padding: 50px; font-family: 'Ubuntu Mono'; font-size: 50px; width: fit-content">
                <p>Nothing to show</p>
            </div>
        </c:if>
    </div>
    <div class="container">
        <c:url var="backToTeachers" value="/teachers/list" />
        <p><a href="${backToTeachers}">Back to Teacher List</a></p>
    </div>
</div>
</body>
</html>
