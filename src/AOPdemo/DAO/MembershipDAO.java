package AOPdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO 
{
    public void addAccount()
    {
        System.out.println(getClass() + " Doing my stuff: Adding a Membership account");
    }
    
    public void goToSleep()
    {
        System.out.println(getClass() + " I am going to sleep");
    }
}
