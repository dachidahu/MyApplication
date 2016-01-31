package com.example.ruju.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.Random;
import com.example.ruju.myapplication.OkDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    GraphView graph;
    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(graphView);

        setContentView(R.layout.activity_main);
        float[] values = new float[] { 0.0f,0.0f, 0.0f, 0.0f , 0.0f };
        String[] verlabels = new String[] { "500", "1000", "1500", "2000" };
        String[] horlabels = new String[] { "2700", "2750", "2800", "2850", "2900", "2950", "3000", "3050", "3100"};
        graph = new GraphView(this, values, "GraphViewDemo",horlabels, verlabels, GraphView.LINE);
        l = (LinearLayout) findViewById(R.id.lin);
        l.addView(graph);
       // graph = (GraphView) findViewById(R.id.graph);
        //GraphView graphView = new GraphView(this, values, "GraphViewDemo",horlabels, verlabels, GraphView.LINE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void startgraph(View v) {

        EditText patientId = (EditText) findViewById(R.id.idtext);

        if(patientId.length()!=0)
        {
            int id = Integer.parseInt(patientId.getText().toString());
            float[] values = new float[] { 1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f,1.02f,1.04f,1.2f,0.89f,0.92f,1.0f,2.0f,0.2f};
            Random rand = new Random();
            int randomval;
            int randomarr[] = new int[20];
            for(int i=0;i<8;i++)
            {
               randomarr[i] = rand.nextInt(40)+10;
            }
            for(int i=0;i<56;i++)
            {
                randomval = randomarr[i%8];
                values[i] = (values[i] + (0.01f*randomval));
            }
            l.removeAllViews();
            graph.setValues(values);
            l.addView(graph);
        }
        else if(patientId.length()==0)
        {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("ID MISSING!")
                    .setMessage("Please enter the Patient ID")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    }).create().show();

            /*EditText age = (EditText) findViewById(R.id.agetext);
        age.setText("123");*/
        }
    }

    public void stopgraph(View v){
        float[] values = new float[] { 0.0f,0.0f, 0.0f, 0.0f , 0.0f };
        l.removeAllViews();
        graph.setValues(values);
        l.addView(graph);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
