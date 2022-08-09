<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Hello World</title>
   </head>

   <body>
   welcome page &nbsp
   <h3> ${output}</h3>
      <h2>${name}</h2>
      <form method="post" action="/Book/nothing/testing">
      <input type="text" name="example1"/>
      <input type="submit" value="submit"/>
      </form>
   </body>
</html>