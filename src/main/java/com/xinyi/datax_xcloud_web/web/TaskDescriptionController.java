package com.xinyi.datax_xcloud_web.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.xinyi.datax_xcloud_web.entity.TaskDescription;
import com.xinyi.datax_xcloud_web.service.TaskDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/taskDescription")
public class TaskDescriptionController {

	@Autowired
	private TaskDescriptionService taskDescriptionService ;

	/**
	 * 获取所有的任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryTaskDescriptionList", method = RequestMethod.GET)
	private Map<String, Object> listTaskDescription() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List list ;
		// 获取区域列表
		list = taskDescriptionService.getTaskDescriptionList();
		if(Integer.valueOf(list.get(0).toString()) == 1 ){
			modelMap.put("data", list.get(1));
			modelMap.put("state",list.get(2));
		}else if(Integer.valueOf(list.get(0).toString()) == 0){
			modelMap.put("state",list.get(1));
		}else if(Integer.valueOf(list.get(0).toString()) == -1){
			modelMap.put("state",list.get(1));
		}else{
			modelMap.put("state",list.get(1));
		}

		return modelMap;
	}

	/**
	 * 通过taskId获取任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryTaskDescriptionById", method = RequestMethod.POST)
	private Map<String, Object> getTaskDescriptionById(Integer tdTaskId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List list ;
		// 获取区域列表
		list = taskDescriptionService.getTaskDescriptionById(tdTaskId);
		if(Integer.valueOf(list.get(0).toString()) == 1 ){
			modelMap.put("data", list.get(1));
			modelMap.put("state",list.get(2));
		}else if(Integer.valueOf(list.get(0).toString()) == 0){
			modelMap.put("state",list.get(1));
		}else if(Integer.valueOf(list.get(0).toString()) == -1){
			modelMap.put("state",list.get(1));
		}else{
			modelMap.put("state",list.get(1));
		}

		return modelMap;
	}

	/**
	 * 	数据导入任务描述生成接口
	 *
	 * @param paramJson
	 *
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/createTaskDescription", method = RequestMethod.POST ,consumes = "application/json")
	private Map<String, Map<String,String>> addTaskDescription(@RequestBody String paramJson)
			throws JsonParseException, JsonMappingException, IOException {
		JSONObject jsonObject = JSON.parseObject(paramJson);
		TaskDescription taskDescription = new TaskDescription() ;
		taskDescription.setTdTaskId(jsonObject.getInteger("taskId"));
		taskDescription.setTdSourceId(jsonObject.getString("sourceId"));
		taskDescription.setTdMode(jsonObject.getString("sourceId"));
		taskDescription.setTdIncrementColumn(jsonObject.getString("incrementColumn"));
		taskDescription.setTdTableName(jsonObject.getString("tableName"));
		taskDescription.setTdColumns(jsonObject.getString("columns"));
		taskDescription.setTdTargetTableName(jsonObject.getString("targetTableName"));
		taskDescription.setTdDispatch(jsonObject.getString("dispatch"));
		taskDescription.setTdRemarks(jsonObject.getString("remarks"));
		Map<String, Map<String,String>> modelMap = new HashMap<>();

		// 添加任务
		modelMap.put("state", taskDescriptionService.addTaskDescription(taskDescription));
		return modelMap;
	}

	/**
	 *  数据导入任务描述修改接口
	 * 
	 * @param paramJson
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/updateTaskDescription", method = RequestMethod.POST)
	private Map<String, Map<String,String>> modifytaskDescription(@RequestBody String paramJson)
			throws JsonParseException, JsonMappingException, IOException {
		JSONObject jsonObject = JSON.parseObject(paramJson);
		TaskDescription taskDescription = new TaskDescription() ;
		taskDescription.setTdTaskId(jsonObject.getInteger("taskId"));
		taskDescription.setTdSourceId(jsonObject.getString("sourceId"));
		taskDescription.setTdMode(jsonObject.getString("sourceId"));
		taskDescription.setTdIncrementColumn(jsonObject.getString("incrementColumn"));
		taskDescription.setTdTableName(jsonObject.getString("tableName"));
		taskDescription.setTdColumns(jsonObject.getString("columns"));
		taskDescription.setTdTargetTableName(jsonObject.getString("targetTableName"));
		taskDescription.setTdDispatch(jsonObject.getString("dispatch"));
		taskDescription.setTdRemarks(jsonObject.getString("remarks"));
		Map<String, Map<String,String>> modelMap = new HashMap<>();

		// 修改任务
		modelMap.put("state", taskDescriptionService.modifyTaskDescription(taskDescription));
		return modelMap;
	}

	@RequestMapping(value = "/deleteTaskDescriptionById", method = RequestMethod.GET)
	private Map<String, Map<String,String>> removeTaskDescription(Integer tdTaskId) {
		Map<String, Map<String,String>> modelMap = new HashMap<>();
		// 删除任务
		modelMap.put("state", taskDescriptionService.deleteTaskDescription(tdTaskId));
		return modelMap;
	}

}
