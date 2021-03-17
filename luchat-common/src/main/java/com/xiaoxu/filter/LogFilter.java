package com.xiaoxu.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author xx
 * @create 2021/2/4 15:59
 */
public class LogFilter implements Filter{



    private static final String ACCESS_LOGGER_NAME = "ActionAccessLogger";
    private static final Logger ACCESS_LOGGER = LoggerFactory.getLogger(ACCESS_LOGGER_NAME);
    private static final String STR_INVOKENO = "invokeNo";
    private static final String MIDDLE_LINE = "-";
    private static final String BLANK = "";
    private static final String STR_EQ = "=";
    private static final String STR_AND = "&";

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        logger.info("-------------a--------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        logger.info("------------b-------------");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String path = request.getRequestURI();

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        MDC.put(STR_INVOKENO, UUID.randomUUID().toString().replace(MIDDLE_LINE, BLANK));

        long startTime = System.currentTimeMillis();
        long runTime = 0L;
        try{
            filterChain.doFilter(request, response);
            runTime = System.currentTimeMillis() - startTime;
        }finally{
            String param = getParams(request);
            String tType = "|RT:";
            // 超过5分钟请求，打印ET
            if (runTime > 3000000) {
                tType = "|ET:";
            }
            String str = " " + "SESSIONID:" + sessionId +
                    tType + runTime + "|PARAM:" + param;
            logger.info(path + str);
            MDC.remove(STR_INVOKENO);
        }
    }

    private String getParams(HttpServletRequest request){
        String param = BLANK;
        Enumeration<?> parameters = request.getParameterNames();

        StringBuilder params = new StringBuilder();
        String temp = "";
        while (parameters.hasMoreElements()){
            temp = (String)parameters.nextElement();
            String value = request.getParameter(temp);
            params.append(temp);
            params.append(STR_EQ);
            params.append(value);
            params.append(STR_AND);
        }
        if (params.toString().length() > 0) {
            param = params.toString().substring(0, params.toString().length() - 1);
        }
        return param;
    }

    @Override
    public void destroy(){
        logger.info("-------------c--------------");
    }
}
