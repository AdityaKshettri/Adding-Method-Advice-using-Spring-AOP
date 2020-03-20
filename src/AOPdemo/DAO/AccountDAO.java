package AOPdemo.DAO;

import AOPdemo.entity.Account;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO 
{
    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire)
    {
        if(tripWire)
        {
            throw new RuntimeException("No reward for you!!");
        }
        
        Account temp1 = new Account("Adi", "Silver");
        Account temp2 = new Account("Ksh", "Platinum");
        Account temp3 = new Account("Sri", "Gold");
        
        List<Account> myAccounts = new ArrayList<>();
        
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        
        return myAccounts;
    }
    
    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName()");
        this.name = name;  
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode()");
        this.serviceCode = serviceCode;
    }
    
    public void addAccount(Account theAccount)
    {
        System.out.println(getClass() + " Doing my DB work: Adding an account");
    }
    
    public boolean doWork()
    {
        System.out.println(getClass() + " doWork()");
        return true;
    }
}
