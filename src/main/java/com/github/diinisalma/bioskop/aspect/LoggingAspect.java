package com.github.diinisalma.bioskop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("within(com.github.diinisalma.bioskop.web.CityController)")
    private void restAPI() {}

    @Pointcut("execution(* com.github.diinisalma.bioskop.web.CityController.*(..))")
    private void cityController() {}

    @Pointcut("args(com.github.diinisalma.bioskop.dto.CityPayloadDTO, *)")
    private void argsPointcutExample() {}

    /*
     * Pointcut @args sama seperti args
     * Bedanya untuk memanggil pointcut @args harus menggaunakan annotation di parameter class-nya
     * Pada contoh ini, CityPayloadDTO memiliki annotation @LogThisArg
     */
    @Pointcut("@args(com.github.diinisalma.bioskop.annotation.LogThisArg)")
    private void logThisArg() {}

    @Pointcut("@annotation(com.github.diinisalma.bioskop.annotation.LogThisMethod)")
    private void annotationAspectExample() {}

    @Before( "annotationAspectExample()" )
    public void beforeExecutedLogging() {
        log.info("This is log from before aspect");
    }

    @After( "annotationAspectExample" )
    public void afterExecutedLogging() {
        log.info("This is log from after aspect");
    }

    @AfterReturning("annotationAspectExample")
    public void afterReturningExecutedLogging() {
        log.info("This is log from after returning aspect");
    }

    @Around("restAPI()")
    public Object aroundExecutedLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopwatch = new StopWatch();
        try {
            log.info("Start to execute {}.{}",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName());
            stopwatch.start();
            return joinPoint.proceed();
        } finally {
            stopwatch.stop();
            log.info("Time taken by {}.{} is {} ms",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopwatch.getTotalTimeMillis());
        }
    }
}
