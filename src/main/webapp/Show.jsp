
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Digimon Card</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/> 
    <link rel="stylesheet" href="Show.css">
    <script type="text/javascript" src="Show.js"></script>
  </head>
    <body>
        <form action ="ModifyDigimonCard" method ="POST" id="selectDigimon_form">
           <center> <h1> Digimon Card </h1> </center>
           
         <div class = "container" id="digimon_table">
         <div class = "item"><img src = ${image} ></div>
         <div class = "item"> Name :<input class= "edit_class" type = "text" value = "${name}" name ="card_name" id ="card_name"><br/>Level :<input class="edit_class" type = "text" value = "${level}" id ="card_level"></div>
            </br></br> 
         <input class="btn btn-primary" type="button" name="update" id="update" value="Update" onclick ="UpdateCardValue('${name}');" />
            </br>
         <input class="btn btn-primary" type="button" name="delete" id="delete" value="Delete" onclick ="DeleteCard();" />
            
            </div>
           
        </form>
    </body>
</html>
