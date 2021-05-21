package com.zzh.exercise.javaBase;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/12/21
 */
public class BizService {

    /**
     * 传统if else
     */
    public String getCheckResult(String order) {
        if ("校验1".equals(order)) {
            return "执行业务逻辑1";
        } else if ("校验2".equals(order)) {
            return "执行业务逻辑2";
        }else if ("校验3".equals(order)) {
            return "执行业务逻辑3";
        }else if ("校验4".equals(order)) {
            return "执行业务逻辑4";
        }else if ("校验5".equals(order)) {
            return "执行业务逻辑5";
        }else if ("校验6".equals(order)) {
            return "执行业务逻辑6";
        }else if ("校验7".equals(order)) {
            return "执行业务逻辑7";
        }else if ("校验8".equals(order)) {
            return "执行业务逻辑8";
        }else if ("校验9".equals(order)) {
            return "执行业务逻辑9";
        }
        return "不在处理的逻辑中返回业务错误";
    }

    /**
     * 业务逻辑分派Map
     * Function为函数式接口，下面代码中 Function<String, String> 的含义是接收一个Stirng类型的变量，返回一个String类型的结果
     */
    Map<String, Function<String,String>> checkResultDispatcher = new HashMap<>();
    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    public void checkResultDispatcherInit() {
        checkResultDispatcher.put("校验1",order -> String.format("对%s执行业务逻辑1",order));
    }

    public String getCheckResultSuper(String order) {
        Function<String, String> result = checkResultDispatcher.get(order);
        if (result != null){
            result.apply(order);
        }
        return "不在处理的逻辑中返回业务错误";
    }
}
