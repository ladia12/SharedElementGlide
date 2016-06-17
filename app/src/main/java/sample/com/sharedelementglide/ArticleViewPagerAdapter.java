package sample.com.sharedelementglide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ladia on 17/06/16.
 */
public class ArticleViewPagerAdapter extends FragmentStatePagerAdapter {

    public ArticleViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ShowArticlesFragment.getInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return "Tab "+ (position + 1);
    }
}
