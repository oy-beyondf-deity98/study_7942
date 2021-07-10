package pe.kr.deity.salesforce.master.cargo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 창고
@Entity
@Getter
@Setter
public class Cargo {

    // 창고 코드
    @Id
    @Column
    private String cargoCd;

    // 창고 명
    @Column
    private String cargoNm;

    // Cargo 모델 복사
    public void CopyData(Cargo param)
    {
        this.cargoCd = param.getCargoCd();
        this.cargoNm = param.getCargoNm();
    }
}
