package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class CeilingFanOffCommand implements Command {

    CeilingFan ceilingFan;
    int preSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void excute() {
        preSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        if( preSpeed == CeilingFan.HIGH){
            ceilingFan.higt();
        }else if (preSpeed == CeilingFan.MIDLE){
            ceilingFan.midle();
        }else if(preSpeed == CeilingFan.LOW){
            ceilingFan.low();
        }else{
            ceilingFan.off();
        }
    }
}
