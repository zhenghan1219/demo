package com.zzh.exercise.javaBase;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/5/11
 */
public class QueueTest {

    public static class Node{
        private Long goodsId;
        private Integer sortValue;

        public Node(Long goodsId,Integer sortValue){
            this.goodsId =goodsId;
            this.sortValue = sortValue;
        }

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public Integer getSortValue() {
            return sortValue;
        }

        public void setSortValue(Integer sortValue) {
            this.sortValue = sortValue;
        }
    }
    @Test
    public void test_PriorityQueue(){

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.getSortValue()-o1.getSortValue();
            }
        });

    }

    private static void targetsortbyorder(List orderList, List targetList) {
        targetList.sort(((a1, a2) -> {
            int b1 = orderList.indexOf(a1);
            int b2 = orderList.indexOf(a2);
            boolean isAllOrNone=(b1>-1&&b2>-1)||(b1<0&&b2<0);
            return isAllOrNone?b1-b2:b2-b1;
        }));
    }

    public static void main(String[] args) {
        List orderList = Arrays.asList("a");
        List targetList = Arrays.asList("b");
        targetsortbyorder(orderList, targetList);
    }


}
