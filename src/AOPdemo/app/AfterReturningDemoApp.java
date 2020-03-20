package AOPdemo.app;

import AOPdemo.config.DemoConfig;
import AOPdemo.DAO.AccountDAO;
import AOPdemo.DAO.MembershipDAO;
import AOPdemo.entity.Account;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp 
{
    public static void main(String[] args) 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = theAccountDAO.findAccounts(false);
        
        System.out.println("@AfterReturning Demo App");
        System.out.println(theAccounts);
        
        context.close();
    }
}
