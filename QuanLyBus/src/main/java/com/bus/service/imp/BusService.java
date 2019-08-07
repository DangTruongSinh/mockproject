package com.bus.service.imp;

import java.util.List;

import com.bus.dao.impl.BusDAO;
import com.bus.model.BusModel;
import com.bus.service.IBusService;

public class BusService implements IBusService{
	BusDAO busDao;
	public BusService()
	{
		busDao = new BusDAO();
	}
	@Override
	public List<BusModel> findAll() {
		return busDao.findAll();
	}
	@Override
	public BusModel insertBusModel(BusModel busModel) {
		// 
		busModel.setUserCreate("userHienTai");
		busModel.setUserUpdate("userHienTai");
		int id = busDao.insertBusModel(busModel);
		if(id != -1)
		{
			return busDao.findOneByIdBus(id);
		}
		return null;
	}
	@Override
	public BusModel updateBusModel(BusModel busModel) 
	{
			//busModel.setDateUpdate(new Timestamp(System.currentTimeMillis()));
			busModel.setUserUpdate("userHienTai");
			int result = busDao.updateBusModel(busModel);
			if(result != -1)
				return busDao.findOneByIdBus(busModel.getIdBus());
			return null;
	}
	@Override
	public boolean deleteBusModel(int id) {
		return busDao.deleteBusModel(id) == 1? true : false;
	}
	@Override
	public BusModel findOneByLicensePlate(String licensePlace) {
		return busDao.findOneByLicensePlate(licensePlace);
	}
	@Override
	public List<BusModel> findAllByPlaceStartToEnd(String start, String end) {
		return busDao.findAllByPlaceStartToEnd(start, end);
	}
	
}