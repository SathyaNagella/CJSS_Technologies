<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<a  href="reg"> add more employee </a>
<br> <br> <br>

empId;
g  empName;
g empDesg;
g password;

<table border=1>
  <tr>
    <th>empId</th>
    <th>empName</th>
    <th>empDesg</th>
    <th>password</th>
  </tr>    

  <c:if test="${!empty empList}">
  
     <c:forEach  items="${empList}"  var="emp">
        <tr>
          <td> <c:out value="${emp.empId}"/> </td>
          <td> <c:out value="${emp.empName}"/> </td>
          <td> <c:out value="${emp.empDesg}"/> </td>
          <td> <c:out value="${emp.password}"/> </td>
        </tr>
     </c:forEach>
  </c:if>

</table>