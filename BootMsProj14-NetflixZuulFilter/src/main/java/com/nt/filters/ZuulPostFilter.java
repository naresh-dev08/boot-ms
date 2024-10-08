package com.nt.filters;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class ZuulPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object
		RequestContext context = RequestContext.getCurrentContext();
		//Get HttpServletResponce object
		HttpServletResponse res = context.getResponse();
		//Write the log message related POST filter
		log.info("---------From Zuul Post Filter---------");
		log.info("Response status code:: "+res.getStatus());
		log.info("Response context type:: "+res.getContentType());
		log.info("Response content length:: "+res.getHeader("Content-Length"));
		log.info("Response host name:: "+res.getHeader("host"));
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
