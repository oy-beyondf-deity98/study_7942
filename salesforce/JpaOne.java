package pe.kr.deity.salesforce;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.kr.deity.salesforce.master.shop.Shop;

public interface JpaOne extends JpaRepository<Shop,Integer> {
}
