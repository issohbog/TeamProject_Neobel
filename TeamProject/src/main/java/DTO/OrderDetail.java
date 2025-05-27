package DTO;

import com.alohaclass.jdbc.annotation.Pk;
import com.alohaclass.jdbc.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
	
	@Pk
	private int orderItemNo; 		// 주문 상세 고유 번호 
	private int quantity; 			// 수량 
	private int price; 				// 가격 
	
}
