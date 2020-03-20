package AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopExpressions 
{
    @Pointcut("execution(* AOPdemo.DAO.*.*(..))")
    public void forDaoPackage() {}
    
    @Pointcut("execution(* AOPdemo.DAO.*.get*(..))")
    public void getter() {}
    
    @Pointcut("execution(* AOPdemo.DAO.*.set*(..))")
    public void setter() {}
    
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
