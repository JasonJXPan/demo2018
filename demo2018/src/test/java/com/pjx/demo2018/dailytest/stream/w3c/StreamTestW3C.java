package com.pjx.demo2018.dailytest.stream.w3c;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by juqi on 18/11/16.
 */
public class StreamTestW3C {

    private static Logger logger = LoggerFactory.getLogger(StreamTestW3C.class);

    private static List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100);

    @Test
    public void test1() {

        long l = System.currentTimeMillis();
        int sum = 0;
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                sum += (number * number);
            }
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void test2() {
        long l = System.currentTimeMillis();
        int sum = numbers.stream().filter(x -> (x % 2) == 1).map(x -> x * x).reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void test3() {
        long l = System.currentTimeMillis();
        int sum = numbers.parallelStream().filter(x -> (x % 2) == 1).map(x -> x * x).reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void ba1流介绍() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();
        //过滤流
        System.out.println("过滤流");
        Stream<Integer> oddNumberStream = stream.filter(n -> n % 2 == 1);
        for (Object i : oddNumberStream.toArray()) {
            System.out.println(i);
        }
        //映射流
        System.out.println("映射流");
        Stream<Integer> integerStream = list.stream().map(n -> n * n);
        for (Object i : integerStream.toArray()) {
            System.out.println(i);
        }
        //Reduce流
        /**
         *  reduce(T identity，BinaryOperator< T>累加器)使用所提供的初始值和关联累积函数对该流的元素执行减少，并返回减小的值。

         这相当于:

         T result = identity;
         for (T element : this stream)
         result = accumulator.apply(result, element)
         return result;

         以下代码将流中的所有整数相加。
         int sum = aStream.reduce(0, (n1, n2) -> n1 + n2);

         Integer.sum()方法执行两个整数的和。

         我们可以使用方法引用重写代码。
         int sum = aStream.reduce(0, Integer::sum);
         */
        System.out.println("Reduce流");
        Integer reduce = list.stream().reduce(0, (n1, n2) -> (n1 + n2));
        System.out.println(reduce);
        Integer reduce1 = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce1);
        //有序流
        System.out.println("有序流");
        List<Integer> numbers = Arrays.asList(2, 1, 3, 2, 1, 4, 5);
        numbers.stream().filter(n -> (n % 2 == 1)).sorted().forEach(System.out::println);

        //optional
        System.out.println("Optional");
        Optional<String> str = Optional.of("www.w3cschool.cn");
        str.ifPresent(value -> System.out.println("Optional contains " + value));

        OptionalInt max = IntStream.of(1, 2, 3, 4, 5).filter(n -> n % 2 == 1).max();
//        OptionalInt max = IntStream.of(2,2,4).filter(n -> n % 2 == 1).max();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        } else {
            System.out.println("noting");
        }
        //返回Optional中包含的值。
//        如果Optional为空，它返回指定的defaultValue
        System.out.println(max.orElse(-1));
    }

    @Test
    public void ba2流创建() {
        //从值创建流
        System.out.println("从值创建流");
        Stream<String> stringStream = Stream.of("this is test");
        stringStream.forEach(System.out::println);

        Stream<String> multiStringStream = Stream.of("a", "b", "c");
        multiStringStream.forEach(System.out::println);

        String[] array = new String[]{"a1", "b1", "c1"};
        Stream.of(array).forEach(System.out::println);

        System.out.println("流构造器");
        Stream.Builder<String> stringBuilder = Stream.<String>builder().add("a2").add("a3");
        stringBuilder.build().forEach(logger::info);


        //intStream
        System.out.println("intStream");
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();
        LongStream.rangeClosed(1, 10).forEach(System.out::print);

        //Java流 - Java函数流
        System.out.println("Java流 - Java函数流");
        //<T> Stream<T> iterate(T  seed, UnaryOperator<T>  f)
        // iterate()方法创建顺序有序流。
        //<T> Stream<T> generate(Supplier<T> s)
        // generate()方法创建一个顺序无序流。
        //有序无序是说 iterate的顺序是后一个数基于前面一个数， generate也可以，不过它的supplier需要实现后一个数据基于前面的数据,如下面的next()方法

        /*Stream.iterate()

        iterate()方法有两个参数:种子和函数。

        种子是流的第一个元素。通过将函数应用于第一元素来生成第二元素。通过对第二元素应用函数来生成第三元素。

        因此，元素是:seed，f(seed)，f(f(seed))，f(f(f(seed)))....

        以下代码创建了一个自然数流:
        Stream<Long> naturalNumbers = Stream.iterate(1L, n -> n + 1);

        limit(long maxSize)操作是产生另一个流的中间操作*/
        long start = System.currentTimeMillis();
        Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::print);
        System.out.println();
        System.out.println(System.currentTimeMillis() - start);

        //过滤从iterate函数生成的值
        LongStream.iterate(1, n -> n + 1).filter(this::isOdd).limit(3).forEach(System.out::print);
        System.out.println();

