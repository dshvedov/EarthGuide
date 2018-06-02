package ru.d9d.earthguide.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import ru.d9d.earthguide.R;
import ru.d9d.earthguide.fragments.AttractionFragment;
import ru.d9d.earthguide.fragments.ConnectionFragment;
import ru.d9d.earthguide.fragments.FoodFragment;
import ru.d9d.earthguide.fragments.ShelterFragment;

public class CategoryFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;
    final int PAGE_COUNT = 4;


    public CategoryFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1){
            return new FoodFragment();
        } else if (position == 2){
            return new ShelterFragment();
        } else {
            return new ConnectionFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return mContext.getString(R.string.category_attraction);
        else if (position == 1) {
            return mContext.getString(R.string.category_food);
        } else if (position == 2) {
            return mContext.getString(R.string.category_shelter);
        } else {
            return mContext.getString(R.string.category_connection);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
