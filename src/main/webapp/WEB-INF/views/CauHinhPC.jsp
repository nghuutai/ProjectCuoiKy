<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="HeaderAdmin.jsp"></jsp:include>
	
	<div style="margin:10px;">
		<div class="row">
			<div class="col-12">
				${SanPham.tenSanPham}
			</div>
		</div>
		<form action="/CNJava/cauhinhpc/${SanPham.idSanPham}" method="post" enctype="multipart/form-data">
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
				    	<label for="exampleFormControlInput1">Mainboard</label>
					    <input type="text" class="form-control"name="mainboard" id="exampleFormControlInput1" placeholder="Nhập mainboard">
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
				    	<label for="exampleFormControlInput1">HardDisk</label>
					    <input type="text" class="form-control"name="hardDisk" id="exampleFormControlInput1" placeholder="Nhập harddisk">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">VGA</label>
					    <input type="text" class="form-control"name="vga" id="exampleFormControlInput1" placeholder="Nhập VGA">
			    	</div>
				</div>
				<div class="col-4">
					<div class="form-group">
				    	<label for="exampleFormControlInput1">Nguồn</label>
					    <input type="text" class="form-control"name="nguon" id="exampleFormControlInput1" placeholder="Nhập nguồn">
			    	</div>
				</div>
			</div>
			<div class="form-group">
		    	<label for="exampleFormControlInput1">Case</label>
			    <input type="text" class="form-control" name="mCase" id="exampleFormControlInput1" placeholder="Nhập case">
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