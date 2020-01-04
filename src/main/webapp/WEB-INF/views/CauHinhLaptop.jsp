<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	
	<jsp:include page="HeaderAd.jsp"></jsp:include>
	<div style="margin:10px;">
		<div class="row">
			<div class="col-12">
				${SanPham.tenSanPham}
			</div>
		</div>
		<form action="/CNJava/cauhinhlaptop/1/${SanPham.idSanPham}" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-12">
					<div class="form-group" hidden="hidden">
				    	<label for="exampleFormControlInput1">ID</label>
					    <input type="text" class="form-control"name="idSanPham" value="${SanPham.idSanPham}" id="exampleFormControlInput1" placeholder="Nhập CPU">
			    	</div>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">CPU</label>
					    <input type="text" class="form-control"name="cpu" id="exampleFormControlInput1" placeholder="Nhập CPU">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">HardDisk</label>
					    <input type="text" class="form-control"name="hardDisk" id="exampleFormControlInput1" placeholder="Nhập harddisk">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">RAM</label>
					    <input type="text" class="form-control"name="ram" id="exampleFormControlInput1" placeholder="Nhập RAM">
			    	</div>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">VGA</label>
					    <input type="text" class="form-control"name="vga" id="exampleFormControlInput1" placeholder="Nhập ">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Kích thước màn hình</label>
					    <input type="text" class="form-control"name="kichThuocManHinh" id="exampleFormControlInput1" placeholder="Nhập kích thước màn hình">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Độ phân giải màn hình</label>
					    <input type="text" class="form-control"name="doPhanGiaiManHinh" id="exampleFormControlInput1" placeholder="Nhập độ phân giải màn hình">
			    	</div>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Loại màn hình</label>
					    <input type="text" class="form-control"name="loaiManHinh" id="exampleFormControlInput1" placeholder="Nhập loại màn hình">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Trọng lượng</label>
					    <input type="text" class="form-control"name="trongLuong" id="exampleFormControlInput1" placeholder="Nhập trọng lượng">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Kích thước</label>
					    <input type="text" class="form-control"name="kichThuoc" id="exampleFormControlInput1" placeholder="Nhập kích thước">
			    	</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">OS</label>
					    <input type="text" class="form-control"name="os" id="exampleFormControlInput1" placeholder="Nhập OS">
			    	</div>
				</div>
				<div class="col-6">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Pin</label>
					    <input type="text" class="form-control"name="pin" id="exampleFormControlInput1" placeholder="Nhập pins">
			    	</div>
				</div>
			</div>
	    	<div class="row">
				<div class="col-12" style="text-align:center;margin-top:20px;">
					<button type="submit" class="btn btn-primary">Xác nhận</button>
					<a href="/CNJava/admin"><button type="button" class="btn btn-primary">Cancle</button></a>
				</div>
		  	</div>
	  	</form>
	</div>
	<jsp:include page="FooterAdmin.jsp"></jsp:include>