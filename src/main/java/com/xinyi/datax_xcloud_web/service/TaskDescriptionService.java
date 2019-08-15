package com.xinyi.datax_xcloud_web.service;

import com.xinyi.datax_xcloud_web.entity.TaskDescription;

import java.util.List;
import java.util.Map;

public interface TaskDescriptionService {

	/**
	 * 获取任务列表
	 * 
	 * @return
	 */
	List getTaskDescriptionList();

	/**
	 * 通过tdTaskId获取任务详情
	 * 
	 * @param tdTaskId
	 * @return
	 */
	List getTaskDescriptionById(int tdTaskId);

	/**
	 * 增加任务
	 * 
	 * @param taskDescription
	 * @return
	 */
	Map<String,String> addTaskDescription(TaskDescription taskDescription);

	/**
	 * 修改任务
	 * 
	 * @param taskDescription
	 * @return
	 */
	Map<String,String> modifyTaskDescription(TaskDescription taskDescription);

	/**
	 * 删除任务
	 * 
	 * @param tdTaskId
	 * @return
	 */
	Map<String,String> deleteTaskDescription(int tdTaskId);

}
