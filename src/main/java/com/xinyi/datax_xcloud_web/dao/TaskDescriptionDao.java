package com.xinyi.datax_xcloud_web.dao;

import com.xinyi.datax_xcloud_web.entity.TaskDescription;

import java.util.List;

public interface TaskDescriptionDao {

    /**
     * 列出任务详情
     *
     * @return taskDescriptionList
     */
    List<TaskDescription> queryTaskDescription();

    /**
     * 根据Id列出具体任务
     *
     * @return tdTaskId
     */
    TaskDescription queryTaskDescriptionById(int tdTaskId);

    /**
     * 插入一条任务
     *
     * @param taskDescription
     * @return
     */
    int insertTaskDescription(TaskDescription taskDescription);

    /**
     * 更新一条任务
     *
     * @param taskDescription
     * @return
     */
    int updateTaskDescription(TaskDescription taskDescription);

    /**
     * 根据taskId,删除一条任务
     *
     * @param taskId
     * @return
     */
    int deleteTaskDescription(int taskId);
}
