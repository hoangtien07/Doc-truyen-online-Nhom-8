package com.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loai_truyen")
public class LoaiTruyen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "loaiTruyen")
	private List<Truyen> truyens = new ArrayList<Truyen>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Truyen> getTruyens() {
		return truyens;
	}

	public void setTruyens(List<Truyen> truyens) {
		this.truyens = truyens;
	}
	
	
	
}
