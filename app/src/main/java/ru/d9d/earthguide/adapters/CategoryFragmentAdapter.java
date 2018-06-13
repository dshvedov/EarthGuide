package ru.d9d.earthguide.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import ru.d9d.earthguide.R;
import ru.d9d.earthguide.fragments.LandmarksFragment;
import ru.d9d.earthguide.fragments.ParksFragment;
import ru.d9d.earthguide.fragments.MonumentsFragment;
import ru.d9d.earthguide.fragments.MuseumsFragment;

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
            return new LandmarksFragment();
        } else if (position == 1){
            return new MonumentsFragment();
        } else if (position == 2){
            return new MuseumsFragment();
        } else {
            return new ParksFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return mContext.getString(R.string.category_landmarks);
        else if (position == 1) {
            return mContext.getString(R.string.category_monuments);
        } else if (position == 2) {
            return mContext.getString(R.string.category_museums);
        } else {
            return mContext.getString(R.string.category_parks);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
