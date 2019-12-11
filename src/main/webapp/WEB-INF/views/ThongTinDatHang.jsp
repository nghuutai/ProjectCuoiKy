<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<div class="row">
		<div class="col-12" style="margin:20px;">
			<h3>Thông tin khách </h3>
		</div>
	</div>
	<form style="margin-bottom-:20px;margin-left:20px;margin-right:20px;" action="/CNJava/thongtin" method="post">
	  <div class="form-group">
	    <label for="exampleFormControlInput1">Tên khách hàng</label>
	    <input type="text" name="tenKhachHang" value="${sessionScope.hoaDon.tenKhachHang}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập họ tên" required>
	  	<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
	  </div><div class="form-group">
	    <label for="exampleFormControlInput1">Email</label>
	    <input id="txtmail" type="text" name="email"value="${sessionScope.hoaDon.email}" onchange="check()" class="form-control" id="exampleFormControlInput1" placeholder="Nhập địa chỉ email" required>
	  	<small id="infmail" style="display:none;" class="form-text text-muted"><font color="red">Email không hợp lệ</font></small>
	  </div>
	  <div class="form-group">
	    <label for="exampleFormControlInput1">Số điện thoại</label>
	    <input id="txtPhone" type="text" name="soDienThoai" onchange="check()" value="${sessionScope.hoaDon.soDienThoai}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập số điện thoại" required>
	  	<small id="infPhone" style="display:none;" class="form-text text-muted"><font color="red">Số điện thoại không hợp lệ</font></small>
	  </div>
	  <div class="form-group">
	    <label for="exampleFormControlInput1">Địa chỉ</label>
	    <input type="text" name="diaChi" value="${sessionScope.hoaDon.diaChi}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập địa chỉ" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleFormControlSelect1">Thành phố</label>
	    <select class="form-control" name="thanhPho" id="exampleFormControlSelect1">
	      <%
	      	HashMap<String, String> arrTinh = (HashMap<String,String>) request.getAttribute("Tinh");
	    	Iterator<HashMap.Entry<String,String>> iterator = arrTinh.entrySet().iterator();
	    	while(iterator.hasNext()){	
	    		HashMap.Entry<String, String> entry = iterator.next();
	      %>	
	      		<option value="<%=entry.getValue() %>"><%=entry.getValue() %></option>
	      <%
	    	}
	      %>
	    </select>
	  </div>
	  <div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;">
			<button id="btnGiao" type="submit" class="btn btn-primary">Giao đến địa chỉ này</button>
		</div>
	  </div>
	</form>
	<script>
		function check(){
			var resultEmail;
			var resultPhone;
			var mail = document.getElementById("txtmail").value;
			var phone = document.getElementById("txtPhone").value;
			var attMail = document.getElementById("infmail");
			var attPhone = document.getElementById("infPhone");
			if(mail !== ""){
				var reEmail = /^[a-zA-Z0-9]+[.]{0,1}[a-zA-Z0-9]+[@][a-z]+([.][a-z]{2,})+$/
	            var testEmail = reEmail.test(mail);
				if(testEmail){
					console.log("OK");
					attMail.style.setProperty("display", "none");
					resultEmail = true
				}else{
					console.log("not ok");
					attMail.style.setProperty("display", "block");
					resultEmail = false;
				}
			}else{
				attMail.style.setProperty("display", "none");
			}
			if(phone !== ""){
				console.log(phone);
				var rePhone = /^[0][0-9]{1,10}$/
	            var testPhone = rePhone.test(phone)
				if(testPhone){
					if(phone.length === 10 || phone.length === 11){
						console.log("OK");
						attPhone.style.setProperty("display", "none");
						resultPhone = true;
					}else{
						console.log("not ok");
						attPhone.style.setProperty("display", "block");
						resultPhone = false;
					}
				}else{
					console.log("not ok");
					attPhone.style.setProperty("display", "block");
					resultPhone = false;
				}
			}else{
				attPhone.style.setProperty("display", "none");
			}
			
			
			if(resultEmail === true && resultPhone === true){
				document.getElementById("btnGiao").disabled = false;
			}else{
				document.getElementById("btnGiao").disabled = true;
			}
		}
	</script>
	<jsp:include page="Footer.jsp"></jsp:include>
	