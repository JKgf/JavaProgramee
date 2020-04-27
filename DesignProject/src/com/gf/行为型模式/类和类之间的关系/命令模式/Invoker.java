package com.gf.行为型模式.类和类之间的关系.命令模式;
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    //发起命令
    public void action() {
        command.exe();
    }
}