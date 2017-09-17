package cn.upsoftinc.bbs.post.service;

import cn.upsoftinc.common.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("forum")
public interface ForumService {

    @RequestMapping(method = RequestMethod.PUT, value = "/forum")
    Result add(JSON json);

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    JSONObject query(@PathVariable("id") int id);
}