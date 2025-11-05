package com.zsj.imp;

import com.zsj.annotation.dop;
import com.zsj.api.Crud;
import org.springframework.stereotype.Component;

@Component
public class CrudImp implements Crud {
    @Override

    public int saveSoldier(String soldierName) {
        System.out.println("保存了:"+soldierName);

        return 0;
    }

    @Override
    public int removeSoldier(int soldierId) {
        System.out.println("删除了:"+soldierId);
        return 0;
    }

    @Override
    public int updateSoldier(int soldierId, String soldierName) {
        System.out.println("修改了:"+soldierId+"--"+soldierName);

        return 0;
    }

    @Override
    public String getSoldierNameById(int soldierId) {
        System.out.println("查询了:"+soldierId);
        return "";
    }
}
