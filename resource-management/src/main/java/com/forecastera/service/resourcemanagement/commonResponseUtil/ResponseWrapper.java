package com.forecastera.service.resourcemanagement.commonResponseUtil;

import com.forecastera.service.resourcemanagement.util.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Uttam Kachhad
 * @Create 26-05-2023
 * @Description
 */
@RestControllerAdvice
public class ResponseWrapper implements ResponseBodyAdvice {

    private static final Logger log = LoggerFactory.getLogger(ResponseWrapper.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        String classPackage = methodParameter.getContainingClass().getPackage().getName();
//        System.out.println(methodParameter);
//        System.out.println(aClass);
//        System.out.println(methodParameter.getContainingClass());
//        System.out.println(methodParameter.getContainingClass().getPackage());
//        return StringUtils.hasLength(classPackage) || !classPackage.startsWith("org.springdoc.webmvc.api") && !classPackage.startsWith("org.springframework.boot.actuate.endpoint");
        boolean response = true;
        if(classPackage.startsWith("org.springdoc.webmvc.api")
                || classPackage.startsWith("org.springframework.boot.actuate.endpoint")
                || methodParameter.toString().contains("createResourceDetailsFromExcel")
                || methodParameter.toString().contains("downloadCreateResourceExcelFile")
                || methodParameter.toString().contains("downloadResourceAnalyticsTable")
        ){
            response = false;
        }
        return response;
//        return !classPackage.startsWith("org.springdoc.webmvc.api") && !classPackage.startsWith("org.springframework.boot.actuate.endpoint");
    }

    public Response beforeBodyWrite(Object responseDataInWrapper, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        Object responseData = ((ResponseEntityWrapper) responseDataInWrapper).getData();

        if (responseData instanceof Error) {
            return (Error) responseData;
        } else {
            Response<Object> response = new Success();
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();

            Date timestamp = new Date();
            if (responseData instanceof Map) {
                Map<String, Object> obj = (Map) responseData;
                if (obj.containsKey("status") && !StringUtils.hasLength(obj.get("status").toString())) {
                    int status = Integer.parseInt(obj.get("status").toString());
                    if (status < 200 || status >= 300) {
                        response = new Error();
                        timestamp = obj.get("timestamp") != null ? (Date) obj.get("timestamp") : null;
                        ((Error) response).setStatus(status);
                        ((Error) response).setMessage(status + " " + (status == 404 ? HttpStatus.NOT_FOUND.getReasonPhrase() : ""));
                        ((Response) response).setRequestAt(Objects.isNull(servletRequest.getAttribute("startTime")) ? new Date() : new Date((Long) servletRequest.getAttribute("startTime")));
                    }
                }
            }

            ((Response) response).setRequestAt(timestamp);
            if (response instanceof Success) {

                if (ObjectUtils.isEmpty(responseData)) {
                    ((Success) response).setStatus(HttpStatus.BAD_REQUEST.value());
                    serverHttpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
                    ((Success) response).setMessage(ResourceUtils.NO_DATA);
                } else {
                    ((Success) response).setStatus(HttpStatus.OK.value());
                    ((Success) response).setMessage(ResourceUtils.SUCCESS);
                }

                ((Success) response).setData(responseData);
                ((Success) response).setDuration(this.getDuration(serverHttpRequest));
            }
            return (Response) response;
        }
    }

    private long getDuration(ServerHttpRequest serverHttpRequest) {
        HttpServletRequest currentRequest = ResponseUtil.getCurrentRequest();
        if (currentRequest.getAttribute("startTime") == null) {
            return 0L;
        } else {
            long startTime = (Long) currentRequest.getAttribute("startTime");
            log.info("Request URL::" + currentRequest.getRequestURL().toString() + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
            return System.currentTimeMillis() - startTime;
        }
    }

}
