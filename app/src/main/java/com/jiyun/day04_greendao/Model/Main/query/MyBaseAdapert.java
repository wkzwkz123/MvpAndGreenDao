package com.jiyun.day04_greendao.Model.Main.query;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiyun.day04_greendao.R;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class MyBaseAdapert extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public MyBaseAdapert(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.tv.setText(list.get(i).getName());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
