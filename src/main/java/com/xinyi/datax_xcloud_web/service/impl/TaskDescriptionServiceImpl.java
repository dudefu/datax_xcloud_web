package com.xinyi.datax_xcloud_web.service.impl;

import com.xinyi.datax_xcloud_web.dao.TaskDescriptionDao;
import com.xinyi.datax_xcloud_web.entity.TaskDescription;
import com.xinyi.datax_xcloud_web.service.TaskDescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class TaskDescriptionServiceImpl implements TaskDescriptionService {

	private static final Logger logger = LoggerFactory.getLogger(TaskDescriptionServiceImpl.class);
	@Autowired
	private TaskDescriptionDao taskDescriptionDao;

	/**
	 * 获取任务列表
	 *
	 * @return
	 */
	@Override
	public List getTaskDescriptionList() {
		List list = new ArrayList<>();
		Map<String,String> successMap = new HashMap<>();
		successMap.put("code","10200");
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("code","10500");
		List<TaskDescription> listTaskDescription = new ArrayList<TaskDescription>();
		try{
			listTaskDescription = taskDescriptionDao.queryTaskDescription() ;
			if(listTaskDescription.size()>0){
				successMap.put("msg","ok");
				list.add(0,1);
				list.add(1,listTaskDescription);
				list.add(2,successMap);
			}else{
				errorMap.put("msg","数据为空");
				list.add(0,0);
				list.add(1,errorMap);
			}
		}catch (Exception e){
			errorMap.put("msg","服务器未知错误");
			list.add(0,-1);
			list.add(1,errorMap);
		}

		// 返回结果
		return list ;
	}

	/**
	 * 通过tdTaskId获取任务详情
	 *
	 * @param tdTaskId
	 * @return
	 */
	@Override
	public List getTaskDescriptionById(int tdTaskId) {
		List list = new ArrayList();
		Map<String,String> successMap = new HashMap<>();
		successMap.put("code","10200");
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("code","10500");
		TaskDescription taskDescription ;
		try{
			taskDescription = taskDescriptionDao.queryTaskDescriptionById(tdTaskId);
			if(taskDescription != null){
				successMap.put("msg","ok");
				list.add(0,1);
				list.add(1,taskDescription);
				list.add(2,successMap);
			}else{
				errorMap.put("msg","数据为空,请确认taskId是否存在");
				list.add(0,0);
				list.add(1,errorMap);
			}
		}catch (Exception e){
			errorMap.put("msg","服务器未知错误");
			list.add(0,-1);
			list.add(1,errorMap);
		}

		// 返回结果
		return list ;
	}

	/**
	 * 增加任务
	 *
	 * @param taskDescription
	 * @return
	 */
	@Transactional
	@Override
	public Map<String,String> addTaskDescription(TaskDescription taskDescription) {

		Map<String,String> successMap = new HashMap<>();
		successMap.put("code","10200");
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("code","10500");


		if (taskDescription.getTdTaskId() != 0 && null != taskDescription.getTdSourceId() &&
			null != taskDescription.getTdMode() && null != taskDescription.getTdTableName() &&
			null != taskDescription.getTdColumns() && null != taskDescription.getTdTargetTableName() ) {
			try {
				int effectedNum = taskDescriptionDao.insertTaskDescription(taskDescription);
				if (effectedNum > 0) {
					successMap.put("msg","ok");
					return successMap;
				} else {
					errorMap.put("msg","添加任务失败，请检查字段是否错误");
					return errorMap;
				}
			} catch (Exception e) {
				errorMap.put("msg","服务器未知错误");

				return errorMap ;
			}
		} else {
			errorMap.put("msg","检查字段是否为空");
			return errorMap ;
		}
	}

	/**
	 * 修改任务
	 *
	 * @param taskDescription
	 * @return
	 */
	@Transactional
	@Override
	public Map<String,String> modifyTaskDescription(TaskDescription taskDescription) {
		Map<String,String> successMap = new HashMap<>();
		successMap.put("code","10200");
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("code","10500");

		if (taskDescription.getTdTaskId() != 0 && null != taskDescription.getTdSourceId() &&
				null != taskDescription.getTdMode() && null != taskDescription.getTdTableName() &&
				null != taskDescription.getTdColumns() && null != taskDescription.getTdTargetTableName() ) {
			try {
				int effectedNum = taskDescriptionDao.updateTaskDescription(taskDescription);
				if (effectedNum > 0) {
					successMap.put("msg","ok");
					return successMap;
				} else {
					errorMap.put("msg","更新失败，请检查字段是否错误");
					return errorMap;
				}
			} catch (Exception e) {
				errorMap.put("msg","服务器未知错误");
				return errorMap ;
			}
		} else {
			errorMap.put("msg","检查字段是否为空");
			return errorMap ;
		}
	}

	/**
	 * 删除任务
	 *
	 * @param tdTaskId
	 * @return
	 */
	@Transactional
	@Override
	public Map<String, String> deleteTaskDescription(int tdTaskId) {
		Map<String,String> successMap = new HashMap<>();
		successMap.put("code","10200");
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("code","10500");

		if (tdTaskId > 0) {
			try {
				// 删除任务
				int effectedNum = taskDescriptionDao.deleteTaskDescription(tdTaskId);
				if (effectedNum > 0) {
					successMap.put("msg","ok");
					return successMap;
				} else {
					errorMap.put("msg","删除失败，请确认taskId是否正确");
					return errorMap;
				}
			} catch (Exception e) {
				errorMap.put("msg","删除失败，服务器未知错误");
				return errorMap ;
			}
		} else {
			errorMap.put("msg","删除失败，检查taskId是否正确");
			return errorMap ;
		}
	}
}
