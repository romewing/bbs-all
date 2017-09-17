package cn.upsoftinc.bbs.forum.rest;


import cn.upsoftinc.bbs.forum.entities.Forum;
import cn.upsoftinc.bbs.forum.mapper.ForumMapper;
import cn.upsoftinc.common.ListResult;
import cn.upsoftinc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "板块管理接口")
@RestController
@RequestMapping("/forum")
@Slf4j
public class ForumServiceRest {

    @Autowired
    private ForumMapper forumMapper;

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @Transactional
    public Result add(Forum forum) {
        forumMapper.insert(forum);
        return Result.TURE;
    }

    public Result delete(String key) {
        return null;
    }

    public Result update(String id, Forum forum) {
        return null;
    }

    @RequestMapping(value = {"{id}",""}, method = RequestMethod.GET)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    public Result query(@PathVariable(required = false) @ApiParam(required = false) Integer id, @RequestParam(value = "id",required = false,defaultValue = "0") Integer parent) {
        List<Forum> select = forumMapper.select(id, parent);
        ListResult<Forum> result = new ListResult<>();
        result.setData(select);
        return result;
    }
}
