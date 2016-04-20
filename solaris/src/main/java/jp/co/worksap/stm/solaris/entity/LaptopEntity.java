package jp.co.worksap.stm.solaris.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.LaptopDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LaptopEntity {

	private String name;
	private String brand;
	private Date publishDate;
	private BigDecimal price;
	// private List<String> tags;
	private int laptop_width;
	private int laptop_height;
	private int laptop_length;
	private int laptop_weight;
	private float screenSize;
	private String os;
	private String cpu;
	private int ramSize;
	private int hddSize;
	private String hddModel;
	private int resolutionHorizontal;
	private int resolutionVertical;
	private boolean isTouchScreen;
	private String gpu;
	private String graphicsCardType;
	private int graphicMemory;
	private float batteryLife;
	private int batteryCells;
	private String opticalDrive;
	private int opticalDriveSpeed;
	private boolean hasTrackPoint;
	private boolean hasFrontCamera;
	private float cameraPixel;
	private boolean hasVGAPort;
	private boolean hasHDMIPort;
	private String usbPortType;
	private int usb_2_slot;
	private int usb_3_slot;
	private List<String> cardReaderTypes;
	private String bluetooth;
	private String antivirusSoftware;
	private boolean hasBag;
	private int warranty;
	private List<String> imagePath;

	public LaptopEntity(LaptopDto ld) {

		this.antivirusSoftware = ld.getAntivirusSoftware();
		this.batteryCells = ld.getBatteryCells();
		this.batteryLife = ld.getBatteryLife();
		this.bluetooth = ld.getBluetooth();
		this.brand = ld.getBrand();
		this.cameraPixel = ld.getCameraPixel();

		String cardReaderTypes = ld.getCardReaderTypes();
		String[] types = cardReaderTypes.split(",");
		List<String> typeList = new ArrayList<String>();
		for (String type : types) {
			if (type.length() > 0) {
				typeList.add(type);
			}
		}
		this.cardReaderTypes = typeList;

		this.cpu = ld.getCpu();
		this.gpu = ld.getGpu();
		this.graphicMemory = ld.getGraphicMemory();
		this.graphicsCardType = ld.getGraphicsCardType();
		this.hasBag = ld.isHasBag();
		this.hasFrontCamera = ld.isHasFrontCamera();
		this.hasHDMIPort = ld.isHasHDMIPort();
		this.hasTrackPoint = ld.isHasTrackPoint();
		this.hasVGAPort = ld.isHasVGAPort();
		this.hddModel = ld.getHddModel();
		this.hddSize = ld.getHddSize();

		String imagePathString = ld.getImagePath();
		if (imagePathString != null) {
			String[] paths = imagePathString.split(",");
			List<String> pathList = new ArrayList<String>();
			for (String path : paths) {
				if (path.length() > 0) {
					pathList.add(path);
				}
			}
			this.imagePath = pathList;
		} else {
			this.imagePath = null;
		}

		this.isTouchScreen = ld.isTouchScreen();
		this.laptop_height = ld.getLaptop_height();
		this.laptop_length = ld.getLaptop_length();
		this.laptop_weight = ld.getLaptop_weight();
		this.laptop_width = ld.getLaptop_width();
		this.name = ld.getName();
		this.opticalDrive = ld.getOpticalDrive();
		this.opticalDriveSpeed = ld.getOpticalDriveSpeed();
		this.os = ld.getOs();
		this.price = ld.getPrice();
		this.publishDate = ld.getPublishDate();
		this.ramSize = ld.getRamSize();
		this.resolutionHorizontal = ld.getResolutionHorizontal();
		this.resolutionVertical = ld.getResolutionVertical();
		this.screenSize = ld.getScreenSize();
		this.usb_2_slot = ld.getUsb_2_slot();
		this.usb_3_slot = ld.getUsb_3_slot();
		this.usbPortType = ld.getUsbPortType();
		this.warranty = ld.getWarranty();
	}

}
