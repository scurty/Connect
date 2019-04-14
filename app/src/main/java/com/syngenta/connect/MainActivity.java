package com.syngenta.connect;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sap.smp.client.httpc.HttpConversationManager;
import com.sap.smp.client.httpc.IHttpConversation;
import com.sap.smp.client.httpc.events.IReceiveEvent;

// Fonte funcionando
// https://help.sap.com/doc/29b9b25ee01c42f58cb028c6e8456c7c/3.1/en-US/Documents/Android/SetupDevEnvironment/index.html

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpConversationManager manager = new HttpConversationManager(this);
        IHttpConversation conv = manager.create(Uri.parse("http://services.odata.org/V3/OData/OData.svc/"));

        conv.setResponseListener(event -> {
            Log.i("MyFirstProject", IReceiveEvent.Util.getResponseBody(event.getReader()));
        });
        conv.start();
    }
}
