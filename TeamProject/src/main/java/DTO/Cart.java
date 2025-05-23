package DTO;

import com.alohaclass.jdbc.annotation.Column;
import com.alohaclass.jdbc.annotation.Pk;
import com.alohaclass.jdbc.annotation.Table; 

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder; 

@Table("Carts")
@Data    
@NoArgsConstructor         // 기본 생성자
@AllArgsConstructor        // 모든 필드 생성자
@Builder
public class Cart {
	@Pk
    private Integer cartNo;       // 장바구니 고유번호
    private Integer userNo;       // 회원 고유번호
    private Integer productNo;    // 상품 고유번호
    private Integer quantity;     // 상품 수량
     
    @Column(exist = false)
    User user;
    @Column(exist = false)
    Product product;
} 