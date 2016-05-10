package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.LaptopDao;
import jp.co.worksap.stm.solaris.dto.LaptopDto;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopListEntity;
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
			dtoList = ld.getAll(e.getStart(), e.getLength());
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
		try {
			ld.deleteByName(name);
		} catch (IOException e) {
			throw new ServiceException(
					"Unable to delete the laptop with name: ", e);
		}
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
			lto.setBluetooth(le.getBluetooth());
			lto.setBrand(le.getBrand());
			lto.setCameraPixel(le.getCameraPixel());

			List<String> cardReaderTypes = le.getCardReaderTypes();
			String cardReaderTypeString = "";
			for (int i = 0; i < cardReaderTypes.size(); i++) {
				cardReaderTypeString += cardReaderTypes.get(i);
				// add spliter when it is not the last element
				if (i < cardReaderTypes.size() - 1) {
					cardReaderTypeString += ",";
				}
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

			List<String> imagePaths = le.getImagePath();
			String imagePathString = "";
			for (int i = 0; i < imagePaths.size(); i++) {
				imagePathString += imagePaths.get(i);
				// add spliter when it is not the last element
				if (i < imagePaths.size() - 1) {
					imagePathString += ",";
				}
			}
			lto.setImagePath(imagePathString);
			lto.setLaptop_height(le.getLaptop_height());
			lto.setLaptop_length(le.getLaptop_length());
			lto.setLaptop_weight(le.getLaptop_weight());
			lto.setLaptop_width(le.getLaptop_width());
			lto.setName(le.getName());
			lto.setOpticalDrive(le.getOpticalDrive());
			lto.setOpticalDriveSpeed(le.getOpticalDriveSpeed());
			lto.setOs(le.getOperating_system());
			lto.setPrice(le.getPrice());
			lto.setPublishDate(le.getPublishDate());
			lto.setRamSize(le.getRamSize());
			lto.setResolutionHorizontal(le.getResolutionHorizontal());
			lto.setResolutionVertical(le.getResolutionVertical());
			lto.setScreenSize(le.getScreenSize());
			lto.setTouchScreen(le.isTouchScreen());
			lto.setUsb_2_slot(le.getUsb_2_slot());
			lto.setUsb_3_slot(le.getUsb_3_slot());
			lto.setUsbPortType(le.getUsbPortType());
			lto.setWarranty(le.getWarranty());
			ld.insert(lto);

		} catch (IOException e) {
			throw new ServiceException("Unable to add new laptop", e);
		}

	}

	@Override
	public LaptopListEntity filter(LaptopFetchEntity lfe) throws ServiceException {
		List<LaptopDto> laptopList = null;
		int count = 0;
		try {
			laptopList = ld.filter(lfe.getSearchParam().toLowerCase(), lfe.getStart(), lfe.getLength());
			count = ld.getFilteredCount(lfe.getSearchParam().toLowerCase());
			
		}catch (IOException e) {
			throw new ServiceException("Error occured in filtering", e);
		}
		List<LaptopEntity> entityList = new ArrayList<LaptopEntity>();
		for (LaptopDto dto: laptopList){
			entityList.add(new LaptopEntity(dto));
		}
		return new LaptopListEntity(lfe.getDraw(), count, count, entityList);
	}

}
