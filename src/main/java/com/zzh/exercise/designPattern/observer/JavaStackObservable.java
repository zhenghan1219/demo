package com.zzh.exercise.designPattern.observer;

import lombok.Getter;

import java.util.Observable;

/**
 * @Author: Zhenghan
 * @Description: 观察者模式 --发布者
 * @Date: Create by 2021/4/27
 */
@Getter
public class JavaStackObservable extends Observable {

    private String article;

    /**
     * 发表文章
     * @param article
     */
    public void publish(String article){
        // 发表文章
        this.article = article;

        // 改变状态
        this.setChanged();

        // 通知所有观察者
        this.notifyObservers();
    }
}
