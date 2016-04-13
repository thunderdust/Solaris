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
public class LaptopCreationEntity {

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

}
