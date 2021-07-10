package pe.kr.deity.salesforce.master.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 사원
@Entity
@Getter
@Setter
public class Employee {

    // 사원 아이디
    @Id
    @Column
    private String employeeId;

    // 사원 이름
    @Column
    private String employeeName;

    // Employee 모델 복사
    public void CopyData(Employee param)
    {
        this.employeeId = param.getEmployeeId();
        this.employeeName = param.getEmployeeName();
    }
}
