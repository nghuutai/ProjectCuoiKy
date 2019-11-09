package entity;

import entity.SanPham;

public class Cart {
	private SanPham sanPham;
	private int soLuong;
	private int soLuongCon;
	private Boolean kiemTraSoLuong;

	public Cart() {
		
	}
	
	public Cart(SanPham sanPham, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public int tongTien() {
		return this.sanPham.getDonGia() * this.soLuong;
	}
	public Boolean getKiemTraSoLuong() {
		return kiemTraSoLuong;
	}

	public void setKiemTraSoLuong(Boolean kiemTraSoLuong) {
		this.kiemTraSoLuong = kiemTraSoLuong;
	}

	public int getSoLuongCon() {
		return soLuongCon;
	}

	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}
}
