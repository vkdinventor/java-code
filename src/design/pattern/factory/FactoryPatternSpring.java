package design.pattern.factory;

import design.pattern.factory.annotation.Autowired;
import design.pattern.factory.annotation.Component;
import design.pattern.factory.annotation.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryPatternSpring {

    public static void main(String[] args) {

        // MyServiceFactory serviceFactory = ApplcationContext.getBean();
        //serviceFactory.getService("ONE");


    }
}

@Service
class MyServiceFactory {

    private static final Map<String, MyService> myServiceCache = new HashMap<>();

    @Autowired
    public MyServiceFactory(List<MyService> services) {
        for (MyService service : services) {
            myServiceCache.put(service.getType(), service);
        }
    }

    public static MyService getService(String type) {
        MyService service = myServiceCache.get(type);
        if (service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }
}

interface MyService {
    String getType();

    void checkStatus();
}

@Component
class MyServiceOne implements MyService {
    @Override
    public String getType() {
        return "one";
    }

    @Override
    public void checkStatus() {
        // Your code
    }
}

@Component
class MyServiceTwo implements MyService {
    @Override
    public String getType() {
        return "two";
    }

    @Override
    public void checkStatus() {
        // Your code
    }
}

@Component
class MyServiceThree implements MyService {
    @Override
    public String getType() {
        return "three";
    }

    @Override
    public void checkStatus() {
        // Your code
    }
}