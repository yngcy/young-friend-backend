package com.yocy.youngfriend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yocy.youngfriend.model.domain.Team;
import com.yocy.youngfriend.model.domain.User;


/**
* @author 25055
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-08-23 19:29:26
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @return
     */
    long addTeam(Team team, User loginUser);
}
