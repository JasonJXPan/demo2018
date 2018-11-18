package com.pjx.demo2018.dailytest.stream.w3c;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
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
        Stream.iterate(0, n->n+1).limit(10).forEach(System.out::print);
        System.out.println();
        System.out.println(System.currentTimeMillis()-start);

        //过滤从iterate函数生成的值
        LongStream.iterate(1, n->n+1).filter(this::isOdd).limit(3).forEach(System.out::print);
        System.out.println();

//        要从流中丢弃某些元素，请使用跳过操作。
//        skip（long n）是一个中间操作，跳过流的前n个元素
        Stream.iterate(1L, n -> n+1).skip(10).filter(this :: isOdd).limit(3).forEach(System.out::print);

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
        IntStream.generate(()->0).limit(2).forEach(System.out::println);
        IntStream.iterate(1, n-> n).limit(2).forEach(System.out::println);

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
                .forEach(n -> sb.append((char) n +""));
        logger.info(sb.toString());

        //Regex流
        System.out.println("Regex流");
        Pattern.compile(",").splitAsStream(str).forEach(n -> System.out.println(n));

        //Java流 - Java文件流
        System.out.println("Java流 - Java文件流");


        Path path = Paths.get("D:\\ana\\seller\\aaa.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(n-> System.out.println(n));
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


    private  boolean isOdd(long number) {
        if (number %2 == 1){
            return true;
        }
        return false;
    }
    static int seed = 0;
    private int nextInt() {
        return ++seed;
    }

    @Test
    public void ba3流匹配(){
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
        persons.stream().filter(Employee::isFemale).forEach(n -> n.setIncome(n.getIncome()*1.10));
        //下面两个是不同的值
        Employee.persons().stream().filter(Employee::isFemale).forEach(System.out::println);
        persons.stream().filter(Employee::isFemale).forEach(System.out::println);

        //Java流 - Java流过滤器
//        filter
//        中间操作
//        返回与指定谓词匹配的流。
        System.out.println("Java流 - Java流过滤器");
        Employee.persons().stream().filter(Employee::isFemale).map(n -> n.getName()).forEach(System.out::println);
        Employee.persons().stream().filter(n -> n.getIncome()>5000.0).forEach(System.out::println);

//        map
//        中间操作
//        对流执行一对一映射
//        映射操作对每个元素应用函数以产生另一流。
//        输入和输出流中的元素数量是相同的。
//        该操作不修改输入流的元素。
        IntStream.rangeClosed(1, 5).map(n->n*n).forEach(System.out::println);
        List<String> list = Arrays.asList("11", "22", "33");
        System.out.println("mapToInt");
        list.parallelStream().mapToInt(x -> Integer.parseInt(x)).forEach(System.out::println);
        list.parallelStream().mapToInt(x -> Integer.parseInt(x)).filter(x -> x>20).forEach(System.out::println);

        Employee.persons().stream().map(Employee::getName).forEach(System.out::println);
//        flatMap
//        中间操作
//        生成流扁平化。
//        Streams map()操作创建一个一对一映射。
//        streams flatMap()支持一对多映射。 它将每个元素映射到流，然后将流的流平面化为流。
        Stream.of(1,2, 3).flatMap(n -> Stream.of(n, n+1)).forEach(System.out::println);
        Stream.of("XML", "Java",  "CSS").map(n -> n.chars()).peek(e -> System.out.println("abcd_"+e))
                .flatMap(intStream -> intStream.mapToObj(n -> (char)n)).peek(e -> System.out.println("abc_"+e)).forEach(System.out::println);
        System.out.println("---分割线---");
        Stream.of("XML", "Java",  "CSS")
                .flatMap(name ->  IntStream.range(0, name.length()).mapToObj(name::charAt))
                .forEach(System.out::println);

        //Java流 - Java流组合
        System.out.println("Java流 - Java流组合");






    }

}
