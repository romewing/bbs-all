package cn.upsoft.bbs.web.service;


import cn.upsoftinc.common.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("forum")
public interface ForumService {

    @RequestMapping(value = {"/forum"}, method = RequestMethod.GET)
    JSONObject query(@RequestParam(value = "id",required = false) Integer parent) ;
}
