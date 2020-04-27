package com.gf.行为型模式.类和类之间的关系.迭代子模式;


public interface Collection {
    
    //集合数据的其他操作，交给Iterator实现类解决
    public Iterator iterator();

    /* 取得集合元素 */
    public Object get(int i);

    /* 取得集合大小 */
    public int size();
}