package com.company.haaphoop.thinkingInJava.chapter15;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    /**
     * methodSet 返回对象的多有方法名，去重
     * @param type
     * @return
     */
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<String>();
        for (Method method : type.getMethods()) {
            result.add(method.getName());
        }
        return result;
    }

    /**
     * interfaces 打印type所有接口名
     * @param type
     */
    static void interfaces(Class<?> type) {
        System.out.print("Interface in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<String>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    /**
     * 返回object的所有方法名
     */
    static Set<String> object = methodSet(Object.class);

    /**
     * object添加clone方法
     */
    static {object.add("clone");}

    /**
     * superset 与subset两个类的不同方法名，同时去除object方法名
     * @param superset
     * @param subset
     */
    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset
                .getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet
                (subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }

}
