package com.gyb.jse2test.day1207;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InspectorTest {

    public static void main(String[] args) {
        try {
            test01();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void test01() throws IntrospectionException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Employee类的BeanInfo对象（利用Class对象）
        BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);

        //获取Employee类的BeanInfo对象的所有描述属性数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        //利用反反射机制实例化一个Employee对象
        Class clazz = Employee.class;
        Constructor constructor = clazz.getConstructor();
        Employee employee = (Employee)constructor.newInstance();


        //遍历propertyDescriptors数组
        for(PropertyDescriptor propertyDescriptor:propertyDescriptors){
            if("name".equals(propertyDescriptor.getName())){
                System.out.println("找到name属性");
                //通过反射调用set方法赋值
                propertyDescriptor.getWriteMethod().invoke(employee, "Lily");

                //通过反射调用get取值
                System.out.println(propertyDescriptor.getReadMethod().invoke(employee));
            }
            if("age".equals(propertyDescriptor.getName())){
                System.out.println("找到age");
                propertyDescriptor.getWriteMethod().invoke(employee,1000);
                System.out.println(propertyDescriptor.getReadMethod().invoke(employee));
            }
        }


    }
}
