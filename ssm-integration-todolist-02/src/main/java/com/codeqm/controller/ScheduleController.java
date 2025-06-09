package com.codeqm.controller;

import com.codeqm.pojo.Schedule;
import com.codeqm.service.ScheduleService;
import com.codeqm.util.CustomResponse;
import com.codeqm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @since: 2025/6/9 16:00
 * @author: qm
 * @description:
 */
@CrossOrigin  // 解决跨域问题, 允许所有来源的请求
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{currentPage}")
    public CustomResponse showList(@PathVariable(name = "pageSize") int pageSize, @PathVariable(name = "currentPage") int currentPage) {
        PageBean<Schedule> pageBean = scheduleService.findByPage(pageSize, currentPage);
        return CustomResponse.ok(pageBean);
    }

    @PostMapping
    public CustomResponse saveSchedule(@RequestBody Schedule schedule) {
        scheduleService.saveSchedule(schedule);
        return CustomResponse.ok(null);
    }

    @DeleteMapping("/{id}")
    public CustomResponse removeSchedule(@PathVariable Integer id) {
        scheduleService.removeById(id);
        return CustomResponse.ok(null);
    }

    @PutMapping
    public CustomResponse changeSchedule(@RequestBody Schedule schedule) {
        scheduleService.updateSchedule(schedule);
        return CustomResponse.ok(null);
    }
}
