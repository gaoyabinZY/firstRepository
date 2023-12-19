package com.gyb.jse2test.day1207.work;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;

public class SimpleBean {


    public SimpleBean() {
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
    }

    public int getSize() {
        return 0;
    }

    public void setSize(int size) {
    }

    public static void main(String[] args) throws IntrospectionException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //实例化一个SimpleBean对象
        Class<SimpleBean> clazz = SimpleBean.class;
        SimpleBean simpleBean = clazz.getConstructor().newInstance();



        BeanInfo beanInfo = Introspector.getBeanInfo(SimpleBean.class);
        //获取beanInfo描述性数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        //遍历propertyDescriptors
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if("name".equals(propertyDescriptor.getName())){
                propertyDescriptor.getWriteMethod().invoke(simpleBean,"张三");
                System.out.println(propertyDescriptor.getReadMethod().invoke(simpleBean));
            }
            if("size".equals(propertyDescriptor.getName())){
                propertyDescriptor.getWriteMethod().invoke(simpleBean,100);
                System.out.println(propertyDescriptor.getReadMethod().invoke(simpleBean));
            }
        }

    }
}
