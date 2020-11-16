
package giotto.functionality.code.tempcontrol;

import giotto.functionality.interfaces.DriverInterface;
import giotto.functionality.table.Parameter;
import java.io.Serializable;


public class copy_PortTemperature implements DriverInterface, Serializable{
    
     public void run(Parameter parameter) {
        giotto.functionality.code.tempcontrol.PortTemperature m0 = 
                (giotto.functionality.code.tempcontrol.PortTemperature) parameter.getPortVariable(0);
        
        giotto.functionality.code.tempcontrol.PortTemperature m1 = 
                (giotto.functionality.code.tempcontrol.PortTemperature) parameter.getPortVariable(1);
        
        m1.copyValueFrom(m0);   
     }
}
