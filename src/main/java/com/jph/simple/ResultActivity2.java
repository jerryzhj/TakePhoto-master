package com.jph.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jph.takephoto.model.TImage;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity2 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result2);
		List<TImage> images= (ArrayList<TImage>) getIntent().getSerializableExtra("images");
		Log.d("AAASDADa","DSADASDAS");
	}
}
