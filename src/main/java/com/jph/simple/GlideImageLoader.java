package com.jph.simple;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jph.takephoto.model.TImage;
import com.youth.banner.loader.ImageLoader;

import java.io.File;

/**
 * Created by ZHJMaho on 2017/4/10.
 * Purpose:
 * ToDo:
 */

public class GlideImageLoader extends ImageLoader {
	@Override
	public void displayImage(Context context, Object path, ImageView imageView) {
		Log.d("ZZZ",((TImage) path).getOriginalPath());
		Glide.with(context).load(new File(((TImage) path).getOriginalPath())).centerCrop().into(imageView);
	}
}