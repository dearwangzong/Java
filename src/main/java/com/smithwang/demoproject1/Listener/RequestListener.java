package com.smithwang.demoproject1.Listener;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener extends RequestContextListener {

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        System.out.println("应用程序上下文监听器requestInitialized");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        System.out.println("应用程序上下文监听器requestInitialized");
    }
}
