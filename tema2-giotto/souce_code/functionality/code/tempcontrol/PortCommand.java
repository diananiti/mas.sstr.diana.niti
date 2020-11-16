
package giotto.functionality.code.tempcontrol;

import giotto.functionality.code.int_port;
import giotto.functionality.interfaces.PortVariable;
import java.io.Serializable;

public class PortCommand extends int_port implements PortVariable, Serializable{
     public PortCommand() {
        setIntValue(0);
    }

    public static void Init(PortCommand m) {
        m.setIntValue(0);
    }
}
