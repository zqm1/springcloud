package com.pc.test.springcloud.svc.file.services;

import java.util.List;


import com.pc.test.springcloud.api.domain.TsysFile;




public interface SysFileService{
	public boolean add(TsysFile tsysFile);

	public TsysFile get(Long id);

	public List<TsysFile> list();
	
}
