package com.zzh.exercise.javaBase;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/5
 */
public class HashMapCodeRead<K,V> extends AbstractMap<K,V>
                    implements Map<K,V>,Cloneable, Serializable {
    private static final long serialVersionUID = -481655068552285603L;
    /**
     *  默认的初始化的大小,必须是2的n次幂
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    /**
     * 最大容量大小
     */
    static final int MAXIMUM_CAPACITY = 1<< 30;
    /**
     * 默认负载因子大小
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 桶的树化阀值
     * 链表转换为红黑树的阀值；1.8新增
     */
    static final int TREEIFY_THRESHOLD  = 8;
    /**
     * 桶的链表还原阀值
     * 红黑树转换为链表的阀值；
     * 在扩容时（此时HashMap的数据存储位置会重新计算）
     * 在重新计算存储位置后，当原有的红黑树内数量<6的时候，将红黑树转换为链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;
    /**
     * 最小树形化容量阀值
     * 当哈希表中的容量 > 该值时，才允许树形化链表
     * 否则，如果桶内元素过多时，则直接扩容，而不是树形化
     * 为了避免进行扩容、树形化选择的冲突
     * 这个值不能小于4 * TREEIFY_THRESHOLD的两倍
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node(int hash,K key,V value ,Node<K,V> next) {
            this.hash = hash;
            this.key = key ;
            this.value =value ;
            this.next =next;
        }

        public final K getKey() { return key; }

        public final V getValue() { return value; }

        public final String toString(){ return key +"="+ value ;}

        public final int hashCode(){ return Objects.hashCode(key) ^ Objects.hashCode(value) ;}

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        //重写equal，Object中的equals,==引用地址，equals不重写也是比较的是引用地址；
        //String重写了equals。先判断长度是否相等，再判断数组的每个值，每个字母是否相等；

        /**
         * Node重写equals
         * 比较对象是否与当前对象是否相同，相同返回true
         * 如果对象不与当前对象相同，则判断O是否为Map.Entry类型；
         * 如果是Map.Entry类型，则转换为Map.Entry类型
         * 判断当前对象的key,value与传递对象的key,value是否都相等，都相等返回true
         * 其他情况返回为false
         * @param o
         * @return
         */
        public final boolean equals(Object o){
            if(o == this){
                return true;
            }
            if(o instanceof Map.Entry){
                Map.Entry<?,?> e =(Map.Entry<?,?>)o;
                if(Objects.equals(key,e.getKey())
                    && Objects.equals(value,e.getValue())){
                    return true;
                }
            }
            return false;
        }
    }
    /* ---------------- Static utilities 静态实例程序-------------- */

    /**
     * 判断x是否为Comparable类型，如果是返回x.Class，否则返回null
     *  1.判断x类型是否为Comparable类型
     *  2.初始化类反射c，type数组ts,as，type t和 ParameterizedType p(参数化类型，在反射方法第一次需要时创建)
     *  3.把x.Class赋值给c,然后判断是否为String.class,如果相等返回c；
     *  4.c.getGenericInterfaces:返回表示由该对象表示的类或接口直接实现的接口类型
     *  5.将c.getGenericInterfaces赋值给ts 然后判断是否为空，不为空
     *  情话就是一个自己都不信的话说给想让另一个人相信的话；
     * @param x
     * @return
     */
    static Class<?> comparableClassFor(Object x){
        if(x instanceof Comparable){
            Class<?> c;
            Type[] ts;
            Type[] as;
            Type t;
            ParameterizedType p;
            //检查通过
            if((c = x.getClass()) == String.class){
                return c;
            }
            if((ts = c.getGenericInterfaces()) != null){
                for (int i = 0; i < ts.length; i++) {
//                    if((t = ts[i]) instanceof ParameterizedType
//                        && (p = (ParameterizedType)t)){
//
//                    }
                }
            }
        }
        return null;
    }
    static final int hash(Object key){
        int h;
        return (key == null) ? 0: (h = key.hashCode())^(h >>> 16);
    }






    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
