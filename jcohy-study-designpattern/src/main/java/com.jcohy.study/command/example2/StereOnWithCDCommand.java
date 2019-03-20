package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class StereOnWithCDCommand implements Command{
    Stere stere;

    public StereOnWithCDCommand(Stere stere) {
        this.stere = stere;
    }

    @Override
    public void excute() {
        stere.on();
        stere.setCD();
        stere.setVolume(11);
    }

    @Override
    public void undo() {
        stere.off();
    }
}
