package AOPdemo.DAO;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService 
{
    public String getFortune()
    {
        try 
        {
            TimeUnit.SECONDS.sleep(5);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        return "Heavy Traffic";
    }
    
    public String getFortune(boolean tripWire)
    {
        if(tripWire)
        {
            throw new RuntimeException("Traffic");
        }
        return getFortune();
    }
}
