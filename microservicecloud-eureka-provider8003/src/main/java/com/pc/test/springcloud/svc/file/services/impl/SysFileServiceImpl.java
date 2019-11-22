package com.pc.test.springcloud.svc.file.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.test.springcloud.api.domain.TsysFile;
import com.pc.test.springcloud.svc.file.domain.dao.TsysFileDao;
import com.pc.test.springcloud.svc.file.services.SysFileService;

@Service
public class SysFileServiceImpl implements SysFileService{
	@Autowired
	private TsysFileDao dao;
	
	public boolean add(TsysFile tsysFile) {

		return dao.addFile(tsysFile);
	}
	public TsysFile get(Long id) {
		
		return dao.findById(id);
	}
	public List<TsysFile> list() {
		
		return dao.findAll();
	}
	

	
}
