package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class GarageDoorCloseCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void setGarageDoor(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void excute() {
        garageDoor.off();
    }

    @Override
    public void undo() {
        garageDoor.on();
    }
}
