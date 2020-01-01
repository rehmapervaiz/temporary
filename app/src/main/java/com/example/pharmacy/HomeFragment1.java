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

    private RecyclerView testing;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment1, container, false);

        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        final List<CategoryModel>categoryModelList=new ArrayList<CategoryModel>();
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
         List<SliderModel>sliderModelList=new ArrayList<SliderModel>();

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



///////////////////Banner Slider


        //Strip Part

        //Strip Part



        //Horizontal Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg Film-Coated Tablets" ,"Rs. 120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.banner,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_home_blue_24dp,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));


        //Horizontal Layout


        /////////////Grid View

        /////////////Grid View


        ////////////Testing

         testing =view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel>homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));

        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000ff00"));





        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        ////////////Testing
        return view;
    }


}
