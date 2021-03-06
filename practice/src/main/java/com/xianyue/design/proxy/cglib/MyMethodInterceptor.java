package com.xianyue.design.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {
    static interface Inter1 {
        public void fun1();
    }

    static interface Inter2 {
        public void fun2(String arg);
    }

    public String myFunc1(String arg) {
        return "kakaka" + arg;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        
        if("fun1".equals(methodName)) {
            System.out.println("fun1 invoked");
            return null;
        }else if("fun2".equals(methodName)) {
            System. out .println( "[intercept] fun2 invoked before" );  
            String result = (String)args[0] + "..." ;  
            System. out .println( result );  
            System. out .println( "[intercept] fun2 invoked after" );  return result;
        } else if ( "myFunc1" .equals(methodName) ){  
            System. out .println( "[intercept] myFun1 invoked before" );  
            Object result = proxy. invokeSuper(obj, args);  
            System. out .println( result );  
            System. out .println( "[intercept] myFun1 invoked after" );  
            return result;  
        }
 
        return null;
    }
    
    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        
        enhancer.setSuperclass(MyMethodInterceptor.class);
        enhancer.setInterfaces(new Class[]{Inter1.class, Inter2.class});
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    public static void main(String[] args) {
        MyMethodInterceptor ss = new MyMethodInterceptor();  
        Object proxy = ss.createProxy();  
         
        // 接口  
        Inter1 inter1 = (Inter1)proxy;  
        inter1.fun1();  
         
        Inter2 inter2 = (Inter2)proxy;  
        inter2.fun2( "code generate library" );  
         
        // 类  
        MyMethodInterceptor c1 = (MyMethodInterceptor)proxy;  
        c1.myFunc1( "cglib" );
    }
}
