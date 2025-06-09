package com.codeqm.service;

import com.codeqm.pojo.Schedule;
import com.codeqm.util.PageBean;

/**
 * @since: 2025/6/9 16:00
 * @author: qm
 * @description:
 */
public interface ScheduleService {
    PageBean<Schedule> findByPage(int pageSize, int currentPage);

    void saveSchedule(Schedule schedule);

    void removeById(Integer id);

    void updateSchedule(Schedule schedule);
}
