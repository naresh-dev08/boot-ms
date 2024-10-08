package com.nt.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulPreFilter extends ZuulFilter {
	
	private static final Logger log = LoggerFactory.getLogger(ZuulPreFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object
		RequestContext context = RequestContext.getCurrentContext();
		//Get HttpServletRequest object
		HttpServletRequest req = context.getRequest();
		log.info("---------From Zuul Pre Filter---------");
		log.info("Request Mode:: "+req.getMethod());
		log.info("Request content type:: "+req.getContentType());
		log.info("Request content length:: "+req.getContentLength());
		log.info("Request URI:: "+req.getRequestURI());
		log.info("Request path:: "+req.getServletPath());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		//return "pre";
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
