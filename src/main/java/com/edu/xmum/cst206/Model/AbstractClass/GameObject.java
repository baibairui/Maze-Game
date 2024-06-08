package com.edu.xmum.cst206.Model.AbstractClass;

/*
游戏中所有对象的超类
规定了所有的游戏对象都应该有的属性：
1.横坐标：x
2.纵坐标：y
---
规定了所有游戏对象都应该有的方法：
1.get和set方法
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    //构造函数
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //相关get和set方法
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
