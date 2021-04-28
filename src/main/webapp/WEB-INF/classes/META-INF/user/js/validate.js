
function checkPassword() {  
  var password = document.getElementById("password").value;   
  var repassword= document.getElementById("repassword").value; 
  var regex= /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    
 //minimum password length validation  
  
  if(password.length < 8||password.length > 15) {  
     document.getElementById("message").innerHTML = "**Mật khẩu chỉ từ 8-15 kí tự ";  
     return false;  
  }  
//maximum length of password validation  
     else {
	  if(password.match(regex))
		  {
		  if(password==repassword)
			  {
			  
			  return true;
			  }
		  document.getElementById("message").innerHTML="**Mật khẩu không khớp";
		  return false; 
		  }
	  document.getElementById("message").innerHTML="**Mật khẩu phải chứa chữ hoa, thường, số và kí tự!";  
     return false;
  }  
}
function checkNumber(){
    var number=document.getElementById("number").value;
    var price=document.getElementById("price").value;
    var priceSale=document.getElementById("pricesale").value;
    if(isNaN(number)||isNaN(price)||isNaN(priceSale))
    {
        alert("Số lượng hoặc giá không hợp lệ!");
        return false;
    }
    if(number<=0||price<=0||priceSale<=0)
    {
        alert("Số lượng và giá phải lớn hơn 0!");
        return false;
    }
    if(price>priceSale)
    {
        alert("Giá bán phải nhỏ hơn giá gốc!");
        return false;
    }
    else
    	{
    	return true;
    	} 
}  
function checkPhone() {

    var phone=document.getElementById("phone").value;
    var regex=/^\d{10}$/g;
    if(isNaN(phone)||!phone.match(regex))
    {
    	 document.getElementById("message").innerHTML="**Số điện thoại không đúng";
    	 return false;
    }
    return true;

}
/*var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}


function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active1", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active1";
}*/