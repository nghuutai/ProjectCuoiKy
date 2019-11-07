package entity;

public class CauHinhLaptop {
	private int idSanPham;
	private String cpu;
	private String ram;
	private String hardDisk;
	private String vga;
	private String kichThuocManHinh;
	private String doPhanGiaiManHinh;
	private String loaiManHinh;
	private String trongLuong;
	private String kichThuoc;
	private String os;
	private String pin;
	
	public CauHinhLaptop(int idSanPham, String cpu, String ram, String hardDisk, String vga, String kichThuocManHinh,
			String doPhanGiaiManHinh, String loaiManHinh, String trongLuong, String kichThuoc, String os, String pin) {
		super();
		this.idSanPham = idSanPham;
		this.cpu = cpu;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.vga = vga;
		this.kichThuocManHinh = kichThuocManHinh;
		this.doPhanGiaiManHinh = doPhanGiaiManHinh;
		this.loaiManHinh = loaiManHinh;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.os = os;
		this.pin = pin;
	}

	public CauHinhLaptop() {
		super();
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getVga() {
		return vga;
	}

	public void setVga(String vga) {
		this.vga = vga;
	}

	public String getKichThuocManHinh() {
		return kichThuocManHinh;
	}

	public void setKichThuocManHinh(String kichThuocManHinh) {
		this.kichThuocManHinh = kichThuocManHinh;
	}

	public String getDoPhanGiaiManHinh() {
		return doPhanGiaiManHinh;
	}

	public void setDoPhanGiaiManHinh(String doPhanGiaiManHinh) {
		this.doPhanGiaiManHinh = doPhanGiaiManHinh;
	}

	public String getLoaiManHinh() {
		return loaiManHinh;
	}

	public void setLoaiManHinh(String loaiManHinh) {
		this.loaiManHinh = loaiManHinh;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
