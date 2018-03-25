package com.junseo.comulnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by junse on 2018-03-26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Item> ItemList;
    private int itemLayout;

    private Context context;

    /**
     * 생성자
     *
     * @param items
     * @param itemLayout
     */
    public MyAdapter(List<Item> items, int itemLayout, Context mContext) {

        this.ItemList = items;
        this.itemLayout = itemLayout;
        context = mContext;
    }

    /**
     * 레이아웃을 만들어서 Holer에 저장
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * listView getView 를 대체
     * 넘겨 받은 데이터를 화면에 출력하는 역할
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Item item = ItemList.get(position);
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());
        viewHolder.pubDate.setText(item.getPubDate());
        //viewHolder.img.setBackgroundResource(item.getImage());
        //viewHolder.itemView.setTag(item);

        setAnimation(viewHolder.itemView, position);

        viewHolder.itemView.setOnClickListener(view -> Log.e("asd", ItemList.get(position).getLink() + "    " + position));
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    /**
     * 뷰 재활용을 위한 viewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView textTitle;
        public TextView description;
        public TextView pubDate;

        public ViewHolder(View itemView) {
            super(itemView);

            //img = (ImageView) itemView.findViewById(R.id.imgProfile);
            textTitle = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            pubDate = itemView.findViewById(R.id.pubDate);
        }
    }

    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}