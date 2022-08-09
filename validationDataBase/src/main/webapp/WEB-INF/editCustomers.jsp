<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

<form:form  action="updateCustomer"  method="post"  modelAttribute="cusModel">
    <form:errors/>
     <table>
           <tr>
             <td> cusId </td> <td> <form:input path="cusId"  readonly="true"/> </td>
           </tr>
           <tr>
             <td> cusFirstName </td> <td> <form:input path="cusFirstName"/> </td>
           </tr>
           <tr>
             <td> cusLastName </td> <td> <form:input path="cusLastName"/> </td>
           </tr>
           <tr>
             <td> cusEmail </td> <td> <form:input path="cusEmail"/> </td>
           </tr>
           <tr>
                <td> cusMobileNo </td> <td> <form:input path="cusMobileNo"/> </td>
           </tr>
           <tr>
                   <td> cusCity </td> <td> <form:input path="cusCity"/> </td>
           </tr>
           <tr>
              <td  colspan="2"> <input type="submit"  value="SUBMIT"> </td>
           </tr>
     </table>
</form:form>
