package org.maxur.tdd.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Maxim Yunusov
 * @version 1.0 15.02.14
 *
 *  Entry point classes define <code>onModuleLoad()</code>.
 */
public class Sample implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("container").add(new SampleView());
    }

}

