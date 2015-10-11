package com.zapboo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapboo.dao.IZapBooDao;
import com.zapboo.service.IZapBooService;

@Service
public class ZapBooServiceImpl implements IZapBooService {

	@Autowired
	private IZapBooDao objZapBooDao;
	
	
	
}
