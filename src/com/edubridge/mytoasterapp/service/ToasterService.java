package com.edubridge.mytoasterapp.service;

import java.util.List;

import com.edubridge.mytoasterapp.model.Toaster;


public interface ToasterService {
	int addToaster( Toaster c);
	List<Toaster> findToaster();
	Toaster findToasterByBrand(String brand);
	int updateToaster(Toaster c);
	int deleteToasterByBrand(String brand);
	void deleteAllToasters();
	
}
