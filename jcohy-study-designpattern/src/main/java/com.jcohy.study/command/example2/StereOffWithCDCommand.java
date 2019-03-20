package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class StereOffWithCDCommand implements Command{
    Stere stere;

    public StereOffWithCDCommand(Stere stere) {
        this.stere = stere;
    }

    @Override
    public void excute() {
        stere.off();
    }

    @Override
    public void undo() {
        stere.on();
    }
}
