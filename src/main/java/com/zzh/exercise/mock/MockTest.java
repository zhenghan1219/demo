package com.zzh.exercise.mock;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/14
 */
public class MockTest {

    volatile  String a ;

    @Test
    public void test_verify(){
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 1. 在默认情况下，所有的方法都会有一个返回值。
     * mock 函数默认返回的是 null，一个空的集合或者一个被对象类型包装的内置类型。
     * 例如，针对 int/Integer 将会返回 0，针对 boolean/Boolean 将会返回 false。
     * 2. 打标（Stubbing）可以被重写：
     * 例如一个通用的打标可以在启动的时候被确定（fixture），但是测试方法可以对其进行重写（override）。
     * 请注意重写的打标可能会在有很多标记的时候存在潜在的问题。
     * 3. 一旦被打标，方法将会总是返回已标记的内容，这个与这个方法被调用多少次无关。
     * 4. 最后的标记非常重要——当你对有相同参数的方法进行多次标记的时候。
     * 换句话说就是：标记的顺序是与有关的（the order of stubbing matters），但是这个意义并不是很大。
     * 例如，这个只在标记完全相同的方法或者有时候参数匹配（argument matchers）被启用的时候，等情况下才会出现。 etc.
     */
    @Test
    public void test_stubbing(){
        LinkedList mockedList = mock(LinkedList.class);
        mockedList.add("one");
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException("没有这个值！！不要再跑了了"));

        //following prints "first"
        System.out.println(mockedList.get(0));

        //抛出runTimeException
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    /**
     * 参数匹配器
     */
    @Test
    public void test_argumentMatchers(){
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(argThat(isValid()))).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
        //verify(mockedList).add(argThat(someString -> someString.length() > 5));

    }

    @Test
    public void test_num(){
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void test_verification(){

        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first, then with "was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        //InOrder inOrder = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        //inOrder.verify(firstMock).add("was called first");
        //inOrder.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will
    }

    private static ArgumentMatcher isValid(){
       return new ArgumentMatcher() {
            @Override
            public boolean matches(Object o) {
                return false;
            }
        };
    }
}
