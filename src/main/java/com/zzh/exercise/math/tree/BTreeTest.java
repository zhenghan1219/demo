package com.zzh.exercise.math.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/4/9
 */
public class BTreeTest {
    /**
     * B树中的节点
     * @param <K>
     * @param <V>
     */
    private static class BTreeNode<K,V>{
        /**
         * 节点的项，按键非降序排序
         */
        private List<Entry<K,V>> entries;
        /**
         * 内节点的子节点
         */
        private List<BTreeNode<K,V>> children;
        /**
         * 是否为叶节点
         */
        private boolean leaf;
        /**
         * 键的比较函数对象
         */
        private Comparable<K> kComparable;

        private BTreeNode(){
            entries = new ArrayList<>();
            children = new ArrayList<>();
            leaf = false;
        }

    }

    private static class Entry<K,V>{
        private K key;
        private V value;
        public Entry(K k, V v){
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


}
