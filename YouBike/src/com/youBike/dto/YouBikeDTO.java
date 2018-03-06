package com.youBike.dto;

public class YouBikeDTO {
	
	//bike stop id
	private String sno;

	//bike stop name in Chinese
	private String sna;

	//total parking spaces
	private int tot;

	//available bikes 
	private int sbi;

	//area name in Chinese
	private String sarea;
	
	//data update time
	private String mday;

	//bike stop's latitude
	private float lat;

	//bike stop's longitude
	private float lng;
	
	//address in Chinese
	private String ar;
	
	//area name in English
	private String sareaen;

	//bike stop name in English
	private String snaen;

	//address in English
	private String aren;

	//available spaces
	private int bemp;

	//bike stop status
	private boolean act;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSna() {
		return sna;
	}

	public void setSna(String sna) {
		this.sna = sna;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getSbi() {
		return sbi;
	}

	public void setSbi(int sbi) {
		this.sbi = sbi;
	}

	public String getSarea() {
		return sarea;
	}

	public void setSarea(String sarea) {
		this.sarea = sarea;
	}

	public String getMday() {
		return mday;
	}

	public void setMday(String mday) {
		this.mday = mday;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}

	public String getSareaen() {
		return sareaen;
	}

	public void setSareaen(String sareaen) {
		this.sareaen = sareaen;
	}

	public String getSnaen() {
		return snaen;
	}

	public void setSnaen(String snaen) {
		this.snaen = snaen;
	}

	public String getAren() {
		return aren;
	}

	public void setAren(String aren) {
		this.aren = aren;
	}

	public int getBemp() {
		return bemp;
	}

	public void setBemp(int bemp) {
		this.bemp = bemp;
	}

	public boolean isAct() {
		return act;
	}

	public void setAct(boolean act) {
		this.act = act;
	}

	@Override
	public String toString() {
		return "YouBikeDTO [sno=" + sno + ", sna=" + sna + ", tot=" + tot + ", sbi=" + sbi + ", sarea=" + sarea
				+ ", mday=" + mday + ", lat=" + lat + ", lng=" + lng + ", ar=" + ar + ", sareaen=" + sareaen
				+ ", snaen=" + snaen + ", aren=" + aren + ", bemp=" + bemp + ", act=" + act + "]";
	}

}
