package com.yocy.youngfriend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YounGCY
 * @date 2023-8-24 下午 6:27
 * @description 用户退出队伍请求参数
 */
@Data
public class TeamQuitRequest implements Serializable {
    private static final long serialVersionUID = 5313675491515072563L;
    private Long teamId;
}
