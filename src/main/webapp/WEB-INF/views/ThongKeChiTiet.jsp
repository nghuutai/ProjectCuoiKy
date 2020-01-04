<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="entity.ThongKeChiTiet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="HeaderAd.jsp"></jsp:include>
		<div class="row" style="margin-left:20px;margin-right:20px;margin-top:20px;">
			<div class="col-12" style="margin-left:20px;">
				<a href="/CNJava/thongke">Quay về</a>
			</div>
			<%
				
				Date date = (Date)request.getAttribute("Ngay");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String ngay = format.format(date);
			%>
			<c:set var="ngay" value="<%=ngay %>"></c:set>
			<div class="col-12" style="text-align:center;margin-top:20px;">
				<h4>Các đơn hàng trong ngày ${ngay }</h4>
			</div>
			<div class="col-12" style="margin:20px;">
				<table class="table">
				  	<thead>
					    <tr>
					    	<th scope="col">STT</th>
					      	<th scope="col">Id hoá đơn</th>
					      	<th scope="col">Tên khách hàng</th>
					      	<th scope="col">Tổng tiền</th>
					    </tr>
				  	</thead>
				  <tbody>
				  	<%
				  		int stt =0;
				  		int tongTien = 0;
				  		List<ThongKeChiTiet> listThongKeChiTiet = (List<ThongKeChiTiet>) request.getAttribute("ListThongKeChiTiet");
				  		for(ThongKeChiTiet tkct : listThongKeChiTiet){
				  			stt++;
				  			tongTien = tongTien + tkct.getTongTien();
				  	%>
				  			<tr>
						      	<th scope="row"><%=stt %></th>
						      	<td><%=tkct.getIdHoaDon() %> </td>
						      	<td><%=tkct.getTenKhachHang() %></td>
						      	<td><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=tkct.getTongTien() %>"/> đ</td>
						    </tr>
				  	<%		
				  		}
				  	%>
				  </tbody>
				</table>
			</div>
			<div class="col-12" style="text-align:right;margin-top:20px;">
				<h5>Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=tongTien %>"/> đ</h4>
			</div>
		</div>
	<jsp:include page="FooterAdmin.jsp"></jsp:include>