package com.zsj.imp;

import com.zsj.annotation.dop;
import com.zsj.api.Mathes;
import org.springframework.stereotype.Component;

@Component
public class MathImp implements Mathes {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
@dop
    @Override
    public int div(int i, int j) {
        int result = i / j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
}
