package com.projects.sharath.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DashModel> dashModelArrayList;
    private RecyclerView recyclerView;
    DashAdapter dashAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv1);

        dashModelArrayList = new ArrayList<>();
        String heads[] = {"Jobs", "My Profile", "Messages", "Applied Jobs", "Resume", "Settings"};

        String subs[] = {"12 new jobs found", "75% complete", "2 new messages", "3 applies jobs", "Edit resume", "Set preferences"};

        int images[] = {R.drawable.find_jobs, R.drawable.profile, R.drawable.messages, R.drawable.applied_jobs,
        R.drawable.resume,R.drawable.settings};

        for(int count = 0 ; count < heads.length ; count++)
        {
            DashModel dashModel = new DashModel();
            dashModel.setHead(heads[count]);
            dashModel.setSub(subs[count]);
            dashModel.setImage(images[count]);
            dashModelArrayList.add(dashModel);
            //this should be retrieved in our adapter
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        dashAdapter = new DashAdapter(dashModelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashAdapter);
    }
}
