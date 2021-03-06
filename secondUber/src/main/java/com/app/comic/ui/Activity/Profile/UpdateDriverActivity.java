package com.app.comic.ui.Activity.Profile;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.app.comic.MainFragmentActivity;
import com.app.comic.R;
import com.app.comic.ui.Activity.FragmentContainerActivity;

import butterknife.ButterKnife;

//import android.view.WindowManager;

public class UpdateDriverActivity extends MainFragmentActivity implements FragmentContainerActivity {

    //@InjectView(R.id.btnLogin) Button btnLogin;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, UpdateDriverFragment.newInstance(bundle)).commit();

        setTitle("Driver Profile");
        setBackButton();
        // [END shared_tracker]

    }

    /*@Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }*/

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public int getFragmentContainerId() {
        return R.id.main_activity_fragment_container;
    }
}
