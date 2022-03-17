package com.example.basicandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView emojiGrid;
    List<Emoji> emojiList;
    TextView emojiView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiList = new ArrayList<>();
        emojiList.add(new Emoji(convEmoji(0x1F610)));
        emojiList.add(new Emoji(convEmoji(0x1F620)));
        emojiList.add(new Emoji(convEmoji(0x1F630)));
        emojiList.add(new Emoji(convEmoji(0x1F644)));
        emojiList.add(new Emoji(convEmoji(0x1F687)));
        emojiList.add(new Emoji(convEmoji(0x1F612)));

        Random random = new Random();
        emojiView = (TextView) findViewById(R.id.emojiView);
        emojiView.setText(emojiList.get(random.nextInt(emojiList.size()-1)).getEmojiCode());

        List<Emoji> mainList = new ArrayList<>();
        for(Emoji var : emojiList){
            mainList.add(var);
        }
        EmojiAdaptor adaptor = new EmojiAdaptor(this,R.layout.emoji_textview,mainList);

        emojiGrid = (GridView) findViewById(R.id.gridview_main);
        emojiGrid.setAdapter(adaptor);


        emojiGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewHolder itemView = (ViewHolder) view.getTag();
                if(itemView.emojiCode.getText().toString() == emojiView.getText().toString()){
                    searchItem(itemView.emojiCode.getText().toString());
                    itemView.emojiCode.setText("");
                    if(emojiList.size() > 0){
                        emojiView.setText(emojiList.get(random.nextInt(emojiList.size())).getEmojiCode());
                    }
                    else emojiView.setText("You Win");
                }else Toast.makeText(MainActivity.this, "Xin vui lòng thử lại", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private String convEmoji(int emojiCode){
        return new String(Character.toChars(emojiCode));
    }
    private void searchItem(String code){
        for (int i=0; i < emojiList.size(); i++) {
            if(emojiList.get(i).getEmojiCode() == code){
                String check = Integer.toString(i);
                Toast.makeText(this, check, Toast.LENGTH_SHORT).show();
                emojiList.remove(i);
                break;
            }
        }
    }
}