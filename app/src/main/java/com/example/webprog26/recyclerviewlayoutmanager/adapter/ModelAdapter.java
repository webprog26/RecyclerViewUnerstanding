package com.example.webprog26.recyclerviewlayoutmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.webprog26.recyclerviewlayoutmanager.R;
import com.example.webprog26.recyclerviewlayoutmanager.interfaces.OnModelsListClickListener;
import com.example.webprog26.recyclerviewlayoutmanager.model.Model;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by webpr on 10.01.2017.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private WeakReference<Context> mContextWeakReference;
    private List<Model> mListModels;
    private OnModelsListClickListener mOnModelsListClickListener;

    public ModelAdapter(Context context, List<Model> mListModels, OnModelsListClickListener mOnModelsListClickListener) {
        this.mContextWeakReference = new WeakReference<Context>(context);
        this.mListModels = mListModels;
        this.mOnModelsListClickListener = mOnModelsListClickListener;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContextWeakReference.get()).inflate(R.layout.model_item, parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {
        holder.bind(mListModels.get(position), mOnModelsListClickListener);
    }

    @Override
    public int getItemCount() {
        return mListModels.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvModelName;

        public ModelViewHolder(View itemView) {
            super(itemView);

            mTvModelName = (TextView) itemView.findViewById(R.id.tvModelName);
        }

        public void bind(final Model model, final OnModelsListClickListener onModelsListClickListener){

            mTvModelName.setText(model.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onModelsListClickListener.onModelsListClick(model);
                }
            });
        }
    }
}
