package cn.upsoftinc.bbs.forum.mapper.provider;


import cn.upsoftinc.bbs.forum.entities.Forum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class ForumProvider{

    public static final String TABLE = "forum";

    public String insert() {
        String sql = new SQL(){{
                INSERT_INTO(TABLE);
                VALUES("number, name", "#{forum.number}, #{forum.name}");
        }}.toString();
        return sql;
    }

    public String select(Map<String, Object> params) {
        String sql = new SQL(){{
            SELECT("f.id, f.number, f.name, f.status,f.parent, f.create_date");
            FROM(TABLE+" f");
            if(params.get("id") != null) {
                WHERE("f.id = #{id}");
            }
            if(params.get("parent") != null) {
                WHERE("f.parent = #{parent}" );
            }
            else {
                WHERE("f.parent is null");
            }
        }}.toString();
        return sql;
    }
}

