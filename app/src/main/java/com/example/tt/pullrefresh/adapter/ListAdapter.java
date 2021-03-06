package com.example.tt.pullrefresh.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tt.pullrefresh.R;
import com.example.tt.pullrefresh.holder.ListBigImgHolder;
import com.example.tt.pullrefresh.holder.ListNormalHolder;
import com.example.tt.pullrefresh.model.ModelBean;
import com.lovejjfg.powerrecycle.PowerAdapter;

import static com.example.tt.pullrefresh.Constants.TYPE_BIG_IMG;
import static com.example.tt.pullrefresh.Constants.TYPE_NORMAL;


/**
 * Created by Joe on 2016/10/10.
 * Email lovejjfg@gmail.com
 */

public class ListAdapter extends PowerAdapter<ModelBean> {
    private int currentType;

    public ListAdapter(int currentType) {
        this.currentType = currentType;
    }

    @Override
    public RecyclerView.ViewHolder onViewHolderCreate(ViewGroup parent, int viewType) {
        View inflate;
        switch (currentType) {
            case TYPE_NORMAL:
                inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_normal, parent, false);
                return new ListNormalHolder(inflate);
            case TYPE_BIG_IMG:
                inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_big_image, parent, false);
                return new ListBigImgHolder(inflate);
        }
        throw new IllegalArgumentException("没有对应的类型！！");

    }

    @Override
    public void onViewHolderBind(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(v, position);
                }
            }
        });
        ModelBean modelBean = list.get(position);
        switch (currentType) {
            case TYPE_NORMAL:
                ((ListNormalHolder) holder).onBind(modelBean);
                break;
            case TYPE_BIG_IMG:
                ((ListBigImgHolder) holder).onBind(modelBean);
                break;

        }

    }


    private OnItemClickListener listener;
}
