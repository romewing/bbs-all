package cn.upsoftinc.bbs.forum.entities;



import cn.upsoftinc.common.TreeNode;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
public class Forum implements Serializable, TreeNode<Integer>{

    private Integer id;

    private String number;

    private String name;

    private Date createDate;

    private int status;

    private int level;

    private Integer parentId;

}
