package jp.co.worksap.stm.solaris.entity.laptop;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopListEntity {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<LaptopEntity> laptopEntities;	
}
