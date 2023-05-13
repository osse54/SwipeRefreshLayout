package com.example.swiperefreshlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.swiperefreshlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    private int refreshedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        refresh(); // 최초 실행 시 새로고침 tv에 "새로고침 횟수\n0" 이 표시될 것임.
        binding.srl.setOnRefreshListener(() -> { // 새로고침 이벤트 발생 시 실행되는 콜백 메서드 refresh() 메서드 호출
            Log.i(TAG, "onCreate: swipe refresh layout에서 refresh 이벤트 발생");
            refresh();
        });
    }

    public void refresh() { // 새로고침 발생 시 실행할 메소드, tv에 "새로고침 횟수\n{refreshedCount}" 가 표시될 것임.
        Log.i(TAG, "refresh: 새로고침 횟수: " + refreshedCount);
        // 첫 실행 시 refreshedCount == 1로 바뀌지만, 표시될 때는 0으로 표시됨.
        binding.tv.setText(getString(R.string.refresh_count_text) + refreshedCount++);
        Log.i(TAG, "refresh: 새로고침 횟수: " + refreshedCount);
        binding.srl.setRefreshing(false); // 새로고침 시 필요한 작업이 완료되었을 때 새로고침의 시각적 표시를 종료하는 메서드.
//        binding.srl.setRefreshing(true); // 새로고침의 시각적 표시가 지속적으로 표시되기를 원할 때 true로 설정
    }
}