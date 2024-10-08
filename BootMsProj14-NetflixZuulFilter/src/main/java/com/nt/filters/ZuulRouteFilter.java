package com.nt.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class ZuulRouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object
		RequestContext context = RequestContext.getCurrentContext();
		//Write the log message related Router
		log.info("---------From Zuul Router Filter---------");
		//log.info("Router Host Name:: "+context.getRouteHost().toString());
		//log.info("Router Host Name:: "+context.getFilterExecutionSummary());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
