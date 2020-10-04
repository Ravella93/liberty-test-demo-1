package com.liberty.test.service;

import org.springframework.stereotype.Service;

@Service
public interface Item {
	String getName();

	int getPrice(String name);
}
