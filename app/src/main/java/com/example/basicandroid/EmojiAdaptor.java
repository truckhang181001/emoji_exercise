package com.example.basicandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EmojiAdaptor extends BaseAdapter {
   private Context context;
   private int layout;
   private List<Emoji> emojiList;

    public EmojiAdaptor(Context context, int layout, List<Emoji> emojiList) {
        this.context = context;
        this.layout = layout;
        this.emojiList = emojiList;
    }

    @Override
    public int getCount() {
        return emojiList.size();
    }

    @Override
    public Object getItem(int i) {

        return emojiList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.emojiCode = (TextView) view.findViewById(R.id.item_emoji);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.emojiCode.setText(emojiList.get(i).getEmojiCode());
        return view;
    }
}
