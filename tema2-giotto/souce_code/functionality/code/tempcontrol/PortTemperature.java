
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.int_port;
import giotto.functionality.interfaces.PortVariable;
import java.io.Serializable;

public class PortTemperature extends int_port implements PortVariable, Serializable {

    public PortTemperature() {
        setIntValue(0);
    }
    
}
