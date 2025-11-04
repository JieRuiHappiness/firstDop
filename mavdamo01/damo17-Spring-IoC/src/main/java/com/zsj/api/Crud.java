package com.zsj.api;

public interface Crud {
    int saveSoldier(String soldierName);

    int removeSoldier(Integer soldierId);

    int updateSoldier(Integer soldierId, String soldierName);

    String getSoldierNameById(Integer soldierId);
}
