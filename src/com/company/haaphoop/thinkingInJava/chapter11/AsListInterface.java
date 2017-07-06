package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/6 22:26
 * @Modified:
 */
public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(new Crusty(),new Slush(),new Power());
        //List<Snow> snows2 = Arrays.asList(new Light(), new Heavy());
        List<Snow> snows3 = new ArrayList<Snow>();
        Collections.addAll(snows3, new Light(),new Heavy());
        List<Snow> snows4 = Arrays.<Snow>asList(new Light(),new Heavy());
        /*
        *
        * 当试图创建snow2时，Arrays.asList()中只有Power类型，因此它会创建List<Power>，而不是List<Snow>
        * ，尽管Collections.addAll()工作的很好，因为它从第一个参数中了解到了目标类型是什么。
        * 正如你从创建snows4的操作中所看到的，可以在Arrays.asList()中间插入一条“线索”，一告诉编译器对于由
        * Arrays.asList()产生的List类型，实际的目标类型应该是什么。这称为显示类型参数说明。
        *
        * */
    }
}

class Snow{}
class Power extends Snow {}
class Light extends Power {}
class Heavy extends Power {}
class Crusty extends Snow {}
class Slush extends Snow {}

