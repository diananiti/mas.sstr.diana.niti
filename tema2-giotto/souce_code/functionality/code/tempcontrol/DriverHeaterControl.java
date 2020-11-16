
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.lake.Lake;
import giotto.functionality.code.lake.PortValve;
import giotto.functionality.interfaces.DriverInterface;
import giotto.functionality.table.Parameter;
import java.io.Serializable;


public class DriverHeaterControl implements DriverInterface, Serializable {

    
    @Override
    public void run(Parameter parameter) {
        PortCommand m = (PortCommand)parameter.getPortVariable(0);
        System.out.println("Set valve position " + m.getIntValue());
        if (m.getIntValue() > 0) TempControlSystem.heaterON();
        else TempControlSystem.heaterOFF();
    }
    
}