//        要从流中丢弃某些元素，请使用跳过操作。
//        skip（long n）是一个中间操作，跳过流的前n个元素
        Stream.iterate(1L, n -> n + 1).skip(10).filter(this::isOdd).limit(3).forEach(System.out::print);

//        Stream.generate()
//        generate(Supplier<T> s)使用Supplier来生成无限顺序无序流。
        System.out.println();

        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);
        Stream.<Integer>generate(this::nextInt).limit(5).forEach(System.out::println);

        //随机流
        System.out.println("随机流");
        new Random().ints().limit(6).forEach(System.out::println);
        //生成重复的数据
        System.out.println("生成重复的数据");
        IntStream.generate(() -> 0).limit(2).forEach(System.out::println);
        IntStream.iterate(1, n -> n).limit(2).forEach(System.out::println);

        //集合流
        System.out.println("集合流");
        //数组的流
        IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        stream.forEach(System.out::println);
        Stream<String> stream1 = Arrays.stream(new String[]{"this", "is", "real"});
        stream1.forEach(System.out::println);
        //集合流
        List<String> list = Arrays.asList("collection", "stream");
        list.stream().forEach(System.out::println);
        Set<String> set = new HashSet<>();
        set.add("set");
        set.add("set1");
        set.parallelStream().forEach(System.out::println);

        //字符串流
        System.out.println("字符串流");
        String str = "5 123,123,qwe,1,123, 25";
        StringBuilder sb = new StringBuilder();
        str.chars().filter(n -> (!Character.isDigit(n) && !Character.isWhitespace(n)))
                .forEach(n -> sb.append((char) n + ""));
        logger.info(sb.toString());

        //Regex流
        System.out.println("Regex流");
        Pattern.compile(",").splitAsStream(str).forEach(n -> System.out.println(n));

        //Java流 - Java文件流
        System.out.println("Java流 - Java文件流");


        Path path = Paths.get("D:\\ana\\seller\\aaa.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(n -> System.out.println(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path1 = Paths.get(".");
        System.out.println(path1.toAbsolutePath());

//        try (Stream<Path> fileTree = Files.walk(path1)){
//            fileTree.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    private boolean isOdd(long number) {
        if (number % 2 == 1) {
            return true;
        }
        return false;
    }

    static int seed = 0;

    private int nextInt() {
        return ++seed;
    }

    @Test
    public void ba3流匹配() {
//        peek
//        中间操作
//        应用调试的操作。
        System.out.println("流 Peek");

        Integer reduce = Stream.of(1, 2, 3, 4, 5).peek(e -> System.out.println("taking Integer:" + e))
                .filter(n -> n % 2 == 1).peek(e -> System.out.println("filtering Integer:" + e))
                .map(n -> n * n).peek(e -> System.out.println("mapped Integer:" + e)).reduce(0, Integer::sum);
        System.out.println(reduce);
        //流 ForEach
//        终端操作
//        对流中的每个元素应用操作。
        System.out.println("流 ForEach");
//        forEach()方法不保证操作的顺序应用流中的每个元素。
//        forEachOrdered()方法按元素的顺序执行操作由流定义。
//        forEachOrdered()方法可能会减慢并行流中的处理速度。
        Employee.persons().stream().filter(Employee::isFemale).forEach(System.out::println);

        //使用forEach()方法将所有女性的收入增加10％
        List<Employee> persons = Employee.persons();
        persons.stream().filter(Employee::isFemale).forEach(n -> n.setIncome(n.getIncome() * 1.10));
        //下面两个是不同的值
        Employee.persons().stream().filter(Employee::isFemale).forEach(System.out::println);
        persons.stream().filter(Employee::isFemale).forEach(System.out::println);

        //Java流 - Java流过滤器
//        filter
//        中间操作
//        返回与指定谓词匹配的流。
        System.out.println("Java流 - Java流过滤器");
        Employee.persons().stream().filter(Employee::isFemale).map(n -> n.getName()).forEach(System.out::println);
        Employee.persons().stream().filter(n -> n.getIncome() > 5000.0).forEach(System.out::println);

//        map
//        中间操作
//        对流执行一对一映射
//        映射操作对每个元素应用函数以产生另一流。
//        输入和输出流中的元素数量是相同的。
//        该操作不修改输入流的元素。
        IntStream.rangeClosed(1, 5).map(n -> n * n).forEach(System.out::println);
        List<String> list = Arrays.asList("11", "22", "33");
        System.out.println("mapToInt");
        list.parallelStream().mapToInt(x -> Integer.parseInt(x)).forEach(System.out::println);
        list.parallelStream().mapToInt(x -> Integer.parseInt(x)).filter(x -> x > 20).forEach(System.out::println);

        Employee.persons().stream().map(Employee::getName).forEach(System.out::println);
//        flatMap
//        中间操作
//        生成流扁平化。
//        Streams map()操作创建一个一对一映射。
//        streams flatMap()支持一对多映射。 它将每个元素映射到流，然后将流的流平面化为流。
        Stream.of(1, 2, 3).flatMap(n -> Stream.of(n, n + 1)).forEach(System.out::println);
        Stream.of("XML", "Java", "CSS").map(n -> n.chars()).peek(e -> System.out.println("abcd_" + e))
                .flatMap(intStream -> intStream.mapToObj(n -> (char) n)).peek(e -> System.out.println("abc_" + e)).forEach(System.out::println);
        System.out.println("---分割线---");
        Stream.of("XML", "Java", "CSS")
                .flatMap(name -> IntStream.range(0, name.length()).mapToObj(name::charAt))
                .forEach(System.out::println);

        //Java流 - Java流组合
        System.out.println("Java流 - Java流组合");

        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        int reduce1 = stream.reduce(0, Integer::sum);
        System.out.println(reduce1);

        Double reduce2 = Employee.persons().stream().map(x -> x.getIncome()).reduce(0.0d, Double::sum);
        System.out.println(reduce2);

        Double reduce3 = Employee.persons().stream().reduce(0.0d, (partialSum, person) -> partialSum + person.getIncome(), Double::sum);
        System.out.println(reduce3);

        Long time1 = System.currentTimeMillis();
        Double reduce4 = Employee.persons().stream().reduce(0.0d,
                (partialSum, person)
                        -> {
                    double accumulated = partialSum + person.getIncome();
                    System.out.println(Thread.currentThread().getName() + "  - Accumulator: partialSum  = " + partialSum
                            + ",  person = " + person + ", accumulated = " + accumulated);
                    return accumulated;
                }, (a, b) -> {
                    double combined = a + b;
                    System.out.println(Thread.currentThread().getName() + "  - Combiner:  a  = " + a + ", b  = " + b
                            + ", combined  = " + combined);
                    return a + b;
                });
        System.out.println(reduce4);
        System.out.println(System.currentTimeMillis() - time1);

        time1 = System.currentTimeMillis();
        Double reduce5 = Employee.persons().parallelStream().reduce(0.0d,
                (partialSum, person)
                        -> {
                    double accumulated = partialSum + person.getIncome();
                    System.out.println(Thread.currentThread().getName() + "  - Accumulator: partialSum  = " + partialSum
                            + ",  person = " + person + ", accumulated = " + accumulated);
                    return accumulated;
                }, (a, b) -> {
                    double combined = a + b;
                    System.out.println(Thread.currentThread().getName() + "  - Combiner:  a  = " + a + ", b  = " + b
                            + ", combined  = " + combined);
                    return a + b;
                });
        System.out.println(reduce5);
        System.out.println(System.currentTimeMillis() - time1);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Optional<Integer> reduce6 = integerStream.reduce(Integer::sum);
        Optional<Integer> reduce7 = Stream.<Integer>empty().reduce(Integer::sum);
        printOptional(reduce6);
        printOptional(reduce7);

//        Double reduce8 = Employee.persons().parallelStream().map(x -> x.getIncome()).reduce(0.0d, (x, y) -> {
//            if (x.compareTo(y)>0) {
//                return x;
//            }
//            return y;
//        });
//        Employee.persons().parallelStream().filter(x -> x.getIncome() == reduce8.doubleValue()).forEach(x -> System.out.println(x));
        time1 = System.currentTimeMillis();
        Optional<Employee> reduce8 = Employee.persons().parallelStream().reduce((x, y) -> x.getIncome() > y.getIncome() ? x : y);
        if (reduce8.isPresent()) {
            System.out.println(reduce8.get());
        }
        System.out.println(System.currentTimeMillis() - time1);

//Java流 - Java流聚合
        System.out.println("Java流 - Java流聚合");

        double sum = Employee.persons().stream().mapToDouble(x -> x.getIncome()).sum();
        System.out.println(sum);

        Optional<Employee> max = Employee.persons().parallelStream().max(Comparator.comparingDouble(x -> x.getIncome()));
        printOptional(max);

        OptionalDouble max1 = Employee.persons().parallelStream().mapToDouble(x -> x.getIncome()).max();
        if (max1.isPresent()) {
            System.out.println(max1.getAsDouble());
        }

        //Java流计数
        System.out.println("Java流计数");

        long count = Employee.persons().parallelStream().count();
        System.out.println(count);
        long sum1 = Employee.persons().parallelStream().mapToLong(x -> 1L).sum();
        System.out.println(sum1);
        long reduce9 = Employee.persons().parallelStream().mapToLong(x -> 1L).reduce(0L, Long::sum);
        System.out.println(reduce9);
        Long reduce10 = Employee.persons().parallelStream().reduce(0L, (partialSum, person) -> partialSum + 1L, Long::sum);
        System.out.println(reduce10);

//        Java流 - Java流收集器
//        collect()方法的第一个版本有三个参数:
//
//        供应商提供一个可变容器来存储结果。
//        累加器，将结果累积到可变容器中。
//        组合器，当并行使用时组合部分结果。
        System.out.println("Java流 - Java流收集器");

//        我们使用以下步骤在ArrayList <String>中收集员工姓名。
//        首先，创建一个供应商，它使用以下语句之一返回一个 ArrayList< String> 以创建供应商：
//        Supplier<ArrayList<String>> supplier = () -> new ArrayList<>();
//        要么
//        Supplier<ArrayList<String>> supplier = ArrayList::new;
//        第二，创建一个累加器，它接收两个参数，它们是从供应商返回的容器（在这种情况下为ArrayList <String>）。 和流的元素。
//        累加器将名称添加到列表中。
//        BiConsumer<ArrayList<String>, String>  accumulator = (list, name)  ->  list.add(name);
//        BiConsumer<ArrayList<String>, String>  accumulator = ArrayList::add;
//        最后，组合器将结果组合成一个 ArrayList<String> 。
        ArrayList<String> collect = Employee.persons().parallelStream().map(Employee::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(collect);
        List<String> collect1 = Employee.persons().stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect1);
        Set<String> collect2 = Employee.persons().parallelStream().map(x -> x.getName()).collect(Collectors.toSet());
        System.out.println(collect2);
        SortedSet<String> collect3 = Employee.persons().parallelStream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect3);

