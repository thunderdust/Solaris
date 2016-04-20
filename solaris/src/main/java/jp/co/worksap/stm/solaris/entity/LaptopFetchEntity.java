package jp.co.worksap.stm.solaris.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LaptopFetchEntity {

	private String name;
	private String brand;
	private Date publishDate;
	private BigDecimal price;
	//private List<String> tags;
	private int laptop_width;
	private int laptop_height;
	private int laptop_length;
	private int laptop_weight;
	private float screenSize;
	private String os;
	private String cpu;
	private int ramSize;
	private String hddModel;
	private int hddSize;
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
	private int usb_2_slot;
	private int usb_3_slot;
	private String usbPortType;
	private boolean hasVGAPort;
	private boolean hasHDMIPort;
	private String cardReaderTypes;
	private String bluetooth;
	private String antivirusSoftware;
	private boolean hasBag;
	private int warranty;
	private String imagePath;

	private String searchParam;
	private int draw;
	private int start;
	private int length;

}
