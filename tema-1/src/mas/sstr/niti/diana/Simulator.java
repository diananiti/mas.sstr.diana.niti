package mas.sstr.niti.diana;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Simulator extends Thread{
    private Model m;

    public Simulator(Model m) {
        this.m = m;
    }

    boolean active = true;
    public void run(){
        int step = 0;
        while(!m.canStop()){
            step++;
            m.step(step);
            try {Thread.sleep(500);} catch (InterruptedException ex) {}
        }
    }
}
