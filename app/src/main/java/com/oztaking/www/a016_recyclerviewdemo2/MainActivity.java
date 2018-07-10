package com.oztaking.www.a016_recyclerviewdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView mRv;
    private customRecyclerView mRv;
    private ImageView mIv;

    private int[] mArrayPic = new int[]{R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d
        ,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h,R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d
    };
    private String[] mArrayString = new String[]{"a","b","c","d","e","f","g","h","a","b","c","d"};
    private GalleryAdapter mGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_custom_recyclerview);

//        mRv = (RecyclerView) findViewById(R.id.id_recyclerView);
        mRv = (customRecyclerView) findViewById(R.id.id_custom_recyclerView);
        mIv = (ImageView)findViewById(R.id.id_content);
//        mRv = (RecyclerView) findViewById(R.id.id_custom_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(linearLayoutManager);
        mGalleryAdapter = new GalleryAdapter(this, mArrayPic, mArrayString);
        mRv.setAdapter(mGalleryAdapter);
        mGalleryAdapter.setListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                mIv.setImageResource(mArrayPic[position]);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        mRv.setListener(new customRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mIv.setImageResource(mArrayPic[position]);
            }
        });
    }
}
