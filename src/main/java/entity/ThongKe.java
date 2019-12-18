package entity;

import java.sql.Date;

public class ThongKe {
	private Date ngay;
	private int tongTien;
	
	public ThongKe(Date ngay, int tongTien) {
		super();
		this.ngay = ngay;
		this.tongTien = tongTien;
	}
	
	public ThongKe() {}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	
	
	
}
