package com.jaywhen.baseadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    static class ViewHolder {
        TextView mTextView;
        ImageView mImageView;
        Button mButton;
    }
    private List<Map<String, Object>> datas;
    private Context mContext;
    public MyAdapter(List<Map<String, Object>> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item, null
            );
            holder = new ViewHolder();
            holder.mImageView = (ImageView)convertView.findViewById(R.id.imageView);
            holder.mTextView = (TextView)convertView.findViewById(R.id.textView);
            holder.mButton = (Button)convertView.findViewById(R.id.button);
            holder.mButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "投币成功！", Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mImageView.setImageResource((Integer) datas.get(position).get("img"));
        holder.mTextView.setText(datas.get(position).get("title").toString());
        holder.mButton.setText(datas.get(position).get("button").toString());
        return convertView;
    }
}
