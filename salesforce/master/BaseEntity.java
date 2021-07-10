package pe.kr.deity.salesforce.master;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
@Setter
public abstract class BaseEntity<M extends BaseEntity<?>>{

    //출처: https://coding-start.tistory.com/136 [코딩스타트]

    //key도 따로 정의했어면 좋겠는데... 번거롭다. key값이 모두 다르므로...
    //그와는다르게 output으로 rowId값을 내려주어야한다.

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "RNB_SEQ_GENERATOR")
    private long id;

    @Column(name="CREATED_DATE",nullable=true,updatable=true)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable=true)
    @CreatedBy
    private String createdUser;

    @Column(name="UPDATED_DATE",nullable=true)
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(nullable=true)
    @LastModifiedBy
    private String updatedUser;

//    @Override
//    public int compareTo(M o) {
//        Long result = getId()-o.getId();
//        return result.intValue();
//    }

}
