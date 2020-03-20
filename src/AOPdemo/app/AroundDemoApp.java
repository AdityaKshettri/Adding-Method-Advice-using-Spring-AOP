package AOPdemo.app;

import AOPdemo.config.DemoConfig;
import AOPdemo.DAO.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp 
{
    public static void main(String[] args) 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Calling the function getFortune()");
        
        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);
        System.out.println("My fortune is : " + data);
        
        System.out.println("Finished");
        
        context.close();
    }
}
