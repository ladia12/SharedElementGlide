package sample.com.sharedelementglide;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArticleViewPagerAdapter mAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(v);
        mAdapter = new ArticleViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return v;
    }

    public void initViews(View v) {
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) v.findViewById(R.id.viewpagertab);
        final Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        ((HomeActivity) getActivity()).setSupportActionBar(toolbar);
    }

}
