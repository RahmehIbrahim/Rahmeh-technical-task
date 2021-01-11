<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String connectionUrl = "jdbc:derby://localhost:1527/DigimonDB";
String userid = "root";
String password = "root";

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
     <head>
        
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Digimon Cards</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/> 
    <link rel="stylesheet" href="FavouriteCards.css">
    <script type="text/javascript" src="FavouriteCards.js"></script>
   
  </head>
<body>
    <form action ="ShowDigimonCard" method ="POST" id="show_form">
        <center> <h1> Favourite Cards List</h1> </center>

<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from FAV_DIGIMON_TABLE";
resultSet = statement.executeQuery(sql);
int count=0;
while(resultSet.next()){
    
%>

 <div class = "container" id="digimon_table">
         <div class = "item"><img src = <%=resultSet.getString("IMAGE") %>/></div>
         <div class = "item"> Name :<%=resultSet.getString("NAME") %><br/>Level :<%=resultSet.getString("LEVEL") %>
            </br></br> 
            <input class="btn btn-primary" type="button" name="<%=count%>" id="<%=count%>" value="Show" onclick ="showSelectedCards(<%=count%>);" /></div>
          <input  type="hidden" name ="img_<%=count%>" id="img_<%=count%>" value=<%=resultSet.getString("IMAGE") %>></div>
          <input  type="hidden" name ="name_<%=count%>" id="name_<%=count%>" value=<%=resultSet.getString("NAME") %>></div>
          <input  type="hidden" name ="level_<%=count%>" id="level_<%=count%>" value = "<%=resultSet.getString("LEVEL") %>"></div>
          <input  type="hidden" name ="count" id="count" value=<%=count%> /></div>

</div>

<%
    count++;
}

connection.close();
} catch (Exception e) {
System.out.println("There is an Error!");
}
%>
<div><a  class="btn btn-primary back"  href="Home.jsp">Back>></a></div> 

</form>
</body>
</html>
