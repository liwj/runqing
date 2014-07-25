package com.jynine.dao;

import com.jynine.model.DormitoryRoom;

public interface DormitoryRoomDao {

    int insert(DormitoryRoom record);

    int insertSelective(DormitoryRoom record);
}