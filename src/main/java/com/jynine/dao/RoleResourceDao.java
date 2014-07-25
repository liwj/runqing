package com.jynine.dao;

import com.jynine.model.RoleResource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceDao {


    int insert(RoleResource roleResource);

    int insertSelective(RoleResource roleResource);



}
