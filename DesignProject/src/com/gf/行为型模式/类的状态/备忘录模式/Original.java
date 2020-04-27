package com.gf.行为型模式.类的状态.备忘录模式;
public class Original {

    //需要保存备份的属性
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }

    //创建备忘录
    public Memento createMemento() {
        return new Memento(value);
    }

    //还原
    public void restoreMemento(Memento memento) {
        this.value = memento.getValue();
    }
}