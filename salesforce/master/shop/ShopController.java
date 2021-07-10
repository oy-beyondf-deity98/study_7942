package pe.kr.deity.salesforce.master.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.kr.deity.salesforce.master.MasterController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController extends MasterController<Shop,Integer>{

    ShopService service;

    public ShopController(ShopService service){
        this.service = service;
    }

    @RequestMapping("/tempList")
    public List<Shop> tempList(){

        Shop shop1 = new Shop();

        Shop shop2 = new Shop();


        shop1.setSeq(1);shop1.setShopName("나훈자");shop1.setShopAddress("신대방");
        shop2.setSeq(2);shop2.setShopName("세훈자");shop2.setShopAddress("이천");

        List<Shop> list = new ArrayList<>();
        list.add(shop1);
        list.add(shop2);

        return list;
    }
}
