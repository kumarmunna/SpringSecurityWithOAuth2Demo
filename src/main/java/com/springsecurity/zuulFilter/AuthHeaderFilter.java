package com.springsecurity.zuulFilter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class AuthHeaderFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getAttribute("AUTH_HEADER") == null) {
			// generate or get AUTH_TOKEN, ex from Spring Session repository
			String sessionId = UUID.randomUUID().toString();
			ctx.addZuulRequestHeader("AUTH_HEADER", sessionId);
			System.out.println("Auth_Header:: " + sessionId + " ctx:: " + ctx.getRequest().getRequestURI());
		}
		System.out.println("After Auth_Header:: ");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 10000;
	}

}
