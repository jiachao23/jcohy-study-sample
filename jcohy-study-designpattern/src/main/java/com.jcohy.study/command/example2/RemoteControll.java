package com.jcohy.study.command.example2;

import java.util.Arrays;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : 调用者
 */
public class RemoteControll {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;
    public RemoteControll() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for(int i=0;i<7;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setSlot(int slot,Command onCommand,Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onbuttonWasPress(int slot){
        onCommands[slot].excute();
        undoCommand = onCommands[slot];
    }

    public void offbuttonWasPress(int slot){
        offCommands[slot].excute();
        undoCommand = offCommands[slot];
    }

    public void undobuttonWasPress(){
        undoCommand.undo();
    }

    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("\n-------------------------------RemoteControll----------------------\n");
         for(int i=0;i<onCommands.length;i++){
             sb.append("[ slot "+i+"] "+ onCommands[i].getClass().getName()+"   "+offCommands[i].getClass().getName()+"\n");
         }
        return sb.toString();
    }
}
