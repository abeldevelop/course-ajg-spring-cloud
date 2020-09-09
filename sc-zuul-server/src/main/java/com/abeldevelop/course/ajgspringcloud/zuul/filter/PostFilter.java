package com.abeldevelop.course.ajgspringcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PostFilter extends ZuulFilter {

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    long startTime = (long) request.getAttribute("startTime");
    Long totalTime = (System.currentTimeMillis() - startTime);
    log.info("Tiempo transcurrido en segundos: {}", (totalTime.doubleValue() / 1000));
    return null;
  }

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return 1;
  }
}
