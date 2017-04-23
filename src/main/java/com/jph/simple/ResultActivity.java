package com.jph.simple;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.jph.takephoto.model.TImage;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;


/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 * Author: crazycodeboy
 * Date: 2016/9/21 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.cboy.me
 * GitHub:https://github.com/crazycodeboy
 * Eamil:crazycodeboy@gmail.com
 */
public class ResultActivity extends Activity {
    ArrayList<TImage>images;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private static Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_layout);
        images= (ArrayList<TImage>) getIntent().getSerializableExtra("images");
       // showImg();
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button2);
        button2 = (Button) findViewById(R.id.button3);
        button3 = (Button) findViewById(R.id.button4);
        button.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        doShowImage();
    }

    private void doShowImage() {
        banner = (Banner) findViewById(R.id.banner_11);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(ResultActivity.this,Main2Activity.class);
                intent.putExtra("aa",position);
                startActivity(intent);
            }
        });

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:
                    banner.setBannerAnimation(Transformer.FlipVertical);
                    break;
                case R.id.button2:
                    banner.setBannerAnimation(Transformer.Stack);
                    break;
                case R.id.button3:
                    banner.setBannerAnimation(Transformer.RotateDown);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(700,300);
                    banner.setLayoutParams(params);
                    break;
                case R.id.button4:
                    banner.setBannerAnimation(Transformer.ScaleInOut);
                    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(500,400);
                    banner.setLayoutParams(params2);
                    break;
            }
        }
    };

   /* private void showImg() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llImages);
        for (int i = 0, j = images.size(); i < j - 1; i += 2) {
            View view = LayoutInflater.from(this).inflate(R.layout.image_show, null);
            ImageView imageView1 = (ImageView) view.findViewById(R.id.imgShow1);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imgShow2);
            Glide.with(this).load(new File(images.get(i).getOriginalPath())).into(imageView1);
            Glide.with(this).load(new File(images.get(i + 1).getOriginalPath())).into(imageView2);
            linearLayout.addView(view);
        }
        if (images.size() % 2 == 1) {
            View view = LayoutInflater.from(this).inflate(R.layout.image_show, null);
            ImageView imageView1 = (ImageView) view.findViewById(R.id.imgShow1);
            Glide.with(this).load(new File(images.get(images.size() - 1).getOriginalPath())).into(imageView1);
            linearLayout.addView(view);
        }

    }
    */
}
