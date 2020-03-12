package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private ImageButton add_btnPlus, add_btnMinus;
    public TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView items = (ListView) findViewById(R.id.items_list);
        final ItemsAdapter adap = new ItemsAdapter();
        addListenerOnButton();
        items.setAdapter(adap);

        Bundle arguments = getIntent().getExtras();
        final ItemClass itemClass;
        if (arguments != null) {
            itemClass = (ItemClass) arguments.getSerializable(ItemClass.class.getSimpleName());
            adap.add(itemClass);
        }
    }


    public void addListenerOnButton() {
        add_btnMinus = (ImageButton) findViewById(R.id.add_minus_btn);
        add_btnPlus = (ImageButton)findViewById(R.id.add_plus_btn);
        add_btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".AddingRashod");
                startActivity(intent);
            }
        });
        add_btnPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".AddingActivity");
                        startActivity(intent);
                    }
                }
        );
    }


    private class ItemsAdapter extends ArrayAdapter<ItemClass> {
       public ItemsAdapter() {super (MainActivity.this, R.layout.item);}

       @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           final View view = getLayoutInflater().inflate(R.layout.item, null);
           final ItemClass itemClass = getItem(position);
           ((TextView) view.findViewById(R.id.curr_id)).setText(itemClass.getCurrency());
           ((TextView) view.findViewById(R.id.categoryID)).setText(itemClass.getCategory());
           ((TextView) view.findViewById(R.id.price)).setText(String.valueOf(itemClass.getPrice()));
           ((TextView) view.findViewById(R.id.date_time_item)).setText(itemClass.getDate() + " " + itemClass.getTime());
           return view;

       }
    }
}
