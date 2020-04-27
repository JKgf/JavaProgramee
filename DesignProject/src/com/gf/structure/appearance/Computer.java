package com.gf.structure.appearance;
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    //启动电脑
    public void startup() {
        System.out.println("正在启动电脑...");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("电脑启动完毕...");
    }

    //关闭电脑
    public void shutdown() {
        System.out.println("正在关闭电脑...");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("电脑关闭完毕...");
    }
}