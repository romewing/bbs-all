package cn.upsoft.bbs.web.controller;

import cn.upsoft.bbs.web.service.ForumService;
import cn.upsoftinc.common.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping("/forum")
    String forum(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "forum";
    }

    @GetMapping("/forum/list")
    @ResponseBody
    JSONArray list(@RequestParam(value = "id",required = false) Integer parent) {
        JSONObject result = forumService.query(parent);
        JSONArray data = result.getJSONArray("data");
        data.forEach(item -> {
            if(item instanceof Map) {
                ((Map) item).put("text", ((Map) item).get("name"));
                ((Map) item).put("state", "closed");
            }
        });
        return data;
    }
    @GetMapping("/forum/test")
    @ResponseBody
    String test() {
        return "{\"page\":0,\"results\":[{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e30daf2660645\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"客户信息\",\"permission\":\"test:testordercustomer\",\"url\":\"test/testordercustomer\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"2c91fb725e28913a015e4a6722ab129f\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"user\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e4fb3b3db16d6\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"powername\",\"permission\":\"juu:codegencolumn\",\"url\":\"juu/codegencolumn\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e5583e16e1be7\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"user\",\"permission\":\"user:sysuser\",\"url\":\"user/sysuser\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e6fb88a1e2d15\",\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"fadfa\",\"permission\":\"fadf\",\"url\":\"fasdfa\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e74fbe5073185\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"ccccc\",\"permission\":\"brush:codegencolumn\",\"url\":\"brush/codegencolumn\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e8b4a524b402a\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"hhh\",\"permission\":\"hhh:sysmenu\",\"url\":\"hhh/sysmenu\"},{\"expanded\":false,\"hasChildren\":false,\"id\":\"2c91fb725e28913a015e7e5a14b336f9\",\"isshow\":1,\"leaf\":true,\"level\":0,\"loaded\":false,\"name\":\"我的天啊\",\"permission\":\"\",\"url\":\"www.baidu.com\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85a5eecc6015a5ef6ce870002\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"用户管理\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"4028ea815a78e9e6015a78f1dc9d0000\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"代码生成器\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85a5eecc6015a5ef22ad80001\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"系统设置\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"4028ea815a701416015a7075b4f9001f\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"系统监控\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85cf8276b015cf82debcb005b\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"常见工具\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40281e815c912406015c9149f7b80044\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"通知公告\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85bea9452015beaa7f25a0000\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"邮箱设置\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85c8593cd015c859f47960016\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"短信设置\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85c9eeb5c015c9f4d1f8e0000\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"统计报表\",\"permission\":\"\",\"url\":\"\"},{\"expanded\":false,\"hasChildren\":true,\"id\":\"40288ab85c1ae76c015c1b12b68a0000\",\"isshow\":1,\"leaf\":false,\"level\":0,\"loaded\":false,\"name\":\"代码案例\",\"permission\":\"\",\"url\":\"\"}],\"rows\":9223372036854775807,\"total\":9223372036854775807,\"totalPages\":1}";
    }

}
