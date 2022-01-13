package qlymuonsach;

import java.util.Arrays;

public class muonSach {
	sach[] sach;
	banDoc banDoc;
	int[] quantity;
	
	public sach[] getSach() {
		return sach;
	}
	public void setSach(sach[] sach) {
		this.sach = sach;
	}
	public banDoc getBanDoc() {
		return banDoc;
	}
	public void setBanDoc(banDoc banDoc) {
		this.banDoc = banDoc;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	public muonSach() {
		super();
	}
	public muonSach(qlymuonsach.sach[] sach, qlymuonsach.banDoc banDoc, int[] quantity) {
		super();
		this.sach = sach;
		this.banDoc = banDoc;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "MuonSach{" +
                "BanDoc=" + banDoc +
                ", sach=" + Arrays.toString(sach) +
                ", SoLuong=" + Arrays.toString(quantity) +
                '}';
	}
}
