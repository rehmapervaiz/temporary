package com.example.pharmacy;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment1 extends Fragment {


    public HomeFragment1() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage=2;

    private Timer timer;

    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment1, container, false);

        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        List<CategoryModel>categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Home1"));
        categoryModelList.add(new CategoryModel("link","Home2"));
        categoryModelList.add(new CategoryModel("link","Home3"));
        categoryModelList.add(new CategoryModel("link","Home4"));
        categoryModelList.add(new CategoryModel("link","Home5"));
        categoryModelList.add(new CategoryModel("link","Home6"));
        categoryModelList.add(new CategoryModel("link","Home7"));

        categoryAdapter= new CategoryAdapter(categoryModelList,getContext());
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();



        bannerSliderViewPager=view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));

        sliderModelList.add(new SliderModel(R.drawable.banner));
        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_camera));
        sliderModelList.add(new SliderModel(R.drawable.logo));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));

        sliderModelList.add(new SliderModel(R.drawable.banner));
        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp));

        SliderAdapter sliderAdapter=new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage =position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };

        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                pageLooper();
                stopBannerSlideShow();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });


        return view;
    }

    private void pageLooper(){
        if(currentPage==sliderModelList.size() -2){
            currentPage=2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage==1){
            currentPage=sliderModelList.size() -3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler=new Handler();
        final Runnable update= new Runnable() {
            @Override
            public void run() {
                if(currentPage>=sliderModelList.size()){
                    currentPage=1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME );
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }

}
