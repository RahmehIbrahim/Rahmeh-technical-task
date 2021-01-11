 $(document).ready(function(){
        $.getJSON('https://digimon-api.herokuapp.com/api/digimon',function(data){
            var digimon_data ='';
            var counter = 0;

            $.each(data,function(key,value){
                digimon_data +='<div class = "item">'+'<img src = '+ value.img + '>'+ '</div>';
                digimon_data +='<div class = "item">'+" Name : " +value.name+'<br/>'+" Level :"+value.level+ 
                        '</br></br>' + '<input class="btn btn-primary" type="button" value="Add To Favourite" onclick = "getSelectedCards('+counter+')" name = "'+counter+'"/>'+'</div>' ;
                digimon_data +='<input type="hidden"  value = "' + value.img + ' " id=  "img_' + counter + '"name= "img_' + counter +'"/>';
                digimon_data +='<input type="hidden"  value = "' + value.name+ ' " id=  "name_' + counter + '"name= "name_' + counter +'"/>';
                digimon_data +='<input type="hidden"  value = "' + value.level+ ' " id=  "level_' + counter + '"name= "level_' + counter +'"/>';
                counter ++;

    });
            $(digimon_table).append(digimon_data);
        });
    });
    
    
    function getSelectedCards(count){
      var selected_value ='';
      selected_value+='<input type="hidden" id="count" name = "count"  value=  "' +count+'"/>';
       $(digimon_table).append(selected_value);
       document.getElementById('digimon_form').submit();

    }