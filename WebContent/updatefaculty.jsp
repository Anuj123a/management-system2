<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="UpdateFaculty" method="post">
       <table bgcolor="green">
        <tr>
       <td>
          <h3 align="center"> update Faculty</h3>
      </td>
      </tr>
       <tr>
       <td>
          F.Name<input type="text" name="F.name"></input>
      </td>
      </tr>
       <tr>
       <td>
    Course <select name="course">
      <option> </option>
  <option value="Java">Java</option>
  <option value="pHp">pHp</option>
  <option value="Dt">DT</option>
  <option value="pGp java">pGpjava</option>
</select>
      </td>
      </tr>
      
      <tr>
       <td>
              ID<input type="text" name="ID"></input>
      </td>
      </tr>
        <tr>
       <td>
              Mobile no.<input type="text" name="mobile"></input>
      </td>
      </tr>
        <tr>
       <td>
              Email<input type="text" name="Email"></input>
      </td>
      </tr>
        <tr>
       <td>
             Add<input type="text" name="Add"></input>
      </td>
      </tr>
        <tr>
       <td>
              <input type="submit" value="submit"></input>
      </td>
      </tr>
        
       </table>
       </form>
</body>
</html>