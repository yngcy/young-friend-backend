package com.yocy.youngfriend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yocy.youngfriend.model.domain.Team;
import com.yocy.youngfriend.model.domain.User;
import com.yocy.youngfriend.model.dto.TeamQuery;
import com.yocy.youngfriend.model.request.TeamJoinRequest;
import com.yocy.youngfriend.model.request.TeamQuitRequest;
import com.yocy.youngfriend.model.request.TeamUpdateRequest;
import com.yocy.youngfriend.model.vo.TeamUserVO;

import java.util.List;


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

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    Boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    Boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
