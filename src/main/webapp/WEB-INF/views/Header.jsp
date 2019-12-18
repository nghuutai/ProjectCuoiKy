<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
	<div class="row" style="margin-left:0px;margin-right:0px;">
		<div class="col-12" style="text-align:center;background-color: green;">
			ABC COMPUTER HỖ TRỢ GIAO HÀNG VÀ THU TIỀN TẬN NƠI TRÊN TOÀN QUỐC
		</div>
	</div>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="/CNJava/">Home</a>

	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <c:forEach var="item" items="${ListLoaiMay}">
		      <li class="nav-item">
		        <a class="nav-link" href="/CNJava/chitietloaisanpham/${item.idLoaiMay}">${item.tenLoaiMay}</a>
		      </li>
	      </c:forEach>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="/CNJava/giohangchitiet" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          <c:if test="${sessionScope.count>0}">Cart(${sessionScope.count})</c:if>
	          <c:if test="${sessionScope.count==0 || sessionScope.count==null}">Cart</c:if>
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <c:forEach var="item" items="${sessionScope.myCartItems}">
	          	  <div class="row" style="width:250px;">
		          	<div class="col-4"><img src="<c:url value='/resources/images/${item.value.sanPham.hinhAnh}' />" alt="..." class="img-thumbnail"></div>
		          	<div class="col">
		          		<div style="font-size:9px;">Tên sản phâm: ${item.value.sanPham.tenSanPham}</div>
		          		<div style="font-size:9px;">Số lượng: ${item.value.soLuong}</div>
		          		<div style="font-size:9px;">Đơn giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.value.sanPham.donGia}"/> đ</div>
		          	</div>
		          </div>
	          </c:forEach>
	          <c:if test="${sessionScope.count>0}">
		          <div class="dropdown-divider"></div>
		          <div class="row">
		          	<div class="col-12" style="font-size:9px;">Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${sessionScope.totalCart}"/> vnđ</div>
		          	<div class="col-12">
			          	<a href="/CNJava/giohangchitiet"><span style="font-size:10px; margin-left:0px;">Chi tiết</span></a>
			        </div>
		          </div>
	          </c:if>
	        </div>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0" action="/CNJava/timkiem" method="get">
	      <input class="form-control mr-sm-2" type="search" name="timKiem" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>