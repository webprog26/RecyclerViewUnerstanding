package com.example.webprog26.recyclerviewlayoutmanager.model;

/**
 * Created by webpr on 10.01.2017.
 */

public class Model {

    private long mId;
    private String mName;

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public static Builder newBuilder(){
        return new Model(). new Builder();
    }

    public class Builder{

        public Builder setModelId(long modelId){
            Model.this.mId = modelId;
            return this;
        }

        public Builder setModelName(String modelName){
            Model.this.mName = modelName;
            return this;
        }

        public Model build(){
            return Model.this;
        }
    }
}
