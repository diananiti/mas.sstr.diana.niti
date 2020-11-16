
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.lake.Lake;
import giotto.functionality.code.lake.PortLevel;
import giotto.functionality.interfaces.TaskInterface;
import giotto.functionality.table.Parameter;
import giotto.functionality.table.StopException;
import java.io.Serializable;
import java.util.Random;


public class TempControlSystem {
 
    public static void heaterON(){
        System.out.println("Access HW: turn on heater.");
    }
  
    public static void heaterOFF(){
        System.out.println("Access HW: turn off heater.");
    }
    
    public static int ReadTemperature(){
        //reading temperature from an outside source
        System.out.println("Access HW: read temperature");
        Random r = new Random();
        return r.nextInt(100);      
    }
}
