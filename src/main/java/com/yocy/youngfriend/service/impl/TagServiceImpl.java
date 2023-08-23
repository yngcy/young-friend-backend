package com.yocy.youngfriend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yocy.youngfriend.mapper.TagMapper;
import com.yocy.youngfriend.model.domain.Tag;
import com.yocy.youngfriend.service.TagService;
import org.springframework.stereotype.Service;

/**
* @author 25055
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2023-08-05 22:52:53
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




