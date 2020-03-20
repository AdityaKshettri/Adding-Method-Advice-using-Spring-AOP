package AOPdemo.Aspect;

import AOPdemo.entity.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect 
{
    @Before("AOPdemo.Aspect.LogAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("\n===>> Executing @Before advice on addAccount()");
        
        MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature : " + theMethodSignature);
        
        Object[] args = theJoinPoint.getArgs();
        for(Object temp: args)
        {
            System.out.println(temp);
            if(temp instanceof Account)
            {
                Account theAccount = (Account) temp;
                System.out.println("Account name : " + theAccount.getName());
                System.out.println("Account level : " + theAccount.getLevel());
            }
        }
    }
    
    @After("execution(* AOPdemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
    {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @After (finally) on method : " + method);
    }
    
    @AfterThrowing(pointcut = "execution(* AOPdemo.DAO.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc)
    {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing on method : " + method);
        
        System.out.println("\n===> The Exception is : " + theExc);
    }
    
    @AfterReturning(pointcut = "execution(* AOPdemo.DAO.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterReturning on method : " + method);
        System.out.println("result : " + result);
        convertAccountNameToUpperCase(result);
        System.out.println("result : " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) 
    {
        for(Account temp: result)
        {
            String theUpperName = temp.getName().toUpperCase();
            temp.setName(theUpperName);
        }
    }
    
    @Around("execution(* AOPdemo.DAO.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @Around on method : " + method);
        
        long begin = System.currentTimeMillis();
        
        Object result = null;
        
        try 
        {
            result = theProceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
        
            long duration = end - begin;
            System.out.println("Time taken to execute : " + duration/1000.0 + " seconds");
        } 
        catch (Exception e) 
        {
            System.out.println("@Around Advice : We have a problem : " + e);
            result = "Nothing exciting here. Move on!!";
        }
        return result;
    }
}
