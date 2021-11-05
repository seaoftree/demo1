package com.example.demo1.aop;

import com.example.demo1.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {
    //统一定义切点表达式
    @Pointcut("execution(* com.example.demo1.aop.AspectController.test1(..))")
    public void test1PointCut(){
    }

    //前置通知
    @Before("execution(* com.example.demo1.aop.AspectController.test1(..))")
    public void startRunTime(){
        System.out.println("before run-------");

    }

    //后置通知
    @AfterReturning("execution(* com.example.demo1.aop.AspectController.test1(..))")
    public void endRunTime1(){
        System.out.println("after return -------");
    }

    //后置通知
    @AfterThrowing("execution(* com.example.demo1.aop.AspectController.test1(..))")
    public void endRunTime2(){
        System.out.println("after throwing-------");
    }

    //环绕通知
    @Around("execution(* com.example.demo1.aop.AspectController.test1(..))")
    public void startEndRunTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //调用方法前执行的切面逻辑
            System.out.println("start time");

//            System.out.println("-------------------------------------");
//            Signature signature = joinPoint.getSignature();
//            System.out.println(signature);
//            System.out.println(signature.getName());
//            System.out.println(signature.getDeclaringType());
//            System.out.println(signature.getClass());
//            System.out.println(signature.getDeclaringTypeName());
//            System.out.println(joinPoint.getTarget().getClass().getSimpleName());
//            System.out.println("-------------------------------------");


            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            StringBuilder requestLog = new StringBuilder();
            Signature signature = joinPoint.getSignature();
            requestLog.append(((MethodSignature) signature).getMethod().getName()).append("\t")
                    .append("请求信息：").append("URL = {").append(request.getRequestURI()).append("},\t")
                    .append("请求方式 = {").append(request.getMethod()).append("},\t")
                    .append("请求IP = {").append(request.getRemoteAddr()).append("},\t")
                    .append("类方法 = {").append(signature.getDeclaringTypeName()).append(".")
                    .append(signature.getName()).append("},\t");

            // 处理请求参数
            String[] paramNames = ((MethodSignature) signature).getParameterNames();
            Object[] paramValues = joinPoint.getArgs();
            int paramLength = null == paramNames ? 0 : paramNames.length;
            if (paramLength == 0) {
                requestLog.append("请求参数 = {} ");
            } else {
                requestLog.append("请求参数 = [");
                for (int i = 0; i < paramLength - 1; i++) {
                    requestLog.append(paramNames[i]).append("=").append(JSONUtil.toJSONString(paramValues[i])).append(",");
                }
                requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONUtil.toJSONString(paramValues[paramLength - 1])).append("]");
            }

            log.info(requestLog.toString());

            //调用目标方法
            long startTime = System.currentTimeMillis();
            joinPoint.proceed();
            //调用目标方法之后执行的方法
            long endTime = System.currentTimeMillis();

            System.out.println("end time");
            System.out.println("run time :" + (endTime - startTime) + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }

    }

}
