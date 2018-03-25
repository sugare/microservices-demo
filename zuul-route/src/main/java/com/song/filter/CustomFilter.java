package com.song.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomFilter extends ZuulFilter{

	private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
				
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		
		Object accessToken = request.getParameter("token");
		if(null == accessToken ) {
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		logger.info("ok");
		
		return null;
		
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
