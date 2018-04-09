package com.company.design.backup;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by daishuli on 2018/1/23.
 */
public class BeanUtils {
    public static HashMap<String, Object> backupProp(Object bean) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
            // 获得bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            // 获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            // 遍历所有属性
            for (PropertyDescriptor p :
                    descriptors) {
                // 属性名称
                String fieldName = p.getName();
                // 读取属性的方法
                Method getter = p.getReadMethod();
                // 读取属性值
                Object fieldValue = getter.invoke(bean, new Object[]{});
                if (!fieldName.equalsIgnoreCase("class")) {
                    result.put(fieldName,fieldValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 把hashmap的值返回到bean中
    public static void restoreProp(Object bean, HashMap<String, Object> propMap) {
        try {
            // 获得bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            // 获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor: descriptors
                 ) {
                // 属性名称
                String fieldName = propertyDescriptor.getName();
                // 如果有这个属性
                if (propMap.containsKey(fieldName)) {
                    // 写属性的方法
                    Method setter = propertyDescriptor.getWriteMethod();
                    setter.invoke(bean, new Object[]{propMap.get(fieldName)});
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
