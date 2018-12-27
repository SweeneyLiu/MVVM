package com.lsw.mvvm.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lsw.mvvm.R;
import com.lsw.mvvm.databinding.ActivityQueryWeatherBinding;
import com.lsw.mvvm.viewmodel.QueryWeatherViewModel;

public class QueryWeatherActivity extends AppCompatActivity {

    // ViewModel
    private QueryWeatherViewModel mViewModel;

    // DataBinding
    private ActivityQueryWeatherBinding mDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_query_weather);
        // 创建ViewModel
        mViewModel = new QueryWeatherViewModel();
        // 绑定View和ViewModel
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
