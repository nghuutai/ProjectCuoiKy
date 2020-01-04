<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.ThongKe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="HeaderAd.jsp"></jsp:include>
		<div class="row" style="margin-left:20px;margin-right:20px;margin-top:20px;">
			<div class="col-12" style="text-align:center;margin-top:20px;">
				<h3>THỐNG KÊ DOANH THU</h3>
			</div>
			<form action="/CNJava/thongkedoanhthu" method="post">
				<div class="row">
					<div class="col-sm-2">
						<div class="form-group">			
						    <label for="staticEmail" class="col-form-label">Tháng: </label>
						</div>		
					</div>
					<div class="col-sm-4">
						<select class="form-control" name="thang" id="exampleFormControlSelect1">
							<%
								int thangChon = (Integer) request.getAttribute("ThangChon");
								ArrayList<Integer> arrThang = (ArrayList<Integer>) request.getAttribute("Thang");
								for(Integer thang : arrThang){
									if(thang == thangChon){
							%>
									<option value="<%=thang %>" selected><%=thang %></option>
							<%		
									}else{
							%>
									<option value="<%=thang %>"><%=thang %></option>
							<%
									}
								}
							%>
					      	
					    </select>
					</div>
					<div class="col-sm-2">
						<div class="form-group">			
						    <label for="staticEmail" class="col-form-label">Năm: </label>
						</div>		
					</div>
					<div class="col-sm-4">
						<select class="form-control" name="nam" id="exampleFormControlSelect1">
							<%
								int namChon = (Integer) request.getAttribute("NamChon");
								ArrayList<Integer> arrNam = (ArrayList<Integer>) request.getAttribute("Nam");
								for(Integer nam : arrNam){
									if(nam == namChon){
							%>
									<option value="<%=nam %>" selected><%=nam %></option>
							<%
									}else{
							%>
									<option value="<%=nam %>"><%=nam %></option>
							<%			
									}
								}
							%>
					    </select>
					</div>
				</div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary">Thống kê</button>
				</div>
			</form>
		</div>
		<c:if test="${Size == 0}">
			<div class="col-12" style="text-align:center;margin:20px;">
			  ${ThongBao}
			</div>
		</c:if>
		<c:if test="${Size>0}">
			<div class="row" style="margin:20px;">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">STT</th>
				      <th scope="col">Ngày</th>
				      <th scope="col">Tổng tiền</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<%
				  		int stt = 0;
				  		List<ThongKe> listThongKe = (List<ThongKe>) request.getAttribute("ListThongKe");
				  		for(ThongKe thongKe : listThongKe){
				  			stt++;
				  			Date date = thongKe.getNgay();
				  			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				  			String ngay = format.format(date);
				  	%>
				  		<tr>
					      <th scope="row"><%=stt %></th>
					      <td><%=ngay %></td>
					      <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=thongKe.getTongTien() %>"/> đ</td>
					      <td><a href="/CNJava/thongkechitiet/<%=thongKe.getNgay() %>"><button type="button" class="btn btn-danger">Chi tiết</button></td></a>
					    </tr>
				  	<%
				  		}
				  	%>
				  </tbody>
				</table>
			</div>
		</c:if>
	<jsp:include page="FooterAdmin.jsp"></jsp:include>