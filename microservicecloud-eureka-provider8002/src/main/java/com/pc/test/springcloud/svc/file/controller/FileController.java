package com.pc.test.springcloud.svc.file.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pc.test.springcloud.api.domain.TsysFile;
import com.pc.test.springcloud.svc.file.services.SysFileService;




/**
 * 文件上传controller
 * @author fuce 
 * @date: 2018年9月16日 下午4:23:50
 */
@RestController
public class FileController{

	//跳转页面参数
	private String prefix = "admin/file";
	
	@Autowired
	private SysFileService service;
	

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody TsysFile tsysFile)
	{
		return service.add(tsysFile);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public TsysFile get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<TsysFile> list()
	{
		return service.list();
	}

}
