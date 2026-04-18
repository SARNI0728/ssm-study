package com.sarni.spring01ioc;

import com.sarni.spring01ioc.controller.userController;
import com.sarni.spring01ioc.dao.OrderDAO;
import com.sarni.spring01ioc.dao.userDAO;
import com.sarni.spring01ioc.pojo.Car;
import com.sarni.spring01ioc.pojo.Cat;
import com.sarni.spring01ioc.pojo.Dog;
import com.sarni.spring01ioc.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Spring01IocApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        Car car = ioc.getBean(Car.class);
        System.out.println(car);
    }

    public static void testProfile(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        OrderDAO orderDAO = ioc.getBean(OrderDAO.class);
        System.out.println("orderDAO = " + orderDAO);
    }

    public static void testValue(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        Cat cat = ioc.getBean(Cat.class);
        System.out.println("cat = " + cat);
    }

    // 测试注入方式2: 使用构造器进行注入
    public static void testInjectByConstructor(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        userDAO bean = ioc.getBean(userDAO.class);
        System.out.println("bean = " + bean);
    }

    public static void testAutowired(String[] args) {
        // 注入： 在使用Spring以后， 就不再需要我们自己手动创建对象了， 而是由Spring来帮我们创建对象
        // 注入方式1: 在需要使用的类中， 通过@Autowired注解来注入需要的对象
        // 方式2: 在需要使用的类中， 通过构造方法来注入需要的对象
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        // 可以在userController中看到AutoWired注解的使用
        userController controller = ioc.getBean(userController.class);

        System.out.println("controller = " + controller);

    }

    public static void testScope(String[] args) {
        // scope的使用：
        // 1. 单例(singeleton)： 容器启动时创建对象，以后每次获取都是同一个对象. (默认)
        // 2. 原型(prototype)： 容器启动时不创建对象，每次获取都是一个新的对象
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        for (String s : ioc.getBeanDefinitionNames()){
            System.out.println("s = " + s);
        }

        for (String s : ioc.getBeansOfType(Person.class).keySet()) {
            System.out.println("s = " + s);
        }

        ioc.getBeansOfType(Dog.class).forEach((s, dog) -> System.out.println("发现一只小狗"));
    }

    public void test01(String[] args) {
        // 跑起一个springboot应用 ApplicationContext为SpringBoot的上下文对象，它是一个Ioc容器
        // Ioc： Inversion of Control 控制反转， 依赖注入 （暂时不理解）
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc = " + ioc);

        System.out.println("=============");

        // 获取容器中所有的beanDefinitionName
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        System.out.println("=============");

        // 获取组件：
        // 1. 若是组件只有一个，则可以通过getBean(组件的类型)或是组件的名字来获取
        // 2. 若是组件有多个，则需要通过getBeansOfType(组件的类型)来获取
        // 3. 若是组件没有注册，则会报错
        // 4. 若是通过getBean(组件的类型)获取该类型下不唯一的组件时，则会报错。
        // 因为可能有多个组件的类型，需要通过getBeansOfType(组件的类型)来获取

        // 配置类：
        // 配置类也是一个类，它的作用是管理下面这些@Bean注解生成的那些对象

        // 通过组件名字获取对象
        Person sarni = (Person) ioc.getBean("sarni");

        // 通过组件类型获取对象
        // Person bean = ioc.getBean(Person.class);


        System.out.println("=============");

        // 通过组件类型获取一组对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("person = " + s);
        }

        System.out.println(ioc.getBean(Dog.class));

        // 通过类型+名字获取组件
        Person sarni1 = ioc.getBean("sarni", Person.class);

    }

    //向容器中注册一个组件 (已经全部迁移到了配置类)
    /*@Bean
    public Person sarni() {
        return new Person("sarni", 18);
    }

    @Bean
    public Person gaojinxuan() {
        return new Person("gaojinxuan", 18);
    }*/

}
