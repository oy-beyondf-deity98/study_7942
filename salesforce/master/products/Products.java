package pe.kr.deity.salesforce.master.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 제품
@Entity
@Getter
@Setter
public class Products {

    // 제품 코드
    @Id
    @Column
    private String producksCd;

    // 제품 명
    @Column
    private String producksNm;

    // Products 모델 복사
    public void CopyData(Products param)
    {
        this.producksCd = param.getProducksCd();
        this.producksNm = param.getProducksNm();
    }
}
