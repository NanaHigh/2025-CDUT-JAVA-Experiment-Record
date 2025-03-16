package Ex3;

import Ex3.Depends.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ex3_2 {
    public static void main(String[] args) {
        Well well = new Well();
        List<Integer> numbers = new ArrayList<>();
        // 填充 1~19 的列表
        for (int i = 1; i < 20; i++) {
            numbers.add(i);
        }
        
        // 打乱列表顺序
        Collections.shuffle(numbers);
        
        // 按随机顺序遍历所有数字
        for (int num : numbers) {
            Family family = new Family(num, well);
            family.Drink();
        }
    }
}
