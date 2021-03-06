package dev.beni.myapplication.adapter;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import dev.beni.myapplication.R;


public class ViewPagerAdapter extends PagerAdapter{


    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.bg, R.drawable.ic_dashboard_black_24dp, R.drawable.bg};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override

    public int getCount() {
        return images.length;
    }

    @Override

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override

    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliding_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;

        vp.addView(view, 0);
        return view;
    }

    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
