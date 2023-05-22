<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h3>List with All Employees</h3>

<br><br>
<security:authorize access="hasRole('STUDENT')">
<input type="button" value="Salary"
onclick="window.location.href='student_info'">
Only for Student
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href='manager_info'">
Only for Managers
</security:authorize>

</body>
</html>
