package com.edu.xmum.cst206.View;

import javafx.event.Event;
import javafx.event.EventType;

/*
自定义的事件
用于不同页面之间的切换
 */
public class ViewSwitchEvent extends Event {
    //自定义的事件类，都需要实现抽象父类的构造方法
    public ViewSwitchEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
    /*自定义的事件类型
    事件类型的构造器需要传入一个event的子类和String来表示这个事件类型的名字
    这里使用的ANY是任意事件类型
     */
    public static final EventType<ViewSwitchEvent>SWITCH_TO_WELCOME=new EventType<>(ANY,"SWITCH_TO_WELCOME");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_SELECTION=new EventType<>(ANY,"SWITCH_TO_SELECTION");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_PREPARE=new EventType<>(ANY,"SWITCH_TO_PREPARE");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_RUN=new EventType<>(ANY,"SWITCH_TO_RUN");
    public static final EventType<ViewSwitchEvent>SWITCH_TO_VICTIORY=new EventType<>(ANY,"SWITCH_TO_VICTIORY");

}
