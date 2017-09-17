package cn.upsoftinc.bbs.post.rest;


import cn.upsoftinc.bbs.post.service.ForumService;
import cn.upsoftinc.common.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRest {

    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Result query = forumService.query(1);
        return "success";
    }
}
