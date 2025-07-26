package GFG.DigitalLibraryProject.Digital.Library.Project.beans;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* GFG.DigitalLibraryProject.Digital.Library.Project..*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        log.info("Logging: Calling {} with arguments: {}",
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
}

