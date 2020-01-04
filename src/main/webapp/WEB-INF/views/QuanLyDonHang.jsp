<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="entity.SanPham"%>
<%@page import="dao.DatabaseSanPham"%>
<%@page import="dao.DatabaseChiTietHoaDon"%>
<%@page import="entity.ChiTietHoaDon"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="entity.HoaDon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="HeaderAd.jsp"></jsp:include>
	
	<div class="row" style="margin:20px;">
		<form action="/CNJava/quanlydonhang/timkiem" method="post">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">			
				    <input type="text" class="form-control" name="timKiem" placeholder="Search">
				</div>		
			</div>
			<div class="col-sm-6">
				<div class="form-group">
				<button type="submit" class="btn btn-primary">Tìm</button>
				</div>
			</div>
		</div>
		</form>
		<form action="/CNJava/quanlydonhang/tinhtrang" method="post" class="form-inline">	
				<div class="form-group mb-5" style="margin-right:10px;">
				    <select class="form-control" name="tinhTrang1" id="exampleFormControlSelect1">
					<%
						int tinhTrangChon = (Integer) request.getAttribute("TinhTrangChon");
		    			HashMap<Integer,String> listTinhTrang = (HashMap<Integer,String>)request.getAttribute("TinhTrang");
		    			Iterator<HashMap.Entry<Integer,String>> iterator = listTinhTrang.entrySet().iterator();
			    		while(iterator.hasNext()){	
				    		HashMap.Entry<Integer, String> entry = iterator.next();
				    		if(tinhTrangChon == entry.getKey()){
		    		%>
				      	<option value="<%=entry.getKey() %>" selected><%=entry.getValue() %></option>
				    <%
				    		}else{
				    %>
				    	<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
				    <%			
				    		}
			    		}
				    %>
				    </select>
				</div>
				<div class="form-group mb-5">
					<button type="submit" class="btn btn-primary">Tìm kiếm</button>
				</div>	
		</form>
		<c:if test="${HoaDon.size() == 0}">
			<div class="col-12" style="text-align:center;">
			  ${ThongBao}
			</div>
		</c:if>
		<c:if test="${HoaDon.size() > 0}">
		<div class="col-12">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Thời gian</th>
			      <th scope="col">Họ và tên</th>
			      <th scope="col">Số điện thoại</th>
			      <th scope="col">Trạng thái</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  		List<HoaDon> listHoaDon = (List<HoaDon>)request.getAttribute("HoaDon");
			  		for(HoaDon hoaDon : listHoaDon){
			  			String tinhTrang = "";
			  			if(hoaDon.getTinhTrangHoaDon() == 1){
			  				tinhTrang = "Chưa xác nhận";
			  			}else if(hoaDon.getTinhTrangHoaDon() == 2){
			  				tinhTrang = "Không liên lạc được";
			  			}else if(hoaDon.getTinhTrangHoaDon() == 2){
			  				tinhTrang = "Huỷ đơn hàng";
			  			}else{
			  				tinhTrang = "Đã xác nhận";
			  			}
			  	%>
			  		<c:set var = "idModal" value = "<%=hoaDon.getMaHoaDon() %>"/>
			  		<tr>
				      <th scope="row">1</th>
				      <td><%=hoaDon.getNgayTao() %></td>
				      <td><%=hoaDon.getTenKhachHang() %></td>
				      <td><%=hoaDon.getSoDienThoai() %></td>
				      <td><%=tinhTrang %></td>
				      <td><button type="button" class="btn btn-primary" onclick="chiTiet(${idModal})">Xem</button></td>
				    </tr>
				    
				    <!-- Modal -->
			        <div class="modal fade" id="m${idModal}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content" style="width:700px;">
					      <div class="modal-body">
					      	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					        <div class="col-12">
						    	<h3>THÔNG TIN ĐƠN HÀNG</h3>
						    </div>
					       	<div class="row" style="margin:20px;">
							    <div class="form-group row">
								    <label for="inputPassword" class="col-5 col-form-label" style="width:120px;">Tên khách hàng: </label>
								    <div class="col-7">
								      <input type="text" class="form-control" value="<%=hoaDon.getTenKhachHang() %>" id="inputPassword">
								    </div>
								</div>
								<div class="form-group row">
								    <label for="inputPassword" class="col-5 col-form-label" style="width:120px;">Số điện thoại: </label>
								    <div class="col-7">
								      <input type="text" class="form-control" value="<%=hoaDon.getSoDienThoai() %>" id="inputPassword">
								    </div>
								</div>
								<div class="form-group row">
								    <label for="inputPassword" class="col-5 col-form-label" style="width:120px;">Email: </label>
								    <div class="col-7">
								      <input type="text" class="form-control" value="<%=hoaDon.getEmail() %>" id="inputPassword">
								    </div>
								</div>
								<div class="form-group row">
								    <label for="inputPassword" class="col-5 col-form-label" style="width:120px;">Địa chỉ: </label>
								    <div class="col-7">
								      <input type="text" class="form-control" value="<%=hoaDon.getDiaChi() %>" id="inputPassword">
								    </div>
								</div>
								<div class="form-group row">
								    <label for="inputPassword" class="col-5 col-form-label" style="width:120px;">Thành phố: </label>
								    <div class="col-7">
								      <input type="text" class="form-control" value="<%=hoaDon.getThanhPho() %>" id="inputPassword">
								    </div>
								</div>
					  		</div>	
					  		<%
					  			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
					  			DatabaseChiTietHoaDon dbhd = (DatabaseChiTietHoaDon)context.getBean("databasechitiethoadon");
					  			DatabaseSanPham dbsp = (DatabaseSanPham)context.getBean("databasesanpham");
					  			List<ChiTietHoaDon> listCTHD = dbhd.getChiTietHoaDonByID(hoaDon.getMaHoaDon());		  			
					  		%>
					  		<div style="margin-bottom:20px;">Danh sach san pham</div>
					  		<div class="row">
					  			<div class="col-3">ID</div>
					  			<div class="col-3">Ten san pham</div>
					  			<div class="col-3">So luong</div>
					  			<div class="col-3">Thanh tien</div>
					  		</div>
					  		<div class="dropdown-divider"></div>
					  		<%
					  			int stt = 0;
					  			int tongTienDonHang = 0;
					  			for(ChiTietHoaDon chiTietHD : listCTHD){
					  				SanPham sp = dbsp.getSanPhamByID(chiTietHD.getSanPham().getIdSanPham());
					  				int thanhTien = sp.getDonGia() * chiTietHD.getSoLuongMua();
					  				stt++;
					  		%>
					  			<div class="row">
						  			<div class="col-3"><%=stt %></div>
						  			<div class="col-3"><%=sp.getTenSanPham() %></div>
						  			<div class="col-3"><%=chiTietHD.getSoLuongMua() %></div>
						  			<div class="col-3"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=thanhTien %>"/> đ</div>
						  		</div>
						  		<div class="dropdown-divider"></div>
					  		<%
					  				tongTienDonHang += thanhTien;
					  			}
					  		%>
					  		<div class="form-group">
					  			<label for="exampleFormControlInput1" style="float:right;">Tổng tiền đơn hàng: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=tongTienDonHang %>"/> đ</label>
					  		</div>
					  		<div class="form-group">
							    <label for="exampleFormControlInput1">Trạng thái đơn hàng</label>
							    <form action="/CNJava/quanlydonhang/thaydoitrangthai/<%=hoaDon.getMaHoaDon() %>" method="post">
							    <div class="row">
							    	<div class="col-4">
							    		<select class="form-control" name="tinhTrang" id="exampleFormControlSelect1">
							    		<%
							    			HashMap<Integer,String> listTinhTrang1 = (HashMap<Integer,String>)request.getAttribute("TinhTrang");
							    			Iterator<HashMap.Entry<Integer,String>> iterator1 = listTinhTrang.entrySet().iterator(); 
								    		while(iterator1.hasNext()){	
									    		HashMap.Entry<Integer, String> entry = iterator1.next();
							    		%>
							    		<%
								    			if(hoaDon.getTinhTrangHoaDon() == entry.getKey()){
							    		%>
									      <option value="<%=entry.getKey() %>" selected><%=entry.getValue() %></option>
									    <%
								    			}else{
								    	%>
								    	  <option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
								    	<%			
								    			}
								    		}
									    %>
									    </select>
							    	</div>
							    	<div class="col-3">
							    		<button type="submit" class="btn btn-primary">Xác nhận</button>
							    	</div>
							    </div>
							    </form>  
							</div>
					      </div>
					    </div>
					  </div>
					</div>
					<script>
						function chiTiet(id){						
							$("#m" + id).modal('show');
						}
					</script>
			  	<%		
			  		}
			  	%>
			  </tbody>
			</table>
		</div>
		</c:if>
	</div>
	

	<jsp:include page="FooterAdmin.jsp"></jsp:include>