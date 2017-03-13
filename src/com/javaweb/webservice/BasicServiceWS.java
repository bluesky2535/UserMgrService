package com.javaweb.webservice;

import javax.jws.WebService;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



@WebService
@Transactional
@Service
public interface BasicServiceWS {
	public String getResults(String transStr) ;
}
