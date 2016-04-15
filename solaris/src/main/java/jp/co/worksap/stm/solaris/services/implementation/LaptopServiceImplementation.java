package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;

import jp.co.worksap.stm.solaris.dao.specification.LaptopDao;
import jp.co.worksap.stm.solaris.dto.LaptopDto;
import jp.co.worksap.stm.solaris.entity.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.entity.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.LaptopListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaptopServiceImplementation implements LaptopService {

	@Autowired
	LaptopDao ld;

	@Override
	public LaptopListEntity getAll(LaptopFetchEntity e) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByName(String name) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String name) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void insert(LaptopCreationEntity le) throws ServiceException {
		try {
			LaptopDto lto = new LaptopDto();
			lto.setAntivirusSoftware(le.getAntivirusSoftware());
			lto.setBatteryCells(le.getBatteryCells());
			lto.setBatteryLife(le.getBatteryLife());
			lto.setBatteryVolume(le.getBatteryVolume());
			lto.setBluetooth(le.getBluetooth());
			lto.setBrand(le.getBrand());
			lto.setCameraPixel(le.getCameraPixel());
			lto.setCardReaderTypes(le.getCardReaderTypes());
			lto.setCpu(le.getCpu());
			lto.setGpu(le.getGpu());
			lto.setGraphicMemory(le.getGraphicMemory());
			lto.setGraphicsCardType(le.getGraphicsCardType());
			lto.setHasBag(le.isHasBag());
			lto.setHasFrontCamera(le.isHasFrontCamera());
			lto.setHasHDMIPort(le.isHasFrontCamera());
			lto.setHasTrackPoint(le.isHasTrackPoint());
			lto.setHasVGAPort(le.isHasVGAPort());
			lto.setHddModel(le.getHddModel());
			lto.setHddSize(le.getHddSize());
			lto.setHddSpinSpeed(le.getHddSpinSpeed());
			lto.setImagePath(le.getImagePath());
			lto.setLaptop_height(le.getLaptop_height());
			lto.setLaptop_length(le.getLaptop_length());
			lto.setLaptop_weight(le.getLaptop_weight());
			lto.setLaptop_width(le.getLaptop_width());
			lto.setName(le.getName());
			lto.setOfficeSuiteVersion(le.getOfficeSuiteVersion());
			lto.setOpticalDrive(le.getOpticalDrive());
			lto.setOpticalDriveSpeed(le.getOpticalDriveSpeed());
			lto.setOs(le.getOs());
			lto.setPrice(le.getPrice());
			lto.setPublishDate(le.getPublishDate());
			lto.setRamSize(le.getRamSize());
			lto.setRamSlot(le.getRamSlot());
			lto.setRamType(le.getRamType());
			lto.setResolutionHorizontal(le.getResolutionHorizontal());
			lto.setResolutionVertical(le.getResolutionVertical());
			lto.setScreenSize(le.getScreenSize());
			lto.setSsdSize(le.getSsdSize());
			lto.setTouchScreen(le.isTouchScreen());
			lto.setUsb_2_slot(le.getUsb_2_slot());
			lto.setUsb_3_slot(le.getUsb_3_slot());
			lto.setUsbPortType(le.getUsbPortType());
			lto.setWarranty(le.getWarranty());
			lto.setWifiModel(le.getWifiModel());
			ld.insert(lto);

		} catch (IOException e) {
			throw new ServiceException("Unable to add new laptop", e);
		}

	}

}
