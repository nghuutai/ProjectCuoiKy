package entity;

public class LoaiMay {

	private int idLoaiMay;
	private String tenLoaiMay;
	
	
	public LoaiMay() {
		super();
	}

	public LoaiMay(int idLoaiMay, String tenLoaiMay) {
		super();
		this.idLoaiMay = idLoaiMay;
		this.tenLoaiMay = tenLoaiMay;
	}

	public int getIdLoaiMay() {
		return idLoaiMay;
	}

	public void setIdLoaiMay(int idLoaiMay) {
		this.idLoaiMay = idLoaiMay;
	}

	public String getTenLoaiMay() {
		return tenLoaiMay;
	}

	public void setTenLoaiMay(String tenLoaiMay) {
		this.tenLoaiMay = tenLoaiMay;
	}
	
}
