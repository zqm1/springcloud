package com.pc.test.springcloud.svc.file.domain.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pc.test.springcloud.api.domain.TsysFile;
@Mapper
public interface TsysFileDao {
	public boolean addFile(TsysFile tsysFile);

	public TsysFile findById(Long id);

	public List<TsysFile> findAll();
}