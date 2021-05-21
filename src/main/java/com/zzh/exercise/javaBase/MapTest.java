package com.zzh.exercise.javaBase;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2021/1/4
 */
public class MapTest {

    static Map<String,String> map = new HashMap<>();
    static Map<String,Integer> unSortMap = new HashMap<>();

    static {
        map.put("name","Tom");
        map.put("age","18");
        map.put("sex","man");
        map.put("country","China");
        unSortMap.put("z", 10);
        unSortMap.put("b", 5);
        unSortMap.put("a", 6);
        unSortMap.put("c", 20);
        unSortMap.put("d", 1);
        unSortMap.put("e", 7);
        unSortMap.put("y", 8);
        unSortMap.put("n", 99);
        unSortMap.put("g", 50);
        unSortMap.put("m", 2);
        unSortMap.put("f", 9);
    }
    @Test
    public void testMapPutToReturn(){
        /**
         * put 方法返回值问题
         * 如果put之前该key不存在，则会返回null；
         * 如果该key存在，则会覆盖旧值，返回新值；
         * 不管什么操作，都会覆盖旧值
         *
         */
        String data = map.put("2", "3");
        String newData = map.put("2", "4");
        System.out.println("data is --"+data);
        System.out.println("newData is --"+newData);
        /**
         * 返回被移除掉的值
         */
        String remove = map.remove("1");
        System.out.println("remove is --"+remove);

    }

