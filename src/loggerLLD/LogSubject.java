package com.example.jeetendra.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {

    private final Map<Integer, List<LogObserver>> logObservers;

    public LogSubject() {
        logObservers = new HashMap<>();
    }

    public void addObserver(int level, LogObserver observer) {
        List<LogObserver> observerList = logObservers.getOrDefault(level, new ArrayList<>());
        observerList.add(observer);
        logObservers.put(level, observerList);
    }

    public void notifyAll(int level, String message){
        for(LogObserver observer : logObservers.get(level)){
            observer.consumeLog(message);
        }
    }
}
