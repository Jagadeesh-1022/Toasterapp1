package com.edubridge.mytoasterapp.service;

import java.util.List;

import com.edubridge.mytoasterapp.dao.ToasterDao;
import com.edubridge.mytoasterapp.dao.ToasterDaoImpl;
import com.edubridge.mytoasterapp.model.Toaster;

public class ToasterServiceImpl  implements ToasterService {
      ToasterDao dao = new ToasterDaoImpl();	
	
	@Override
	public int addToaster(Toaster c) {
		
		return dao.addToaster(c);
	}

	@Override
	public List<Toaster> findToaster() {
		// TODO Auto-generated method stub
		return dao.findToasters();
	}

	@Override
	public Toaster findToasterByBrand(String brand) {
		// TODO Auto-generated method stub
		return dao.findToastersByBrand(brand);
	}

	@Override
	public int updateToaster(Toaster c) {
		// TODO Auto-generated method stub
		return dao.updateToaster(c);
	}

	@Override
	public int deleteToasterByBrand(String brand) {
		// TODO Auto-generated method stub
		return dao.deleteToasterByBrand(brand);
	}

	@Override
	public void deleteAllToasters() {
		// TODO Auto-generated method stub
		
	}

}
