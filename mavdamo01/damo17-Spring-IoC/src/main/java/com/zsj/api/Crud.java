package com.zsj.api;

public interface Crud {
    int saveSoldier(String soldierName);

    int removeSoldier(int soldierId);

    int updateSoldier(int soldierId, String soldierName);

    String getSoldierNameById(int soldierId);
}
