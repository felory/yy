package com.ww.yy.model;

public class Greeting {
    private final long id; //无法修改（基本类型的值，引用类型的地址） 没有set方法。
    // final（修饰在方法上，表示最终方法）可以被子类继承，但不能重写。
    //final 修饰类，最终类，无法被继承。   如String类。
    private final String content;


    public Greeting(long id,String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
