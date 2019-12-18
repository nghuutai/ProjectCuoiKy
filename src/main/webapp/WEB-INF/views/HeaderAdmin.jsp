<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="<c:url value='/recources/style/style.css' />" rel="stylesheet">
</head>
<body>
	<div class="container">
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="/CNJava/admin">Home</a>
		  
		  <%
		  	int trangChon = (Integer) request.getAttribute("TrangChon");
		  	String active = "active";
		  	String no = "";
		  %>
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item <%=trangChon==1 ? active : no%>">
		        <a class="nav-link" href="/CNJava/admin">Quản lý sản phẩm<span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item <%=trangChon==2 ? active : no%>">
		        <a class="nav-link" href="/CNJava/quanlydonhang">Quản lý đơn hàng</a>
		      </li>
		      <li class="nav-item <%=trangChon==3 ? active : no%>">
		        <a class="nav-link" href="/CNJava/thongke">Thống kê doanh thu</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0" action="/project2/timkiem" method="get">
		      <input class="form-control mr-sm-2" name="timKiem" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		  </div>
		</nav>