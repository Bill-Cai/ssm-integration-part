package com.codeqm.mapper;

import com.codeqm.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @since: 2025/6/9 16:00
 * @author: qm
 * @description:
 */
@Mapper
public interface ScheduleMapper {
    List<Schedule> queryPage();
    void insert(Schedule schedule);
    void delete(Integer id);
    void update(Schedule schedule);
}
