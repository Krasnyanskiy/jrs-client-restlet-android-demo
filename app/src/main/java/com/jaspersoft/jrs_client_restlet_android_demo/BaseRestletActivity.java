package com.jaspersoft.jrs_client_restlet_android_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaspersoft.jrs_client_restlet_android_demo.service.RetrieveResourceTaskService;

import java.util.concurrent.ExecutionException;


public class BaseRestletActivity extends Activity {


    private static RetrieveResourceTaskService taskService;
    private static String URL =
            "http://172.28.146.32:8080/jasperserver-pro" +
                    "/rest_v2" +
                    "/resources" +
                    "/public/Samples/Domains/supermartDomain";
    private String retrievedEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_restlet);

        RetrieveResourceTaskService taskService = new RetrieveResourceTaskService();
        try {
            retrievedEntity = taskService.execute(URL).get();
        } catch (ExecutionException | InterruptedException ignored) {}

        TextView txtView = new TextView(this);
        txtView.setText(retrievedEntity);
        setContentView(txtView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_restlet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
