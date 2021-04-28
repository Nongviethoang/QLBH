
function addToCart(idSp,soLuong) {
   		var data = {};
		data["idSp"] = idSp;
		data["soLuong"]=soLuong
   		//data["idSp"] = productId;
   		$.ajax({
   			url : "/cart/add",
   			type : "post",
   			contentType : "application/json",
   			data : JSON.stringify(data),

   			dataType : "json",
   			success : function(jsonResult) {
   				$("#totalItemsInCart").html(jsonResult.data),
   				alert("Đã thêm 1 sản phẩm vào giỏ hàng!")
   				
   			},
   			error : function(jqXhr, textStatus, errorMessage) { // error callback 

   			}
   		});
   	
     }