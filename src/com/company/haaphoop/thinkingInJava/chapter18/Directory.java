package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

public final class Directory {
    /*
    * local()方法使用被称为listFile()的File.list()
    * 的变体来产生File数组。可以看到，它还使用了FilenameFilter。如果需要list而不是数组，你可以使用Arrays.asList
    * ()自己对结果进行转换。
    *
    * */
    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pFormat(dirs) + "\nfiles: " + PPrint
                    .pFormat(files);
        }
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()){
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    /*
    * walk()方法将开始目录的名字转换为File对象，然后调用recurseDirs()，该方法将递归地遍历目录，并在每次递归中都收集
    * 更多的信息。为了区分普通文件和目录，返回值实际上是一个对象“元祖”---一个List持有所有普通文件，另一个持有目录。这里
    * ，所有的域都被有意识地设置成了public，因为TreeInfo的使命只是将对象收集起来--如果你只是返回List
    * ，那么就不需要设置为private,因为TreeInfo的使命只是返回一个对象对，不需要将它们设置为private。注意，TreeInfo
    * 实现了Iterable<File>，它将产生文件，使你拥有再文件列表上的默认迭代，而你可以通过声明“.dirs”来指定目录。
    * */
    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static void main(String[] args) {
        System.out.println(walk("."));

    }
}class PPrint {
    public static String pFormat(Collection<?> collection) {
        if (collection.size() == 0) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        for (Object item: collection) {
            if (collection.size() != 1) {
                sb.append("\n ");
            }
            sb.append(item);
        }

        if (collection.size() != 1) {
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void pprint(Collection<?> collection) {
        System.out.println(pFormat(collection));
    }

    public static void pprint(Object[] c) {
        System.out.println(pFormat(Arrays.asList(c)));
    }
}
