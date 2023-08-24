package com.yocy.youngfriend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yocy.youngfriend.mapper.UserTeamMapper;
import com.yocy.youngfriend.model.domain.UserTeam;
import com.yocy.youngfriend.service.UserTeamService;

import org.springframework.stereotype.Service;

/**
* @author 25055
* @description 针对表【user_team(用户 - 队伍)】的数据库操作Service实现
* @createDate 2023-08-23 19:30:56
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




