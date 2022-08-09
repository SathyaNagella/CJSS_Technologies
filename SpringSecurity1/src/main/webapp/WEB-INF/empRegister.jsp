<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>${message}</h2>
<form:form  action="saveEmployee"  method="post"  modelAttribute="employeeModel">
 <table>
   <tr>
     <td> empId </td> <td> <form:input path="empId"/> </td>
     <form:errors path="empId"/>
   </tr>
   <tr>
     <td> empName </td> <td> <form:input path="empName"/> </td>
     <td><form:errors path="empName"/></td>
   </tr>
   <tr>
     <td> empDesg </td> <td> <form:input path="empDesg"/> </td>
     <td><form:errors path="empDesg"/></td>
   </tr>
   <tr>
        <td> password </td> <td> <form:input path="password"/> </td>
        <td><form:errors path="password"/></td>
   </tr>
   <tr>
      <td  col span="2"> <input type="submit"  value="SUBMIT"> </td>
   </tr>
 </table>

</form:form>