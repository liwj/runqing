package com.jynine.dao;

import com.jynine.model.Source;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceDao {


    int deleteByPrimaryKey(String sourceid);

    int insert(Source source);

    int insertSelective(Source source);


    Source selectByPrimaryKey(String sourceid);



    int updateByPrimaryKeySelective(Source source);

    int updateByPrimaryKey(Source source);
    /**
     * 查询所有资源
     * @return
     */
    List<Source> queryAllSources();
    /**
     * 通过角色id查询资源
     * @param roleId
     * @return
     */
    List<Source> querySourcesByRoleId(Integer roleId);
}
