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
	  </div><div class="form-group">
	    <label for="exampleFormControlInput1">Email</label>
	    <input type="text" name="email"value="${sessionScope.hoaDon.email}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập địa chỉ email" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleFormControlInput1">Số điện thoại</label>
	    <input type="text" name="soDienThoai" value="${sessionScope.hoaDon.soDienThoai}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập số điện thoại" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleFormControlInput1">Địa chỉ</label>
	    <input type="text" name="diaChi" value="${sessionScope.hoaDon.diaChi}" class="form-control" id="exampleFormControlInput1" placeholder="Nhập địa chỉ" required>
	  </div>
	  <div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;">
			<button type="submit" class="btn btn-primary">Giao đến địa chỉ này</button>
		</div>
	  </div>
	</form>