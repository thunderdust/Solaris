package jp.co.worksap.stm.solaris.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.LaptopDto;
import lombok.Data;

@Data
public class LaptopPresentationEntity {
	private int id;
	private String name;
	private String brand;
	private Date publishDate;
	private BigDecimal price;
	private List<String> tags;
	private int width;
	private int height;
	private int length;
	private int weight;
	private float screenSize;
	private String installedOS;
	private String cpu;
	private String ramType;
	private String ramSlot;
	private int ramSize;
	private int hddSize;
	private String hddModel;
	private int hddSpinSpeed;
	private int ssdSize;
	private String resolution;
	private boolean isTouchScreen;
	private String gpu;
	private String graphicsCardType;
	private int graphicMemory;
	private int batteryVolume;
	private float batteryLife;
	private int batteryCells;
	private String opticalDrive;
	private String opticalDriveSpeed;
	private String touchpadSize;
	private String keyboardType;
	private boolean hasTrackPoint;
	private boolean hasFrontCamera;
	private float cameraPixel;
	private int usbPortCount;
	private boolean hasVGAPort;
	private boolean hasHDMIPort;
	private List<String> usbPortType;
	private List<String> cardReaders;
	private String bluetooth;
	private String wifiModel;
	private boolean hasOfficeSuite;
	private String antivirusSoftware;
	private boolean hasBag;
	private int warranty;

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
		this.cardReaders = ld.getCardReaders();
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
		this.height = ld.getHeight();
		this.id = ld.getId();
		this.installedOS = ld.getInstalledOS();
		this.isTouchScreen = ld.isTouchScreen();
		this.keyboardType = ld.getKeyboardType();
		this.length = ld.getLength();
		this.name = ld.getName();
		this.opticalDrive = ld.getOpticalDrive();
		this.opticalDriveSpeed = ld.getOpticalDriveSpeed();
		this.price = ld.getPrice();
		this.publishDate = ld.getPublishDate();
		this.ramSize = ld.getRamSize();
		this.ramSlot = ld.getRamSlot();
		this.ramType = ld.getRamType();
		this.resolution = ld.getResolution();
		this.screenSize = ld.getScreenSize();
		this.ssdSize = ld.getSsdSize();
		this.tags = ld.getTags();
		this.touchpadSize = ld.getTouchpadSize();
		this.usbPortCount = ld.getUsbPortCount();
		this.usbPortType = ld.getUsbPortType();
		this.warranty = ld.getWarranty();
		this.weight = ld.getWeight();
		this.width = ld.getWidth();
		this.wifiModel = ld.getWifiModel();

	}

}
