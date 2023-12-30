package jpabook.jpashop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void 스트림_테스트1() {
        List<String> sList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<String> stream1 = sList.stream();


        String[] arr = {"a", "b", "c", "d", "e"};
        Stream<String> stream2 = Arrays.stream(arr);

        // 내부 반복문
//        sList.forEach(str -> System.out.println(str));

        //parallelStream
//        sList.parallelStream().forEach(str -> System.out.println(str));


        // stream
//        stream1.forEach(str -> System.out.println(str));
//        stream2.forEach(str -> System.out.println(str));

        Long count = sList.stream().distinct().count();
        System.out.println(count);

    }
}
