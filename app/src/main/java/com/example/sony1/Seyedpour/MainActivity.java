package com.example.sony1.Seyedpour;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ListActivity {

    public static final int REQUEST_CODE = 100;
    List<Fish> fishes = new FishData().getFishes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        FishAdapter adapter=new FishAdapter(this,R.id.item_fish,fishes);
        setListAdapter(adapter);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ArrayAdapter<Fish> adapter=new ArrayAdapter<Fish>(this,android.R.layout.simple_list_item_1,fishes);
//       setListAdapter(adapter);
//        LinearLayout mylayout = (LinearLayout) findViewById(R.id.firstlayout);
//        for (final Fish fish : fishes) {
//            Button button = new Button(this);
//            button.setText(fish.fishName);
//            mylayout.addView(button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                    intent.putExtra("fishName", fish.fishName);
//                    intent.putExtra("imageResource", fish.imageResource);
//                    intent.putExtra("instructions", fish.instructions);
//                    startActivityForResult(intent, REQUEST_CODE);
//                }
//
//            });
//        }
//        Button button1=(Button)findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener(){
//                                       @Override
//                                       public void onClick(View v) {
//                                           Intent intent=new Intent(MainActivity.this,DetailActivity.class);
//                                           startActivity(intent);
//                                       }
//                                   }
//        );
//
//        Button button2=(Button)findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener(){
//                                       @Override
//                                       public void onClick(View v) {
//                                           String webpage="http://www.onlypet.ir";
//                                           Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
//                                           startActivity(intent);
//                                       }
//                                   }
//        );
//
//        Button button3=(Button)findViewById(R.id.button3);
//        button3.setOnClickListener(new View.OnClickListener(){
//                                       @Override
//                                       public void onClick(View v) {
//                                           Intent intent=new Intent();
//                                           intent.setAction(Intent.ACTION_SEND);
//                                           intent.putExtra(Intent.EXTRA_TEXT,"It is my first project in android!");
//                                           intent.setType("text/plain");
//                                           startActivity(intent);
//                                       }
//                                   }
//        );
        //Toast.makeText(this, "Activity created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK)
        {
            String fishName=data.getStringExtra("fishName");
            String action=data.getStringExtra("action");
            if(action.equals("add"))
            {
                Toast.makeText(this,"adding 1 "+ fishName+" to cart",Toast.LENGTH_SHORT).show();
            }
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//           getMenuInflater().inflate(R.menu.menu_main, menu);
//           return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_activity_two:
                intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
                break;
            case R.id.action_external_url:
                String webpage = "http://www.onlypet.ir";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(intent);
                break;
            case R.id.action_send_message:
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "It is my first project in android!");
                intent.setType("text/plain");
                startActivity(intent);
                break;
            default:
                break;
        }
//        int id = item.getItemId();
////        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Toast.makeText(this, "you selected " + item.toString(), Toast.LENGTH_SHORT).show();
//            return true;
//       }
        Toast.makeText(this, "you selected " + item.toString(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "portrate!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fish fish=fishes.get(position);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("fishName", fish.fishName);
        intent.putExtra("imageResource", fish.imageResource);
        intent.putExtra("instructions", fish.instructions);
        startActivityForResult(intent, REQUEST_CODE);
    }

    //    public void gotoActivity(View v)
//    {
//        Intent intent=new Intent(this,DetailActivity.class);
//        startActivity(intent);
//    }
//
//    public void implicitViewURL(View v)
//    {
//        String webpage="http://www.onlypet.ir";
//        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
//        startActivity(intent);
//    }
//
//    public void implicitSendText(View v){
//        Intent intent=new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT,"It is my first project in android!");
//        intent.setType("text/plain");
//        startActivity(intent);
//    o

}
