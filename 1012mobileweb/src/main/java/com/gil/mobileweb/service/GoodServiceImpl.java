package com.gil.mobileweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gil.mobileweb.dao.GoodDao;
import com.gil.mobileweb.domain.Good;

@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	private GoodDao goodDao;
	@Override
	public List<Good> list() {
		return goodDao.list();
	}

}
