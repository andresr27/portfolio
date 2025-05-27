function validate() {
	var subject = document.getElementById("subject");
	var mail = document.getElementById("email");
	var msg = document.getElementById("email_message");
	if (msg == null || msg.value == "" || mail.value == "" || mail.value == "") {
		var error = document.getElementById("form_error_msg");
		error.innerHTML = "Please enter all of the required fields";
		var instruct = document.getElementById("form_msg");
		instruct.style.visibility = "visible";
		return false;
	}
	else {
		//alert("msg valid");
	}

	var vm = validateEmail();
	if (!vm) {
		var error = document.getElementById("form_error_msg");
		error.innerHTML = "The email your entered is not valid";
		var instruct = document.getElementById("form_msg");
		instruct.style.visibility = "visible";
		return false;
	}
	
	return true;
}

function buildHtmlTable(selector, boxesJson) {
        // Set the global stuff
        $('#boxesCount').html(boxesJson.length);



    var onlineCount = 0;
    var warningCount = 0;
    for (var i = 0 ; i < boxesJson.length ; i++) {
        tr = $('<tr data-product-id="' + boxesJson[i].id + '" class="sui-alt-row"/>');
        tr.append("<td class=\"sui-cell\">" + boxesJson[i].id + "</td>");
        tr.append("<td class=\"sui-cell\">" + boxesJson[i].name + "</td>");
        tr.append("<td class=\"sui-cell\">" + boxesJson[i].locationName + "</td>");
        tr.append("<td class=\"sui-cell\">" + boxesJson[i].money + "  </td>");
        tr.append("<td class=\"sui-cell\">" + boxesJson[i].status + "</td>");
	tr.append("<td class=\"sui-cell\">" + boxesJson[i].lastUpdated + "</td>");
        //tr.append("<td class=\"sui-cell\">" + boxesJson[i].lastUpdated.dayOfMonth +"/"+boxesJson[i].lastUpdated.month+"/"+boxesJson[i].lastUpdated.year+" "+boxesJson[i].lastUpdated.hourOfDay+":"+boxesJson[i].lastUpdated.minute+"</td>");
//      tr.append("<td class=\"sui-cell\">" + boxesJson[i].ipAddress + "</td>");
        $(selector).append(tr);

        if(boxesJson[i].status == "OK") {
            onlineCount++;
        }
        if(boxesJson[i].status == "WARN") {
                    warningCount++;
        }
    }

    $('#boxesOnlinePercentage').html(onlineCount + "/" + boxesJson.length);
    $('#boxesAlarmCounter').html(warningCount);



    // FIXME body on click
   $("table#mainTable tr").click(function() {
        var $tr = $(this);
        var id = $tr.data("product-id");
                var box = boxesJson.find(function(item){
                    return item.id == id;
                })
                buildDetailTable(box)

                $('.confirm-delete').on('click', function(e) {
                    e.preventDefault();
                    var id = $(this).data('id');
                    $('#myModal').data('id', id).modal('show');
                });


                $('#myModal').on('show.bs.modal', function() {
                    var pId = $('.confirm-delete').data('id');
                    var pName = $('.confirm-delete').data('name');
                    var boxId = $('.confirm-delete').data('box_id');
                    console.log("setting modal data");
                    $('#myModal .modal-body p').html("Seguro que desea despachar un producto:" + '<b>' + pName +'</b>' + ' del box:' + boxId +  ' ?');
                    removeBtn = $(this).find('.danger');

                    sendDispatchMessage(boxId, pId);
                });



                $('#btnYes').click(function() {
                    // handle deletion here
//                    var id = $('#myModal').data('id');
//                    $('[data-id='+id+']').parents('tr').remove();
                    $('#myModal').modal('hide');

                });

        $('html, body').animate({
                scrollTop: $("#mainTable").offset().top
            }, 500);
       });


}

function buildDetailTable(box) {
     $('#boxId').html(box.id);
     $('#boxName').html(box.name);
     $('#locationName').html(box.locationName);
     $('#ipAddress').html(box.ipAddress);
     $('#boxType').html(box.boxType);


     if(box.name.indexOf("LadySoft")> -1) {
        $("#boxImage").attr("src","images/ladysoft.jpg");
     }
     else if(box.name.indexOf("Usalo")> -1) {
        $("#boxImage").attr("src","images/usalo.jpg");
     }
     else if(box.name.indexOf("Club")> -1) {
             $("#boxImage").attr("src","images/clubsocial.jpg");
          }
     else {
        $("#boxImage").attr("src","images/zara.jpg");
     }

    var products = box.productList;


    $('#productNumber').html(products.length);

    buildProductsTable(box.id, products);

  }

  function buildProductsTable(boxId, productList) {
      $("#productTable tr").remove();

      for (var i = 0 ; i < productList.length ; i++) {
          tr = $('<tr class=""/>');
          tr.append("<td class=\"sui-cell\">" + productList[i].productId + "</td>");
          tr.append("<td class=\"sui-cell\">" + productList[i].productName + "</td>");
          tr.append("<td class=\"sui-cell\">" + productList[i].productDesc + "</td>");
          tr.append("<td class=\"sui-cell\">" + productList[i].productPrice + "</td>");
          tr.append("<td class=\"sui-cell\">" + productList[i].productStock + "</td>");
          tr.append("<td class=\"sui-cell\"> <a href=\"#\" class=\"confirm-delete btn mini red-stripe\" role=\"button\" data-box_id=\"" + boxId + "\" data-name=\"" + productList[i].productName + "\" data-id=\""+ productList[i].productId + "\">Despachar</a>"
          + "</td>");
          $("#productTable").append(tr);
      }
  }



function validateTel() {
	var x = document.getElementById("telefono").value;
	var test = Number(x);
	if (isNaN(test)) { 
		return false;
	} else {
		return true;
	}
}

function validateEmail() {
	var x = document.getElementById("email").value;
	var atpos= x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
		return false;
	} else {
		return true;
	}
}

