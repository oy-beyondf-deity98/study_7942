package pe.kr.deity.salesforce.master.shop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


// 가계
@Entity
@Getter
@Setter
public class Shop {

    // 순번
    @Id
    @Column
    private Integer seq;

    // 가계 이름
    @Column
    private String shopName;

    // 가계 주소
    @Column
    private String shopAddress;

    // Shop 모델 복사
//    public void CopyData(Shop param)
//    {
//        this.seq = param.getSeq();
//        this.shopName = param.getShopName();
//        this.shopAddress = param.getShopAddress();
//    }
}