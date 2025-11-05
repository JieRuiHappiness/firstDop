package com.zsj;

import com.zsj.api.Crud;
import com.zsj.api.Mathes;
import com.zsj.service.TigerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class text01 {
    @Autowired
    Mathes math;
    @Autowired
    Crud crud;
    @Test
    public void test(){
        int add = math.add(10, 2);
        math.div(10,2);
        math.mul(10,2);
        math.sub(10,2);
//        System.out.println("add = " + add);
    }
    @Test
public void test2(){
        crud.getSoldierNameById(1);
        crud.removeSoldier(1);
        crud.saveSoldier("张三");
        crud.updateSoldier(1,"张三");

}
@Autowired
TigerService tigerService;
@Test
public void test3(){

    System.out.println(tigerService.quiry());
    System.out.println(tigerService.quiry());
}
}

