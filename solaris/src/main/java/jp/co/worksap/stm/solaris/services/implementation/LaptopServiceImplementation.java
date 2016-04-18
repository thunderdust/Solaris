package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.LaptopDao;
import jp.co.worksap.stm.solaris.dto.EmployeeDto;
import jp.co.worksap.stm.solaris.dto.LaptopDto;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.entity.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.entity.LaptopEntity;
import jp.co.worksap.stm.solaris.entity.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.LaptopListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service
public class LaptopServiceImplementation implements LaptopService {

	@Autowired
	LaptopDao ld;

	@Override
	public LaptopListEntity getAll(LaptopFetchEntity e) throws ServiceException {
		List<LaptopDto> dtoList = null;
		int count = 0;
		try {
			dtoList = ld.getAll();
			count = ld.getTotalCount();

		} catch (IOException ie) {
			throw new ServiceException("Error get all laptops", ie);
		}

		List<LaptopEntity> entities = Lists.newArrayList();
		for (LaptopDto dto : dtoList) {
			LaptopEntity newEntity = new LaptopEntity(dto);
			entities.add(newEntity);
		}

		return new LaptopListEntity(e.getDraw(), count, count, entities);
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

			List<String> cardReaderTypes = le.getCardReaderTypes();
			String cardReaderTypeString = null;
			for (String type : cardReaderTypes) {
				cardReaderTypeString += type;
				cardReaderTypeString += ",";
			}
			lto.setCardReaderTypes(cardReaderTypeString);

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

			List<String> imagePaths = le.getImagePath();
			String imagePathString = null;
			for (String path : imagePaths) {
				imagePathString += path;
				imagePathString += ",";
			}
			lto.setImagePath(imagePathString);

			lto.setLaptop_height(le.getLaptop_height());
			lto.setLaptop_length(le.getLaptop_length());
			lto.setLaptop_weight(le.getLaptop_weight());
			lto.setLaptop_width(le.getLaptop_width());
			lto.setName(le.getName());
			lto.setOfficeSuiteVersion(le.getOfficeSuiteVersion());
			lto.setOpticalDrive(le.getOpticalDrive());
			lto.setOpticalDriveSpeed(le.getOpticalDriveSpeed());
			lto.setOs(le.getOperating_system());
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
			lto.setWifiModel(le.getWifiMode());
			ld.insert(lto);

		} catch (IOException e) {
			throw new ServiceException("Unable to add new laptop", e);
		}

	}

}
