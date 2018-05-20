package com.data.repository;

import com.data.net.Client;
import com.ggx.myapplication.executor.executor.DefaultExecutor;
import com.ggx.myapplication.executor.executor.UIThread;

import java.util.concurrent.Executor;

/**
 * Created by ggx
 */

public class BusinessContructor {
    public Repository repository;
    public Executor executor;
    public UIThread uiThread;

    public BusinessContructor(Client client) {
        this.repository = new Repository(client);
        executor = new DefaultExecutor();
        uiThread = UIThread.getInstance();
    }

    public void changeURL(String url) {
        this.repository = new Repository(new Client(new Client.ClientConfig(url)));
    }
}
