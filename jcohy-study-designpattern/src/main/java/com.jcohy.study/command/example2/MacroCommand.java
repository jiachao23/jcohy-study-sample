package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void excute() {
        for(int i =0 ;i<commands.length;i++){
            commands[i].excute();
        }
    }

    @Override
    public void undo() {
        for(int i =0 ;i<commands.length;i++){
            commands[i].undo();
        }
    }
}
