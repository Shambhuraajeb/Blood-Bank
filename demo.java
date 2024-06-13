import java.sql.*;
import java.util.*;
import java.time.LocalDate;

class demo
{
    @SuppressWarnings("unchecked")
    public static void main(String args[])throws Exception
    {
            
  
    LocalDate date = LocalDate.now();    
    LocalDate yesterday = date.minusDays(180);    
    LocalDate tomorrow = yesterday.plusDays(2);    
    System.out.println("Today date: "+date);    
    System.out.println("Yesterday date: "+yesterday);    
    System.out.println("Tomorrow date: "+tomorrow);    
   
   if(yesterday.isBefore(date))
   {
        System.out.println("yess");
   }
    }
}