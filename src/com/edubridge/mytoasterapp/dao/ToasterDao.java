package com.edubridge.mytoasterapp.dao;

import java.util.List;

import com.edubridge.mytoasterapp.model.Toaster;

public interface ToasterDao {
		int addToaster(Toaster c);
		List<Toaster> findToasters();
		Toaster findToastersByBrand(String brand);
		int updateToaster(Toaster c);
		int deleteToasterByBrand(String brand);
		void deleteAllToasters();
		
		
	}