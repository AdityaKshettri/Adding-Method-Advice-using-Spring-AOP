package AOPdemo.app;

import AOPdemo.config.DemoConfig;
import AOPdemo.DAO.AccountDAO;
import AOPdemo.DAO.MembershipDAO;
import AOPdemo.entity.Account;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeDemoApp 
{
    public static void main(String[] args) 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        Account theAccount = new Account();
        theAccount.setName("Aditya");
        theAccount.setLevel("platinum");
        
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        theAccountDAO.addAccount(theAccount);
        theAccountDAO.doWork();
        
        theAccountDAO.setName("adi");
        theAccountDAO.setServiceCode("silver");
        
        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();
        
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();
        
        List<Account> theAccounts = theAccountDAO.findAccounts(false);
        
        System.out.println("After returning Demo App");
        System.out.println(theAccounts);
        
        context.close();
    }
}
