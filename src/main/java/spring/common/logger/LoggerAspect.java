package spring.common.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    static String name = "";
    static String type = "";
     
    @Around("execution(* spring..controller.*Controller.*(..)) or execution(* spring..service.*Impl.*(..)) or execution(* spring..dao.*Dao.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        type = joinPoint.getSignature().getDeclaringTypeName();
         
        if (type.indexOf("Controller") > -1) {
            name = "Controller  \t:  ";
        }
        else if (type.indexOf("Service") > -1) {
            name = "ServiceImpl  \t:  ";
        }
        else if (type.indexOf("Dao") > -1) {
            name = "Dao  \t\t:  ";
        }
        log.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
    
}