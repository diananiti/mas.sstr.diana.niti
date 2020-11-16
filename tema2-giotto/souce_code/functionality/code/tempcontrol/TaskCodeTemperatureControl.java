
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.lake.Lake;
import giotto.functionality.code.lake.PortLevel;
import giotto.functionality.code.lake.PortValve;
import giotto.functionality.interfaces.TaskInterface;
import giotto.functionality.table.Parameter;
import giotto.functionality.table.StopException;
import java.io.Serializable;


public class TaskCodeTemperatureControl implements TaskInterface, Serializable {

  
    @Override
    public void run(Parameter parameter) throws StopException {

        System.out.println("Executing temperature control task...");
        int temperature = ((PortTemperature)parameter.getPortVariable(0)).getIntValue();
        
        PortCommand command = (PortCommand)parameter.getPortVariable(1);
        if(temperature>5){
        	command.setIntValue(1); //
        }else
        	command.setIntValue(0);
        System.out.println("Executed temperature control task done!");
        
        
    }
    
}
