package DTO;


import com.alohaclass.jdbc.annotation.Pk;
import com.alohaclass.jdbc.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
	
	@Pk
	private int productNo; 			// 상품 고유번호
	private String ProductName; 	// 상품명
	private String image_name; 		// 이미지 이름 
	private String image_path;		// 이미지 경로 
	private String description; 	// 상품 상세 설명
	private int price; 				// 상품 가격 
}
