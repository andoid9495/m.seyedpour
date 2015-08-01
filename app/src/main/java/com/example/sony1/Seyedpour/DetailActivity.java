package com.example.sony1.Seyedpour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SONY1 on 7/25/2015.
 */
public class DetailActivity extends ActionBarActivity {
    private String fishName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        fishName = intent.getStringExtra("fishName");
        int imageResource = intent.getIntExtra("imageResource", 0);
        String instructions = intent.getStringExtra("instructions");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(fishName);

        tv = (TextView) findViewById(R.id.textView5);
        tv.setText(instructions);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(imageResource);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if(item.getItemId()== R.id.action_addtocart) {
            this.addToCart(item);
        }
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
//        MenuItem item = menu.add(R.string.external_url);
//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                String webpage = "http://www.onlypet.ir";
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
//                startActivity(intent);
//                return false;
//            }
//
//        });
//
//        item = menu.add(R.string.send_massage);
//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT, "It is my first project in android!");
//                intent.setType("text/plain");
//                startActivity(intent);
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
    }

    public void addToCart(MenuItem item)
    {
        Intent intent=new Intent();
        intent.putExtra("fishName",fishName);
        intent.putExtra("action","add");
        setResult(RESULT_OK,intent);
        finish();
    }
}
