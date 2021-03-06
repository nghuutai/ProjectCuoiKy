<%@page import="dao.DatabaseCauHinhMay"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="entity.SanPham"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="HeaderAd.jsp"></jsp:include>
	
		<div class="row">
			<div class="col-3">
				<div class="form-sanpham">
					<form action="/CNJava/admin" method="post" enctype="multipart/form-data">
					  <div class="form-group">
					    <label for="exampleFormControlInput1">Tên sản phẩm</label>
					    <input type="text" class="form-control"name="tenSanPham" id="exampleFormControlInput1" placeholder="Nhập tên sản phẩm">
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlInput1">Đơn giá</label>
					    <input type="text" class="form-control" name="donGia" id="exampleFormControlInput1" placeholder="Nhập đơn giá">
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlInput1">Số lượng</label>
					    <input type="text" class="form-control" name="soLuong" id="exampleFormControlInput1" placeholder="Nhập số ">
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlTextarea1">Mô tả</label>
					    <textarea class="form-control" name="moTa" id="exampleFormControlTextarea1" rows="3"></textarea>
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlSelect1">Nhà sản xuất</label>
					    <select class="form-control" name="idNhaSanXuat" id="exampleFormControlSelect1">
					      <c:forEach var="item" items="${ListNhaSanXuat}">
					      	<option value="${item.idNhaSanXuat}">${item.tenNhaSanXuat}</option>
					      </c:forEach>
					      <!-- <option value="1">DELL </option>
					      <option value="2">HP</option>
					      <option value="3">ASUS</option> -->
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlSelect1">Loại máy</label>
					    <select class="form-control" name="idLoaiMay" id="exampleFormControlSelect1">
					      <c:forEach var="item" items="${ListLoaiMay}">
					      	<option value="${item.idLoaiMay}">${item.tenLoaiMay}</option>
					      </c:forEach>
					      <!-- <option value="1">Laptop</option>
					      <option value="2">PC</option> -->
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlInput1">Hình ảnh</label>
					    <input type="file" name="hinhAnh" class="form-control-file" id="exampleFormControlFile1">
					  </div>
					  <button type="submit" class="btn btn-primary mb-2">Thêm sản phẩm</button>
					</form>
				</div>
			</div>
			<div class="col-9">
				<div class="row">
					<div class="col-12">
						Danh sách sản phẩm
					</div>
				</div>
				<div class="form-sanpham">
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">ID </th>
					      <th scope="col">Tên sản phẩm</th>
					      <th scope="col">Đơn giá</th>
					      <th scope="col">Số Lượng</th>
					      <th scope="col">Hình ảnh</th>
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<%
					  		List<SanPham> listSanPham = (List<SanPham>) request.getAttribute("listSP");
					    	for(SanPham sp : listSanPham){
					    		String img= "/resources/images/" + sp.getHinhAnh();
					    		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
					    		DatabaseCauHinhMay databaseCauHinhMay = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
					    		int check = databaseCauHinhMay.checkCauHinhLaptop(sp.getIdSanPham(),sp.getIdLoaiMay());
					  	%>
					  	<%-- <c:forEach var="p" items="${listSP}" varStatus="status"> --%>
					  		<tr>
						      <th scope="row"><%=sp.getIdSanPham() %></th>
						      <td><%=sp.getTenSanPham() %></td>
						      <td style="min-width: 130px;"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=sp.getDonGia() %>"/> đ</td>
						      <td style="max-width: 100px"><%=sp.getSoLuong() %> <%=sp.getIdNhaSanXuat() %> <%=sp.getIdLoaiMay() %></td>
						      <c:set var="hinhanh" value="<%=sp.getHinhAnh() %>"/>
						      <td><img style="witdh:100px; height:100px;" src="<c:url value='/resources/images/${hinhanh}' />"></td>
						      <td style="max-width: 120px">
						      	<div class="btn-group">
						      		<a href="/CNJava/suasanpham/<%=sp.getIdSanPham() %>" ><button style="width:80px;" type="button" class="btn btn-warning">Edit</button></a>
						      	</div>
						      	<div class="btn-group">
						      		<a onclick="return confirmDelete('Bấm OK để xoá sản phẩm')" href="/CNJava/admin/<%=sp.getIdSanPham() %>"><button style="width:80px;" type="button" class="btn btn-danger">Delete</button></a>
						      	</div>
						      	<%
						      		if(check == 1){
						      	%>
						      		<div class="btn-group">
						      			<button style="width:80px;" type="button" class="btn btn-danger" disabled="disabled">Cấu hình</button>
						      		</div>
						      	<% 
						      		}else{
						      			if(sp.getIdLoaiMay()==1){
						      	%>
						      		<div class="btn-group">
						      			<a href="/CNJava/cauhinhlaptop/1/<%=sp.getIdSanPham()%>"><button style="width:80px;" type="button" class="btn btn-danger">Cấu hình</button></a>
						      		</div>
						      	<%
						      			}else{
						      	%>
						      		<div class="btn-group">
						      			<a href="/CNJava/cauhinhpc/1/<%=sp.getIdSanPham()%>"><button style="width:80px;" type="button" class="btn btn-danger">Cấu hình</button></a>
						      		</div>
						      	<%		
						      			}
						      		}
						      	%>
						      	<%-- <div class="btn-group">
						      		<a href="/CNJava/admin/${p.idSanPham}"><button style="width:80px;" type="button" class="btn btn-danger">Cấu hình</button></a>
						      	</div> --%>
						      	<script>
							        function confirmDelete(msg){
							        	if(window.confirm(msg) == true){
							        		return true;
							        	}
							        	return false;
							        }
							    </script>
						      </td>
						    </tr>
					  	<%-- </c:forEach> --%>
					  	<%
					    	}
					  	%>
					  </tbody>
					</table>
				</div>
			</div>
		</div>	
		
	<jsp:include page="FooterAdmin.jsp"></jsp:include>