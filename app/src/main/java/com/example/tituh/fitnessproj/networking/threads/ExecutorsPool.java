package com.example.tituh.fitnessproj.networking.threads;

import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsPool {

    private static final String TAG = ExecutorsPool.class.getSimpleName();

    private static final ExecutorsPool instance = new ExecutorsPool();

    public static ExecutorsPool getInstance() {
        return instance;
    }

    public static final String TASKS_GROUP_COMMON = "common_tasks_group";
    public static final String TASKS_GROUP_DEDICATED = "dedicated_tasks_group";

    private HashMap<String, ExecutorService> executors = new HashMap<>();
    private int maxThreadsCount;

    private ExecutorsPool() {
        int cores = Runtime.getRuntime().availableProcessors();
        if (cores<=1) cores = 2;
        maxThreadsCount = cores - 1;
        Log.d(TAG, "Download Threads: "+ maxThreadsCount);
        executors.put(TASKS_GROUP_COMMON, Executors.newFixedThreadPool(maxThreadsCount));
        executors.put(TASKS_GROUP_DEDICATED, Executors.newFixedThreadPool(1));
    }

    public static void runCommonBgTask(Runnable task){
        try {
            instance.executors.get(TASKS_GROUP_COMMON).execute(task);
        } catch (Exception e) {
            Log.e(TAG, "Exception on runCommonBgTask: ",e);
        }
    }

    public static void runDedicatedBgTask(Runnable task){
        try {
            instance.executors.get(TASKS_GROUP_DEDICATED).execute(task);
        } catch (Exception e) {
            Log.e(TAG, "Exception on runDownloadBgTask: ",e);
        }
    }

    public static ExecutorService getExecutorService(String tag) {
        if (getInstance().executors.containsKey(tag)) {
            return getInstance().executors.get(tag);
        } else {
            return null;
        }
    }
}