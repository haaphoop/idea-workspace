package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        System.out.println(Arrays.toString(path.list()));
        String[] list;
        if (1 == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(".*"));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }
}

/*
* 这里，DirFilter类“实现”了FilenameFilter接口，FilenameFilter接口是多么简单：
* public interface FilenameFilter {
* boolean accept(File dir, String name);
* }
* DirFilter这个类存在的唯一原因就是将accept()方法。创建这个类的目的在于把accept()方法提供给list()使用,使list()
* 可以回掉accept()，进而决定哪些文件包含在列表中。因此，这种结构也常常称为回掉。更具体地说，这是一个策略模式的例子，因为list()
* 实现了基本的功能，而且按照FilenameFilter的形式提供了这个策略，这意味着我们可以传递实习那了FilenameFilter
* 接口的任何类的对象，用以选择list()方法的行为方式。策略的目的就是提供了代码行为的灵活性。
* accept()方法必须接受一个代表某个特定文件所在目录的File对象，以及包含了那个文件名的一个String。记住一点：list()
* 方法会为此目录对象下的每个文件名调用accept()，用来判断该文件是否包含在内；判断结果由accept()返回的布尔值表示。
* accept()会使用一个正则表达式的matcher对象，来查看此正则表达式regex是否匹配这个文件的名字。通过使用accept()，list()
* 方法会返回一个数组。
*
* 匿名内部类
    这个例子很适合用一个匿名内部类进行改写。首先创建一个filter()方法，它会返回一个指向FilenameFilter的引用。
* */
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

class DirList2 {
    /*
    * 注意，传向filter()的参数必须是final的。这在匿名内部类中是必需的，这样它才能够使用来自该类范围之外的对象。
    * 这个设计有所改进，因为现在FilenameFilter类紧密地和DirList2绑定在一起。然而，我们可以进一步修改该方法，定义一个
    * 作为list()参数的匿名内部类；这样一来程序会变的更小：
    * */
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list = path.list(filter(".*"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);

    }
}

/*
* 既然匿名内部类直接使用args[0]， 那么传递给main()方法的参数现在就是final的。
* 这个例子展示了匿名内部类怎样通过创建特定的、一次性的类来解决问题。此方法的一个
* 优点是将解决特定问题的代码隔离、聚拢于一点。而另一方面，这种方法却不易阅读，因此要谨慎使用。
* */
class DirList3 {
    public static void main(final String[] args) {
        final String[] strings = {".*", ""};
        File path = new File(".");
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(strings[0]);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}