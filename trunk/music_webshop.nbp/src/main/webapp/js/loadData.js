/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
    
    $('#pop').live("click" , function(){
        $.ajax({
            url: "cs?action=findGenre&genre=pop",
            cache: false,
            datatype: "xml",
            success: function(xml){
//                $("#productTableBody").empty();
//                $("#productTableBody").append(xml);
            }
        });
    });
    $('#rock').live("click" , function(){
        $.ajax({
            url: "cs?action=findGenre&genre=rock",
            cache: false,
            success: function(html){
                $("#productTableBody").empty();
                $("#productTableBody").append(html);
            }
        });
    });
    $('#metal').live("click" , function(){
        $.ajax({
            url: "cs?action=findGenre&genre=metal",
            cache: false,
            success: function(html){
                $("#productTableBody").empty();
                $("#productTableBody").append(html);
            }
        });
    });
    $('#jazz').live("click" , function(){
        $.ajax({
            url: "cs?action=findGenre&genre=jazz",
            cache: false,
            success: function(html){
                $("#productTableBody").empty();
                $("#productTableBody").append(html);
            }
        });
    });
    
    
})