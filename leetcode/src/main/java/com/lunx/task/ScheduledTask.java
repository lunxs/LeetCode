package com.lunx.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTask {

    private static long COUNT = 0L;


    @Scheduled(cron = "${task.cron:0/30 * * * * ?}")
    public void scheduled() {
        System.out.println("Scheduled 定时任务 start, 第" + ++COUNT + "次运行");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss SSS")));
        System.out.println("Scheduled 定时任务 end");
    }
}