//        Java流 - Java流统计
        System.out.println("Java流 - Java流统计");
        DoubleSummaryStatistics statistics = new DoubleSummaryStatistics();
        statistics.accept(100.0);
        statistics.accept(300.0);
        statistics.accept(230.0);
        statistics.accept(422.0);

        long statisticsCount1 = statistics.getCount();
        double statisticsSum1 = statistics.getSum();
        double statisticsMin1 = statistics.getMin();
        double statisticsAvg1 = statistics.getAverage();
        double statisticsMax1 = statistics.getMax();

        System.out.printf(
                "count=%d, sum=%.2f,  min=%.2f,  average=%.2f, max=%.2f%n", statisticsCount1, statisticsSum1,
                statisticsMin1, statisticsAvg1, statisticsMax1);

        DoubleSummaryStatistics collect4 = Employee.persons().stream().map(Employee::getIncome).collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
        System.out.println(collect4.toString());

        DoubleSummaryStatistics collect5 = Employee.persons().parallelStream().collect(Collectors.summarizingDouble(Employee::getIncome));
        System.out.println(collect5);

//        Java流 - Java流收集映射
        System.out.println("Java流 - Java流收集映射");

//        第一个版本有两个参数。这两个参数都是一个函数。
//        第一个参数将流元素映射到映射中的键。
//        第二个参数将流元素映射到映射中的值。
//        如果重复键，则抛出IllegalStateException。
        Map<Long, String> collect6 = Employee.persons().parallelStream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(collect6);

