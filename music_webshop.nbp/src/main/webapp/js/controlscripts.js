
$(document).ready(function(){
   
    $('#btnNext').click(product.next);
    $('#btnPrev').click(product.prev);
    $("#dialog #btnAdd").live("click", product.add);
    $("#dialog #btnDel").live("click", product.del);
    $("#dialog #btnEdit").live("click", product.edit);
    
    $('#btnAdd').click(productView.showAddDialog);
    $('#btnEdit').live('click', productView.showEditDialog);
    $('#btnDel').live('click', productView.showDelDialog);
    $('#btnCancel').live('click', productView.hideDialog);
    // Populate table for the first time
    product.find();
})

var product = function (){
    
    // Privates
    var first = 1;
    var max = 3;
    var count = 10; 
    
    // Public interface  
    return { 
        prev : function(){
            if( first >= max){
                first -= max;
            }
            product.find();
        },
        
        next : function(){
            if( count >= 3){
                first += max;
            }
            product.find();     
        },
              
        find : function(){
        // TODO Hur fungerar count?
         
        //var command = 'first=' + this.first + '&max=' + this.max;
        var command = 'first=' + 1 +'&max=' +10;
        
            $.ajax({
            type: "GET",
            url: 'ProductServlet?action=find',
            data: command,
            dataType: "xml",
            success: function(xml) {

                    productView.showProductTable($(xml).find('product'));

            },
            error: function(xhr, textStatus, errorThrown) {
                alert('An error occurred! ' + ( errorThrown ? errorThrown :
                    xhr.status + textStatus));
            }
        })


        },
     
        edit: function(){ 
            var p = productView.getProductFromDialog();
            productView.hideDialog();

            var prod = 'id=' + p.id + '&name=' + p.name + '&cat=' + p.cat + '&price=' + p.price;
            
            $.ajax({
                type: "POST",
                url: 'ProductServlet?action=edit',
                data: prod,
                success: function(xml) {
                    product.find();
                }
            })  
        
        },
        
        del : function (){
            var p = productView.getProductFromDialog();
            productView.hideDialog();
            
            
            var person = 'id=' + p.id + '&name=' + p.name + '&cat=' + p.cat + '&price=' + p.price;
            
            $.ajax({
                type: "POST",
                url: 'ProductServlet?action=del',
                data: person,
                success: function(xml) {
                    product.find();
                
                }
            })
            
        },
        
        add : function(){
            var p = productView.getProductFromDialog();
            productView.hideDialog();
            var person = 'id=' + p.id + '&name=' + p.name + '&cat=' + p.cat + '&price=' + p.price;
            
            $.ajax({
                type: "POST",
                url: 'ProductServlet?action=add',
                data: person,
                success: function(xml) {
                    product.find();
                }
            })  
        }
        
    } 
}(); 

// All visual handling 
var productView = function(){
     
    // Public interface 
    return {
        showEditDialog: function(){
            var p = getTableRow(this);
            $("#dialog").children().remove();
            createTable(p.id, p.name, p.cat, p.price).appendTo("#dialog"); 
            $("<input id='btnEdit' type='button' value='Save'/>").appendTo("#dialog");
            showPopUp();
        },
        
        showAddDialog: function(){
            $("#dialog").children().remove();
            createTable("", "", "", "").appendTo("#dialog"); 
            $("<input id='btnAdd' type='button' value='Add'/>").appendTo("#dialog");
            showPopUp();
        },
        
        showDelDialog: function(){
            var p = getTableRow(this);
            $("#dialog").children().remove();
            createTable(p.id, p.name, p.cat, p.price).appendTo("#dialog"); 
            $("#dialog input").attr("disabled", "true");
            $("<input id='btnDel' type='button' value='Delete'/>").appendTo("#dialog");
            showPopUp();
        },
        
        showProductTable: function(product){
            $('#productTableBody tr').remove();
            product.each( function(){
                var id = $(this).find('id').text();
                var name = $(this).find('productTitle').text();
                var cat = $(this).find('productCategory').text();
                var price = $(this).find('price').text();             
                var row = "<tr id='" + id + "'><td>" + id + "</td><td>" + name  + 
                "</td><td>" + cat + "</td><td>" + price + 
                "</td><input id='btnEdit' type='button' value='Edit'/>" + 
                "<input id='btnDel' type='button' value='Del'/>" +
                "</tr>"
                $(row).appendTo("#productTableBody");
            })
        },
    
        hideDialog: function() {
            $("#dialog").animate({
                height:  0,
                width: 0
            }, 'slow').children().remove(); 
        },
        
        getProductFromDialog: function(){
            return {
                id : $("#dialog #id").text(),
                name : $("#dialog #txtName").val(),
                cat : $("#dialog #txtCat").val(),
                price : $("#dialog #txtPrice").val()
            }  
        }
    }  
    
    /*
     *  Private function
     */ 
    function createTable(id, name, cat, price){
        var idRow = "<tr><td>Id</td><td id='id'>" + id + "</td></tr>";
        var nameRow = "<tr><td>Name</td><td><input id='txtName' type='text' value='" + name + "' size='10'/></td></tr>";
        var catRow = "<tr><td>Category</td><td><input id='txtCat' type='text' value='" + cat + "' size='10'/></td></tr>";
        var priceRow = "<tr><td>Price</td><td><input id='txtPrice' type='text' value='" + price + "' size='6'/></td></tr>";  
        return $("<table>"+ idRow + nameRow + catRow + priceRow + "</table>");        
    }
    
    function getTableRow( button ){
        var siblings = $(button).siblings();
        return {
            id: $(siblings[0]).text(),
            name: $(siblings[1]).text(),
            cat : $(siblings[2]).text(),
            price : $(siblings[3]).text()
        }
    }
    
    function showPopUp() {
        $("<input id='btnCancel' type='button' value='Cancel'/>").appendTo("#dialog");
                  
        var windowWidth = document.documentElement.clientWidth;  
        var windowHeight = document.documentElement.clientHeight;  
        var popupHeight = 5; //$("#popupContact").height();  
        var popupWidth = 200; //$("#popupContact").width();  
        //centering  
    
        $("#dialog").css({ 
            "opacity": "0.8",  
            "position": "absolute", 
            "height": popupHeight,
            "width" : popupWidth,
            "top": windowHeight/2-popupHeight/2,  
            "left": windowWidth/2-popupWidth/2,  
            "z-index": "2",
            "background": "lightgray",
            "border": "2px solid black"  
        }).animate({
            height:  180
        }, 'slow'); 
    }
}();