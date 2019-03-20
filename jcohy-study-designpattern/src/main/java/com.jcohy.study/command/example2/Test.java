package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  :
 */
public class Test {

    public static void main(String[] args) {
        RemoteControll remoteControll = new RemoteControll();
        Light livingRoomLight = new Light("Living Room");
        Light KitchenLight = new Light("KitchenLight Room");
        GarageDoor garageDoor = new GarageDoor("garageDoor");
        Stere stere = new Stere("Living Room stere");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand KitchenLightOn = new LightOnCommand(KitchenLight);
        LightOffCommand KitchenLightOff = new LightOffCommand(KitchenLight);

        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

        StereOnWithCDCommand stereOnWithCD = new StereOnWithCDCommand(stere);
        StereOffWithCDCommand stereOffWithCD = new StereOffWithCDCommand(stere);
        remoteControll.setSlot(0,livingRoomLightOn,livingRoomLightOff);
        remoteControll.setSlot(1,KitchenLightOn,KitchenLightOff);
        remoteControll.setSlot(2,garageDoorOpen,garageDoorClose);
        remoteControll.setSlot(3,stereOnWithCD,stereOffWithCD);

        System.out.println(remoteControll);
        remoteControll.onbuttonWasPress(0);
        remoteControll.onbuttonWasPress(1);
        remoteControll.onbuttonWasPress(2);
        remoteControll.onbuttonWasPress(3);
        remoteControll.offbuttonWasPress(0);
        remoteControll.offbuttonWasPress(1);
        remoteControll.offbuttonWasPress(2);
        remoteControll.offbuttonWasPress(3);

        remoteControll.undobuttonWasPress();
        System.out.println("--------------------------测试天花板吊扇-------------------");

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMidleCommand ceilingFanMidleCommand = new CeilingFanMidleCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControll.setSlot(4,ceilingFanMidleCommand,ceilingFanOffCommand);
        remoteControll.setSlot(5,ceilingFanHighCommand,ceilingFanOffCommand);

        //首先，以中速启动
        remoteControll.onbuttonWasPress(4);
        //然后关闭
        remoteControll.offbuttonWasPress(4);
        //撤销
        remoteControll.undobuttonWasPress();
        //开启
        remoteControll.onbuttonWasPress(5);
        ////撤销
        remoteControll.undobuttonWasPress();

        System.out.println("--------------------------测试宏命令-------------------");

        Light light = new Light("Living Room");
        Stere stere1 = new Stere("Living Room");

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        StereOnWithCDCommand stereOnWithCDCommand = new StereOnWithCDCommand(stere1);
        StereOffWithCDCommand stereOffWithCDCommand = new StereOffWithCDCommand(stere1);

        Command[] oncommands = new Command[]{lightOnCommand,stereOnWithCDCommand};
        Command[] offcommands = new Command[]{lightOffCommand,stereOffWithCDCommand};

        MacroCommand onMacroCommand = new MacroCommand(oncommands);
        MacroCommand offMacroCommand = new MacroCommand(offcommands);

        remoteControll.setSlot(6,onMacroCommand,offMacroCommand);
        remoteControll.onbuttonWasPress(6);
        remoteControll.undobuttonWasPress();
//        remoteControll.offbuttonWasPress(6);

    }
}