    /**
     * 遍历map的四种方式
     *  map.keySet()获取key然后根据key获取value
     *  map.entrySet().iterator()遍历后获取Entry后单独获取key和value
     *  map.entrySet() 遍历获取，entry.getKey();entry.getValue();
     *  map.values() 获取所有的value，但是无法获取key
     *
     */
    @Test
    public void test_mapEntryInterface(){
        //1. 普遍使用，二次取值
        System.out.println("通过map.keySet()遍历");
        for (String key : map.keySet()) {
            System.out.println("key is->"+key+"; value is ->"+map.get(key));
        }
        //2 通过map.entrySet使用iterator遍历key和value
        System.out.println("通过map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key= "+next.getKey()+";value="+next.getValue());
        }
        //3. 推荐，尤其是大数据量的时候
        System.out.println("通过map.entrySet遍历key和value");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key==>"+entry.getKey()+" value ==> "+entry.getValue());
        }
        //4.遍历所有的value，不能遍历key
        System.out.println("遍历所有的value，不能遍历key");
        for (String value : map.values()) {
            System.out.println("value 是:"+value);
        }

    }

    /**
     * jdk1.8
     * comparingByKey：根据key进行排序，字符也可以排序
     */
    @Test
    public void test_comparingByKey(){

        //对旧的map进行排序之后保存到一个新的map中，toMap默认返回HashMap;
        LinkedHashMap<String, Integer> collect = unSortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        //toMap默认会返回hashMap,这里是返回LinkedHashMap
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("根据key排序是："+collect);

        //相当于上边写的
        LinkedHashMap<String, Integer> linked = new LinkedHashMap<>();
        unSortMap.entrySet().stream().
                sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> linked.put(x.getKey(), x.getValue()));
        System.out.println("linked 是："+linked);


    }

    /**
     * jdk1.8
     * comparingByValue: 根据value进行排序
     */
    @Test
    public void test_comparingByValue(){

        LinkedHashMap<String, Integer> collect1 = unSortMap.entrySet().stream()
                //按照value进行排序
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("根据value排序是："+collect1);

        LinkedHashMap<String, Integer> collect = unSortMap.entrySet().stream()
                //按照value进行倒序排序
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("倒序排序 "+collect);

        LinkedHashMap<String, Integer> collect2 = unSortMap.entrySet().stream()
                //按照value进行倒序排序
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("第二种倒序排序"+collect2);
    }
    /**
     * jdk 1.8
     *  如果key存在值，则返回存在的值；
     *  如果key不存在值，则返回null并将defaultValue存到value中
     */
    @Test
    public void test_getOrDefault(){
        map.put("1","2");
        String orDefault = map.getOrDefault("1", "3");
        System.out.println(orDefault);
    }
    /**
     * jdk1.8
     * 遍历key和value值；
     */
    @Test
    public void test_forEach(){
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

    /**
     * jdk1.8
     * 替换value的值
     */
    @Test
    public void test_replaceAll(){
        //将map中的value的值替换为大写
        map.replaceAll((k,v)->v.toUpperCase());
        System.out.println(map);
    }

   
    /**
     * jdk 1.8
     * 根据key和value删除,
     * key和value对应才能删除
     */
    @Test
    public void test_remove(){
        map.put("1","2");
        String value = map.get("1");
        System.out.println("value="+value);
        boolean remove = map.remove("1", "2");
        System.out.println("remove="+remove+"removeValue="+map.get("1"));
    }

    /**
     *  jdk1.8
     * 按照key或者key-value进行替换value
     */
    @Test
    public void test_replace(){
        map.put("1","a");
        System.out.println("remove before = "+map.get("1"));
        map.replace("1", "2");
        System.out.println("remove after = " +map.get("1"));
        map.replace("1","2","3");
        System.out.println("remove by old value = "+map.get("1"));
        //如果key和oldValue不同时存在则修改成功
        map.replace("1","4","5");
        System.out.println("remove by old value is not exist = "+map.get("1"));
    }

    /**
     *  jdk1.8
     *  如果key的值不存在，则存入value并返回null;
     *  如果key存在，则返回key中原先映射的value
     *  result:
     *  put=null and interest=football
     *  putIfAbsent=man and sex=man
     */
    @Test
    public void test_putIfAbsent(){
        String put = map.putIfAbsent("interest", "football");
        System.out.println("put="+put+" and interest="+map.get("interest"));
        String putIfAbsent = map.putIfAbsent("sex", "women");
        System.out.println("putIfAbsent="+putIfAbsent+" and sex="+map.get("sex"));
    }

    /**
     * 1.8
     * 如果会先判断key的值为null,
     * 如果key的值为null,
     * 则会将lambda的返回值设置为key为value值
     * 如果不为null，则会返回lambda的返回值
     * 都会返回lambda的值，将返回的值put到value值中
     *  摘抄：
     * 如果mappingFunction的值不为null，就把key=value放进去；
     * 如果mappingFunction的值为null，就不会记录该映射关系，返回值为null;
     * 如果mappingFunction的值的过程出现异常，再次抛出异常，不记录映射关系，返回null
     */
    @Test
    public void test_computeIfAbsent(){
        String name = map.computeIfAbsent("ins", v -> "abc");
        System.out.println("name="+name+"ins="+map.get("ins"));
        //如果
        map.computeIfAbsent("ins",k -> k+"def");
        System.out.println("ins-->"+map.get("ins"));
    }

    /**
     * jdk1.8
     * 摘录
     * key存在并且不为空，计算mappingFunction的值的value:
     * 如果value不为空，保存指定key和value的映射关系；
     * 如果value为null，remove(key)
     * 如果计算valued的过程抛出了异常，其方法中会再次抛出，key和其对应的值不会改变
     */
    @Test
    public void test_computeIfPresent(){
        //如果lambda表达式的返回为null，则remove(key);
        //如果返回的不是null，则将返回值设置为value的值
        map.computeIfPresent("name", (k, v) -> {
            if (StringUtils.isEmpty(v)) {
                return "abc";
            }
            return null;
        });
        System.out.println(map);
    }

    /**
     * jdk1.8
     * 如果lambda返回的值不为空，不论key是否已经存在，都将newValue设置的value
     * 如果为空，不建立映射并返回null
     */
    @Test
    public void test_compute(){
        //如果key的值不为空,则不论
        map.compute("ins",(k,v) ->{
            if (StringUtils.isEmpty(v)) {
                return null;
            }
            return "zxc";
        });
        System.out.println(map);
    }

    /**
     * jdk1.8
     *  如果key不存在，则将传入的key新加入，value为传入的值；
     *  如果key存在，value为null，则将传入的value值设置为value
     *  如果key存在，value不为null，如果表达式返回值为null，则会remove(key);
     *  如果key存在，value不为null，如果表达式返回值不为null，则会将表达式返回的值设置为value
     */
    @Test
    public void test_merge(){
        mergeData(1);
        mergeData(2);
        mergeData(3);
        mergeData(4);
    }

    public void mergeData(int result){
        switch (result){
            case 1 :
                map.merge("ins","Tom",(k,v) -> {
                    if (StringUtils.isEmpty(v)){
                        return "Jack";
                    }
                    return "Marry";
                });
                System.out.println("key is not null ->"+map);
                break;
            case 2:
                map.put("ins",null);
                map.merge("ins","Tom",(k,v) -> {
                    if (StringUtils.isEmpty(v)){
                        return "Jack";
                    }
                    return "Marry";
                });
                System.out.println("key is not null and value is null ->"+map);
                break;
            case 3:
                map.put("ins","Jemmy");
                map.merge("ins","Tom",(k,v) -> {
                    if (StringUtils.isEmpty(v)){
                        return "Jack";
                    }
                    return null;
                });
                System.out.println("key is not null and value is not null and lambda return is null ->"+map);
                break;
            case 4:
                map.merge("ins","Tom",(k,v) -> {
                    if (StringUtils.isEmpty(v)){
                        return "Jack";
                    }
                    return "Marry";
                });
                System.out.println("key is not null and value is not null and lambda return not null ->"+map);
                break;
            default:
                System.out.println("default ->"+map);
                break;
        }
    }

}
