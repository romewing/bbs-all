package cn.upsoftinc.bbs.forum.mapper;

import cn.upsoftinc.bbs.forum.entities.Forum;
import cn.upsoftinc.bbs.forum.mapper.provider.ForumProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ForumMapper {

    @InsertProvider(type = ForumProvider.class, method = "insert")
    void insert(@Param("forum") Forum forum);


    @SelectProvider(type = ForumProvider.class, method = "select")
    @Results(value = {
            @Result(column = "create_date", property = "createDate")
    })
    List<Forum> select(@Param("id") Integer id, @Param("parent") Integer parent);
}
