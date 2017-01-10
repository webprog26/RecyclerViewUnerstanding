package com.example.webprog26.recyclerviewlayoutmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.webprog26.recyclerviewlayoutmanager.adapter.ModelAdapter;
import com.example.webprog26.recyclerviewlayoutmanager.interfaces.OnModelsListClickListener;
import com.example.webprog26.recyclerviewlayoutmanager.layout_manager.AwesomeLayoutManager;
import com.example.webprog26.recyclerviewlayoutmanager.model.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnModelsListClickListener{

    //Link to article on Habr https://habrahabr.ru/company/eastbanctech/blog/267497/

    private static final String TAG = "ModelsActivity_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView modelsRecyclerView = (RecyclerView) findViewById(R.id.modelsRecyclerView);
        modelsRecyclerView.setLayoutManager(new AwesomeLayoutManager());
        modelsRecyclerView.setHasFixedSize(false);
        modelsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fillModelsList(modelsRecyclerView);
    }

    private void fillModelsList(RecyclerView recyclerView){
        List<Model> modelList = new ArrayList<>();
        modelList.add(Model.newBuilder().setModelId(1).setModelName("First").build());
        modelList.add(Model.newBuilder().setModelId(2).setModelName("Second").build());
        modelList.add(Model.newBuilder().setModelId(3).setModelName("Third").build());
        modelList.add(Model.newBuilder().setModelId(4).setModelName("Fourth").build());
        modelList.add(Model.newBuilder().setModelId(5).setModelName("Fifth").build());

        ModelAdapter adapter = new ModelAdapter(MainActivity.this, modelList, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onModelsListClick(Model model) {
        Log.i(TAG, "Clicked " + model.getName() + " with id " + model.getId());
    }
}
