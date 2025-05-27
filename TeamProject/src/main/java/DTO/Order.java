package DTO;

import java.util.Date;
import java.util.List;

import com.alohaclass.jdbc.annotation.Column;
import com.alohaclass.jdbc.annotation.Pk;
import com.alohaclass.jdbc.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table("orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	
	@Pk
	private int orderNo;			// 주문 고유 번호
	private int userNo;				// 회원 고유 번호 
	private int totalPrice;			// 총 주문 금액
	private Date orderDate;			// 주문 일자
	private String payment;			// 결제 방법 
	private String name; 			// 받는분 성함
	private String postCode;		// 우편 번호
	private String addr; 			// 주소
	private String addrDetail;		// 상세 주소  
	private String phone;			// 전화번호
	private String req; 			// 배송요청사항  
	private String orderCode;		// UI 용 주문번호  
	
    @Column(exist = false)
	User user;						// 주문한 회원 정보 (join용)
    
    private List<OrderDetail> detailList;	// 한 주문 내 각 상품 상세정보 
    
    @Column(exist = false)
    private String orderTitle;		// 주문 전체 목록 제목(외 N개 구현 용) 
    

    
    
}
