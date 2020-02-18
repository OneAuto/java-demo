package Refiect;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Hero {
    private String name;
    private Integer id;
    static {
        System.out.println("Hero类初始化加载...");
    }
}
