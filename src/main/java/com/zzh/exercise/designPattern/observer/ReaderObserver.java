package com.zzh.exercise.designPattern.observer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Zhenghan
 * @Description: 观察者模式 --接收者
 * @Date: Create by 2021/4/27
 */
@RequiredArgsConstructor
public class ReaderObserver implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @NonNull
    private String name;

    private String article;

    @Override
    public void update(Observable o, Object arg) {
        // 更新文章
        updateArticle(o);
    }

    private void updateArticle(Observable o) {
        JavaStackObservable javaStackObservable = (JavaStackObservable) o;
        this.article = javaStackObservable.getArticle();
        System.out.printf("我是读者：%s，文章已更新为：%s\n", this.name, this.article);
    }
}
