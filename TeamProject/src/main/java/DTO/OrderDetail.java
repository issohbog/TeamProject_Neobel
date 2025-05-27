package DTO;

import com.alohaclass.jdbc.annotation.Column;
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
	private int orderNo; 			// 주문 고유 번호
	private int productNo;			// 상품 고유 번호 
	private int quantity; 			// 수량 
	private int price; 				// 가격 
	
    @Column(exist = false)
	Order order;						// 주문 번호 (join용)
    
    @Column(exist = false)
	Product product;					// 주문한 상품 정보(join용)
	
}
