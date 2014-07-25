package com.jynine.dao;

import java.util.List;

import com.jynine.model.DormitoryBuilding;
import com.jynine.model.DormitoryRoom;

public interface DormitoryBuildingDao {

    int deleteByPrimaryKey(Integer dbId);

    int insert(DormitoryBuilding record);

    int insertSelective(DormitoryBuilding record);


    DormitoryBuilding selectByPrimaryKey(Integer dbId);

    int updateByPrimaryKeySelective(DormitoryBuilding record);

    int updateByPrimaryKey(DormitoryBuilding record);
    
    void insertRooms(List<DormitoryRoom> list);
}