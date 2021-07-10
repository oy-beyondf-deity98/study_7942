package pe.kr.deity.salesforce.master.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 차량
@Entity
@Getter
@Setter
public class Vehicle {

    // 순번
    @Id
    @Column
    private Integer seq;

    // 차량 번호
    @Column
    private String vehicleNo;

    // Vehicle 모델 복사
    public void CopyData(Vehicle param)
    {
        this.seq = param.getSeq();
        this.vehicleNo = param.getVehicleNo();
    }
}