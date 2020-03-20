package AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLoggingAspect 
{
    @Before("AOPdemo.Aspect.LogAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud()
    {
        System.out.println("\n===>> Logging to cloud");
    }
}
