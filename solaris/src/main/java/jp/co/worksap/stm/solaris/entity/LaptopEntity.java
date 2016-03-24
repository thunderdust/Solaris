package jp.co.worksap.stm.solaris.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data	
public class LaptopEntity {

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

}
