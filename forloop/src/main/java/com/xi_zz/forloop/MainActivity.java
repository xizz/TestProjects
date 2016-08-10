package com.xi_zz.forloop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private TextView textView;

	private List<Integer> list;
	private Integer[] arr;
	private StringBuilder strBuilder = new StringBuilder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.display_text);

		Random random = new Random();

		list = new ArrayList<>();
		for (int i = 0; i < 999999; i++) {
			list.add(random.nextInt());
		}
		arr = list.toArray(new Integer[list.size()]);
	}

	@Override
	protected void onResume() {
		super.onResume();

		long startTime;
		int sum;

		startTime = System.currentTimeMillis();
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		Log.d(getClass().getSimpleName(), String.valueOf(sum));
		strBuilder.append("Array for loop: " + Long.toString(System.currentTimeMillis() - startTime));
		strBuilder.append("\n");

		startTime = System.currentTimeMillis();
		sum = 0;
		for (int i : arr) {
			sum += i;
		}
		Log.d(getClass().getSimpleName(), String.valueOf(sum));
		strBuilder.append("Array for each: " + Long.toString(System.currentTimeMillis() - startTime));
		strBuilder.append("\n");

		startTime = System.currentTimeMillis();
		sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		Log.d(getClass().getSimpleName(), String.valueOf(sum));
		strBuilder.append("List for loop: " + Long.toString(System.currentTimeMillis() - startTime));
		strBuilder.append("\n");

		startTime = System.currentTimeMillis();
		sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		Log.d(getClass().getSimpleName(), String.valueOf(sum));
		strBuilder.append("List for each: " + Long.toString(System.currentTimeMillis() - startTime));
		strBuilder.append("\n\n");

		textView.setText(strBuilder);
	}
}
