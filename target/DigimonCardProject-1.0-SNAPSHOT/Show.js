 function UpdateCardValue(originalName){
        var name = document.getElementById('card_name').value;
        var level = document.getElementById('card_level').value;
        var selected_value ='';
        
        selected_value+='<input type="hidden" id="name" name = "name"  value= "'+name+'"/>';
        selected_value+='<input type="hidden" id="level" name = "level"  value= "'+level+'"/>';
        selected_value+='<input type="hidden" id="originalName" name = "originalName"  value= "'+originalName+'"/>';

        $(digimon_table).append(selected_value);
        document.getElementById('selectDigimon_form').submit();
    }
    
    function DeleteCard(){
        
        var name = document.getElementById('card_name').value;
        var selected_value ='';
        selected_value+='<input type="hidden" id="name" name = "name"  value=  "' +name+'"/>';
        $(digimon_table).append(selected_value);
        document.getElementById('selectDigimon_form').submit();
    }
    