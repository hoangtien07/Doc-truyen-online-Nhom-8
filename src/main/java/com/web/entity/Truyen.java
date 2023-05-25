package com.web.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "truyen")
public class Truyen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ten;
	
	private Integer tap;
	
	private String tenTap;
	
	private String noiDung;
	
	private Date createdDate;
	
	private String anh;
	
	@ManyToOne
	@JoinColumn(name = "loai_truyen")
	private LoaiTruyen loaiTruyen;
	
	@OneToMany(mappedBy = "truyen", cascade = CascadeType.REMOVE)
	private List<LuuTruyen> luuTruyens = new ArrayList<LuuTruyen>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Integer getTap() {
		return tap;
	}

	public void setTap(Integer tap) {
		this.tap = tap;
	}

	public String getTenTap() {
		return tenTap;
	}

	public void setTenTap(String tenTap) {
		this.tenTap = tenTap;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public LoaiTruyen getLoaiTruyen() {
		return loaiTruyen;
	}

	public void setLoaiTruyen(LoaiTruyen loaiTruyen) {
		this.loaiTruyen = loaiTruyen;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public List<LuuTruyen> getLuuTruyens() {
		return luuTruyens;
	}

	public void setLuuTruyens(List<LuuTruyen> luuTruyens) {
		this.luuTruyens = luuTruyens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truyen other = (Truyen) obj;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equalsIgnoreCase(other.ten))
			return false;
		return true;
	}
	
	
}
