package AOPdemo.app;

import AOPdemo.config.DemoConfig;
import AOPdemo.DAO.AccountDAO;
import AOPdemo.entity.Account;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterDemoApp 
{
    public static void main(String[] args) 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = null;
        
        try 
        {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } 
        catch (Exception e) 
        {
            System.out.println("Exception caught : " + e);
        }
        
        System.out.println("@After Demo App");
        System.out.println(theAccounts);
        
        context.close();
    }
}
