package com.jcohy.study.command.example2;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.command.example2
 * Description  : 命令对象的抽象
 */
public interface Command {
    public void excute();
    //撤销
    public void undo();
}
