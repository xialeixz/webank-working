package org.webank.working.service.impl;

import org.webank.working.service.TestService;

public class TestServiceImpl implements TestService{

	public String getName(String name) {
		return "hehe:" + name;
	}
}
