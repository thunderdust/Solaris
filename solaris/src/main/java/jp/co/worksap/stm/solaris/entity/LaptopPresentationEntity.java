package jp.co.worksap.stm.solaris.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.LaptopDto;
import lombok.Data;

@Data
public class LaptopPresentationEntity {

	private String name;
	private String brand;
	private Date publishDate;
	private BigDecimal price;
	private List<String> tags;
	private int laptop_width;
	private int laptop_height;
	private int laptop_length;
	private int laptop_weight;
	private float screenSize;
	private String os;
	private String cpu;
	private String ramType;
	private int ramSlot;
	private int ramSize;
	private int hddSize;
	private String hddModel;
	private int hddSpinSpeed;
	private int ssdSize;
	private int resolutionHorizontal;
	private int resolutionVertical;
	private boolean isTouchScreen;
	private String gpu;
	private String graphicsCardType;
	private int graphicMemory;
	private int batteryVolume;
	private float batteryLife;
	private int batteryCells;
	private String opticalDrive;
	private float opticalDriveSpeed;
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
	private String wifiModel;
	private boolean hasOfficeSuite;
	private String officeSuiteVersion;
	private String antivirusSoftware;
	private boolean hasBag;
	private int warranty;
	private List<String> imagePath;

	public LaptopPresentationEntity() {

	}

	public LaptopPresentationEntity(LaptopDto ld) {

		this.antivirusSoftware = ld.getAntivirusSoftware();
		this.batteryCells = ld.getBatteryCells();
		this.batteryLife = ld.getBatteryLife();
		this.batteryVolume = ld.getBatteryVolume();
		this.bluetooth = ld.getBluetooth();
		this.brand = ld.getBrand();
		this.cameraPixel = ld.getCameraPixel();
		this.cardReaderTypes = ld.getCardReaderTypes();
		this.cpu = ld.getCpu();
		this.gpu = ld.getGpu();
		this.graphicMemory = ld.getGraphicMemory();
		this.graphicsCardType = ld.getGraphicsCardType();
		this.hasBag = ld.isHasBag();
		this.hasFrontCamera = ld.isHasFrontCamera();
		this.hasHDMIPort = ld.isHasHDMIPort();
		this.hasOfficeSuite = ld.isHasOfficeSuite();
		this.hasTrackPoint = ld.isHasTrackPoint();
		this.hasVGAPort = ld.isHasVGAPort();
		this.hddModel = ld.getHddModel();
		this.hddSize = ld.getHddSize();
		this.hddSpinSpeed = ld.getHddSpinSpeed();
		this.laptop_height = ld.getLaptop_height();
		this.os = ld.getOs();
		this.isTouchScreen = ld.isTouchScreen();
		this.laptop_length = ld.getLaptop_length();
		this.name = ld.getName();
		this.opticalDrive = ld.getOpticalDrive();
		this.opticalDriveSpeed = ld.getOpticalDriveSpeed();
		this.price = ld.getPrice();
		this.publishDate = ld.getPublishDate();
		this.ramSize = ld.getRamSize();
		this.ramSlot = ld.getRamSlot();
		this.ramType = ld.getRamType();
		this.resolutionHorizontal = ld.getResolutionHorizontal();
		this.resolutionVertical = ld.getResolutionVertical();
		this.screenSize = ld.getScreenSize();
		this.ssdSize = ld.getSsdSize();
		this.tags = ld.getTags();
		this.usbPortType = ld.getUsbPortType();
		this.warranty = ld.getWarranty();
		this.laptop_weight = ld.getLaptop_weight();
		this.laptop_width = ld.getLaptop_width();
		this.wifiModel = ld.getWifiModel();
		this.officeSuiteVersion = ld.getOfficeSuiteVersion();
		this.usb_2_slot = ld.getUsb_2_slot();
		this.usb_3_slot = ld.getUsb_3_slot();
		this.imagePath = ld.getImagePath();

	}

}
