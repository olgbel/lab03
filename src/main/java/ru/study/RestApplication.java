package ru.study;

import ru.study.client.DemoRS;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> set = new HashSet<>();
//        set.add(DemoRS.class);
//        return set;
//    }
}