//        合并函数传递重复键的旧值和新值。 该函数应合并两个值，并返回将用于键的新值。

        Map<Employee.Gender, String> collect7 = Employee.persons().parallelStream().collect(Collectors.toMap(Employee::getGender, Employee::getName, (oldValue, newValue) -> String.join(", ", oldValue, newValue)));
        System.out.println(collect7);

        Map<Employee.Gender, Long> collect8 = Employee.persons().stream().collect(Collectors.toMap(Employee::getGender, p -> 1L, (oldCount, newCount) -> oldCount + newCount));
        System.out.println(collect8);

        Map<Employee.Gender, Employee> collect9 = Employee.persons().stream().collect(Collectors.toMap(Employee::getGender, Function.identity(), (oldPerson, newPerson) -> oldPerson.getIncome() > newPerson.getIncome() ? oldPerson : newPerson));
        System.out.println(collect9);

        //Java流连接
        System.out.println("Java流连接");
        String collect10 = Employee.persons().stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(collect10);
        String collect11 = Employee.persons().stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collect11);
        String hello = Employee.persons().stream().map(Employee::getName).collect(Collectors.joining(",", "Hello ", ". GoodBye."));
        System.out.println(hello);

//        Java流分组
        System.out.println("Java流分组");
        Map<Employee.Gender, Long> collect12 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect12);

        Map<Employee.Gender, String> collect13 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.joining(","))));
        System.out.println(collect13);

        Map<Employee.Gender, List<String>> collect14 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));

        Map<Employee.Gender, List<Employee>> collect15 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(collect15);

        Map<Employee.Gender, Map<Month, String>> collect16 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(x -> x.getDob().getMonth(), Collectors.mapping(Employee::getName, Collectors.joining()))));
        System.out.println(collect16);

        Map<Employee.Gender, Optional<Double>> collect17 = Employee.persons().stream().collect(
                Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getIncome, Collectors.reducing(Double::sum))));
        System.out.println(collect17);
        Map<Employee.Gender, DoubleSummaryStatistics> collect18 = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getIncome)));
        System.out.println(collect18);

        //Java流 - Java流分区
        System.out.println("Java流 - Java流分区");

        Map<Boolean, List<Employee>> collect19 = Employee.persons().stream().collect(Collectors.partitioningBy(Employee::isFemale));
        System.out.println(collect19);

        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("1");
        s.add("2");

        Map<String, Optional<String>> collect20 = s.stream().collect(Collectors.groupingBy(String::toString, Collectors.mapping(String::toString, Collectors.reducing((x, y) -> x))));
        System.out.println(collect20);

        Map<Boolean, String> collect21 = Employee.persons().stream().collect(Collectors.partitioningBy(Employee::isFemale, Collectors.mapping(Employee::getName, Collectors.joining(","))));
        System.out.println(collect21);
        //Java流转换收集器结果
        System.out.println("Java流转换收集器结果");
        List<String> names = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        result ->  Collections.unmodifiableList(result)));

        ///Java流 - Java流查找
        System.out.println("Java流 - Java流查找");
        List<Employee> perseonsTest = Employee.persons();
        // Find any male
        Optional<Employee> anyMale = perseonsTest.stream().filter(Employee::isFemale).findAny();
        if (anyMale.isPresent()) {
            System.out.println("Any male:   " + anyMale.get());
        } else {
            System.out.println("No male  found.");
        }
        // Find the first male
        Optional<Employee> firstMale = perseonsTest.stream().filter(Employee::isFemale).findFirst();
        if (firstMale.isPresent()) {
            System.out.println("First male:   " + anyMale.get());
        } else {
            System.out.println("No male  found.");
        }

        ///Java流 - Java流匹配
        System.out.println("Java流 - Java流匹配");
        // Check if all persons are males
        boolean allMales = Employee.persons().stream().allMatch(Employee::isFemale);
        System.out.println("All  males: " + allMales);

        // Check if any person was born in 1971
        boolean anyoneBornIn1971 = Employee.persons().stream().anyMatch(p -> p.getDob().getYear() == 1971);
        System.out.println("Anyone born  in 1971:  " + anyoneBornIn1971);


        String namesA = Employee.persons()
                .stream()
                .filter(x -> !x.isFemale())
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(namesA);

        namesA = Employee.persons()
                .parallelStream()
                .filter(x -> !x.isFemale())
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(namesA);
    }

    private void printOptional(Optional optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("null value");
        }
    }

}
