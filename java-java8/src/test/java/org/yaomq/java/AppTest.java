package org.yaomq.java;

import org.junit.Test;
import org.yaomq.java.pojo.Dish;
import org.yaomq.java.pojo.Trader;
import org.yaomq.java.pojo.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest {
    @Test
    public void test01(){
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
    }
    @Test
    public void test02(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        Stream<Dish> stream = menu.stream();

        //stream.forEach(System.out::println);

        Stream<Dish> dishStream = stream.filter(d -> d.getCalories() > 300);

        dishStream.forEach(System.out::println);

        Stream<String> stream1 = dishStream.map(d -> d.getName());
        Stream<String> limit = stream1.limit(3);
        List<String> threeHighCaloricDishNames = limit.collect(Collectors.toList());


    }
    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
        List<Integer> collect = stream.map(x -> x * x)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
    @Test
    public void test04(){
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> collect = list1.stream()
                .flatMap(
                        i -> list2.stream()
                                .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
        collect.forEach(a -> {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        });
    }
    @Test
    public void test05(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //找出2011年发生的所有交易，并按交易额排序（从低到高）。
//        List<Transaction> collect = transactions.stream()
//                .filter(x -> x.getYear() == 2011)
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);
        //交易员都在哪些不同的城市工作过？
//        List<String> collect = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getCity)
//                .distinct()
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);
        //查找所有来自于剑桥的交易员，并按姓名排序。
//        List<Trader> collect1 = transactions.stream()
//                .filter(x -> "Cambridge".equals(x.getTrader().getCity()))
//                .map(Transaction::getTrader)
//                .distinct()
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toList());
//        collect1.forEach(System.out::println);
        //返回所有交易员的姓名字符串，按字母顺序排序
//        String sorted = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getName)
//                .distinct()
//                .sorted()
//                .reduce("",(a,b)->a+" "+b);
//        System.out.println(sorted);
        //有没有交易员是在米兰工作的
//        Optional<Trader> any = transactions.stream()
//                .map(Transaction::getTrader)
//                .filter(trader -> "Milan".equals(trader.getCity()))
//                .findAny();
//        if (any.isPresent()){
//            System.out.println("存在");
//        } else {
//            System.out.println("不存在");
//        }

        //打印生活在剑桥的交易员的所有交易额
//        Optional<Integer> sum = transactions.stream()
//                .filter(ts -> "Cambridge".equals(ts.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .reduce(Integer::sum);
//        System.out.println("sum = " + sum.orElse(0));

        //所有交易中，最高的交易额是多少
//        Optional<Integer> optional = transactions.stream()
//                .map(Transaction::getValue)
//                .reduce(Integer::max);
//        System.out.println(optional.orElse(-1));

        //找到交易额最小的交易
//        Optional<Transaction> transaction = transactions.stream()
//                .min(Comparator.comparing(Transaction::getValue));
//
    }
}