package com.jaspersoft.jrs_client_restlet_android_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaspersoft.jrs_client_restlet_android_demo.common.EntityConverter;
import com.jaspersoft.jrs_client_restlet_android_demo.dto.ClientRoleCollection;
import com.jaspersoft.jrs_client_restlet_android_demo.service.RetrieveResourceTaskService;


public class BaseRestletClientActivity extends Activity {

    private static String URL = "http://172.28.146.32:8080/jasperserver-pro/rest_v2/roles?user=superuser";

    private RetrieveResourceTaskService taskService;
    private ClientRoleCollection clientRoles;
    private EntityConverter converter = new EntityConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_restlet);

        if (taskService == null) {
            taskService = new RetrieveResourceTaskService();
        }

        try {
            String entityAsString = taskService.execute(URL).get();
            clientRoles = converter.convert(entityAsString, ClientRoleCollection.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView txtView = new TextView(this);
        txtView.setText(clientRoles.toString());
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
