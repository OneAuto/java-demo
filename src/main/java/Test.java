import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println("==========交集: 集合A {1,2,3} 和集合B {2,3,4} 的交集为 {2,3}。即{1,2,3}∩{2,3,4}={2,3}==========");
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("aaa1");
        list1.add("ddd");

        List<String> list2 = new ArrayList<>();
        list2.add("aaa");
        list2.add("eee");
        list2.add("ccc");
        list2.add("fff");
        list2.add("aaa1");
        list2.add("aaa2");

        //合并List
        System.out.println(Stream.of(list1, list2)
                                 .flatMap(Collection::stream)
                                 .distinct()
                                 .collect(Collectors.toList()));
    }
}
