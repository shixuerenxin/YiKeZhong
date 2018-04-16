package com.qingyun.yikezhong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.bean.HotVidioBean;

import java.util.List;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class HotVidioAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<HotVidioBean.DataBean> list;
    private OnClickLister onClickLister;

    public HotVidioAdapter(Context context, List<HotVidioBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public OnClickLister getOnClickLister() {
        return onClickLister;
    }

    public void setOnClickLister(OnClickLister onClickLister) {
        this.onClickLister = onClickLister;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_adapter_hot_vidio, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.raw_1500033586)
                .error(R.drawable.error)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context).load(list.get(position).getCover()).apply(options).into(myViewHolder.adapterHotIvShow);
        myViewHolder.adapterHotTvShow.setText(list.get(position).getWorkDesc());
        myViewHolder.adapterHotReShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLister.onClick(view,list.get(position).getVideoUrl(),list.get(position).getWorkDesc());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView adapterHotIvShow;
        private final TextView adapterHotTvShow;
        private final RelativeLayout adapterHotReShow;

        public MyViewHolder(View itemView) {
            super(itemView);
            adapterHotIvShow = (ImageView)itemView.findViewById(R.id.adapter_hot_iv_show);
            adapterHotTvShow = (TextView)itemView.findViewById(R.id.adapter_hot_tv_show);
            adapterHotReShow = (RelativeLayout)itemView.findViewById(R.id.adapter_hot_rl_dian);

        }
    }
    public interface OnClickLister{
        void onClick(View view,String uri,String title);
    }

}
