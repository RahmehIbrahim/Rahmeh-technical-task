     function showSelectedCards(count){
       var selected_value ='';
       selected_value+='<input type="hidden" id="count" name = "count"  value=  "' +count+'"/>';
       $(digimon_table).append(selected_value);
       document.getElementById('show_form').submit();
    } 
    