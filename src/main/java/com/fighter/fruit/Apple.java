package com.fighter.fruit;

import com.fighter.annotation.Fruit;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chj on 2015/12/22.
 */

@Fruit(name = "苹果",color = "红色")
public class Apple extends FruitBase {

    public Apple(){
        this.desc="我是苹果";
    }
}


class main{

    public static List<String> getClassName(String packageName) {
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(filePath, null);
        return fileNames;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }


    public static void main  (String [] args) throws Exception {
        Annotation [] anoatations=Apple.class.getAnnotations();
        for(Annotation ano : anoatations)
        {
            System.out.println(" type is : "+ano.annotationType());
        }

        if(Apple.class.isAnnotationPresent(Fruit.class))
        {
            Fruit fruit=Apple.class.getAnnotation(Fruit.class);
            System.out.println("name is " + fruit.name());
            System.out.println("color is " + fruit.color());
        }

        System.out.println("遍历所有水果");

        String basePackege="com.fighter";

        List<FruitBase> fruits=new ArrayList<FruitBase>();

        List<String> classNames = getClassName(basePackege);

        for(String className : classNames)
        {
            try
            {
                System.out.println("类型:"+className);
                Class c=Class.forName(className);

                if(c.isAnnotationPresent(Fruit.class) && FruitBase.class.isAssignableFrom(c) && !c.equals(FruitBase.class))
                {
                    System.out.println("添加:"+className);
                    fruits.add((FruitBase)c.newInstance());
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }



        for(FruitBase fruit:fruits)
        {
            Class cf=fruit.getClass();
            Field field;

            field=FruitBase.class.getDeclaredField("desc");

            if(field!=null)
                field.set(fruit,(String)field.get(fruit)+" suffix ");

            System.out.println(fruit.getDesc());
        }


        return ;
    }
}