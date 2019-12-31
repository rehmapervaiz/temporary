package com.example.pharmacy;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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
    ////////////////Banner part
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage=2;
    private Timer timer;
    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;

    /////////Banner Part


    //Strip Part

         private ImageView stripAdImage;
         private ConstraintLayout stripAdContainer;
    //Strip Part

    //Horizontal Product Layout

        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllButton;
        private RecyclerView horizontalRecyclerView;
    //Horizontal Product Layout

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


////////////////////banner slider
        bannerSliderViewPager=view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_camera,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.logo,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp,"#077EA4"));

        SliderAdapter sliderAdapter=new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

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

//Banner Slider


        //Strip Part

        stripAdImage=view.findViewById(R.id.strip_ad_image);
        stripAdContainer=view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.banner);
         stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));

        //Strip Part



        //Horizontal Layout

        horizontalLayoutTitle=view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllButton=view.findViewById(R.id.horizontal_scroll_view_all_button);
        horizontalRecyclerView=view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg Film-Coated Tablets" ,"Rs. 120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.banner,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_home_blue_24dp,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));





        HorizontalProductScrollAdapter horizontalProductScrollAdapter=new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();
        //Horizontal Layout


        /////////////Grid View

            TextView gridLayoutTitle=view.findViewById(R.id.grid_product_layout_title);
            Button gridLayoutViewAllButton=view.findViewById(R.id.grid_product_layout_view_all_button);
            GridView gridView=view.findViewById(R.id.grid_product_layout_gridview);

            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));



        /////////////Grid View


        ////////////Testing

        RecyclerView testing =view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel>homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000ff00"));





        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        ////////////Testing
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
