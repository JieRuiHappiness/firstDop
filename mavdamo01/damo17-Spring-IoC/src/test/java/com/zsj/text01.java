package com.zsj;

import com.zsj.api.Mathes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class text01 {
    @Autowired
    Mathes math;
    @Test
    public void test(){
        int add = math.add(10, 2);
        math.div(10,2);
        math.mul(10,2);
        math.sub(10,2);
//        System.out.println("add = " + add);
    }

}

