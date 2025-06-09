package com.codeqm.service.impl;

import com.codeqm.mapper.ScheduleMapper;
import com.codeqm.pojo.Schedule;
import com.codeqm.service.ScheduleService;
import com.codeqm.util.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @since: 2025/6/9 16:00
 * @author: qm
 * @description:
 */
@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public PageBean<Schedule> findByPage(int pageSize, int currentPage) {
        log.info("分页查询参数: pageSize={}, currentPage={}", pageSize, currentPage);
        PageHelper.startPage(currentPage, pageSize); // 1.设置分页参数
        List<Schedule> list = scheduleMapper.queryPage(); // 2.数据库查询
        PageInfo<Schedule> pageInfo = new PageInfo<>(list); // 3.结果获取
        PageBean<Schedule> pageBean = new PageBean<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getList()); // 4.pageBean封装
        log.info("分页查询结果:{}", pageBean);
        return pageBean;
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }

    @Override
    public void removeById(Integer id) {
        scheduleMapper.delete(id);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleMapper.update(schedule);
    }
}
