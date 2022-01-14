package com.smithwang.demoproject1.Listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);

        System.out.println("应用程序上下文监听器contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ServletContextListener.super.contextDestroyed(sce);
        System.out.println("应用程序上下文监听器contextDestroyed");

    }
}
