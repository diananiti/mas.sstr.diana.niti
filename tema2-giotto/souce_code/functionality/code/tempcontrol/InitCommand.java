
package giotto.functionality.code.tempcontrol;


import giotto.functionality.code.lake.PortValve;
import giotto.functionality.interfaces.DriverInterface;
import giotto.functionality.table.Parameter;

import java.io.Serializable;

public class InitCommand implements DriverInterface, Serializable {

    public void run(Parameter parameter) {
        System.out.println("Command initialised.");
        PortCommand.Init((PortCommand)parameter.getPortVariable(0));
    }

}

