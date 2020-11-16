
package giotto.functionality.code.tempcontrol;

import giotto.functionality.interfaces.DriverInterface;
import giotto.functionality.table.Parameter;
import java.io.Serializable;

public class copy_PortCommand implements DriverInterface, Serializable{
    
     public void run(Parameter parameter) {
        giotto.functionality.code.tempcontrol.PortCommand m0 = 
                (giotto.functionality.code.tempcontrol.PortCommand) parameter.getPortVariable(0);
        
        giotto.functionality.code.tempcontrol.PortCommand m1 = 
                (giotto.functionality.code.tempcontrol.PortCommand) parameter.getPortVariable(1);
        
        m1.copyValueFrom(m0);   
     }
}