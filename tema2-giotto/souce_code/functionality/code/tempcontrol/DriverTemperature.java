
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.lake.PortLevel;
import giotto.functionality.interfaces.DriverInterface;
import giotto.functionality.table.Parameter;
import java.io.Serializable;


public class DriverTemperature implements DriverInterface, Serializable{

    @Override
    public void run(Parameter parameter) {
         PortTemperature p = (PortTemperature)parameter.getPortVariable(0);
         int t = TempControlSystem.ReadTemperature();
         p.setIntValue(t);

    }
    
}
