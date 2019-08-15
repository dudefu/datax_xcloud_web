package com.xinyi.datax_xcloud_web.dao;

import com.xinyi.datax_xcloud_web.entity.Area;
import com.xinyi.datax_xcloud_web.entity.TaskDescription;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class TaskDescriptionDaoTest {

    //通过spring容器注入Dao的实现类
    @Autowired
    private TaskDescriptionDao taskDescriptionDao ;
    @Test
    public void queryTaskDescription() {
        List<TaskDescription> taskDescriptionList = taskDescriptionDao.queryTaskDescription();
        // 验证预期值和实际值是否相符
        assertEquals(1, taskDescriptionList.size());
    }

    @Test
    public void queryTaskDescriptionById() {
    }

    @Test
    public void insertTaskDescription() {
    }

    @Test
    public void updateTaskDescription() {
    }

    @Test
    public void deleteTaskDescription() {
    }
}