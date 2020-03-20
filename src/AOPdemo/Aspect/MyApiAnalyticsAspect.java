package AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect 
{
    @Before("AOPdemo.Aspect.LogAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics()
    {
        System.out.println("\n===>> Performing API Analytics");
    }
}
