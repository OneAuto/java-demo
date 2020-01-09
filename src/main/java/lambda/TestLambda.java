package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestLambda {
    public static void main(String[] args) {
        //匿名类表达式
        Comparator c=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //Lambda表达式
        c=(Object o1,Object o2)->{
            return 0;
        };

        //Lambda表达式去掉return
        c=(Object o1,Object o2)->0;

        //Lambda表达式去掉参数类型
        c=(o1, o2) -> 0;

        //两个参数不能去掉括号
        Collections.sort(new ArrayList<Integer>(),c);

        //将Lambda表达式作为参数传递
        Collections.sort(new ArrayList<Integer>(),(o1,o2)->0);
    }
}
