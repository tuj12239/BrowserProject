package temple.edu.browserproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements
        PageControlFragment.PageControlInterface, PageViewerFragment.PageViewerInterface{

    PageControlFragment pageControlFragment;
    PageViewerFragment pageViewerFragment;

    final String controlKey = "pageControl";
    final String viewKey = "pageView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            pageControlFragment = new PageControlFragment();
            pageViewerFragment = new PageViewerFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.page_control, pageControlFragment)
                    .add(R.id.page_viewer, pageViewerFragment)
                    .commit();
        } else {
            pageControlFragment = (PageControlFragment) getSupportFragmentManager().getFragment(savedInstanceState, controlKey);
            pageViewerFragment = (PageViewerFragment) getSupportFragmentManager().getFragment(savedInstanceState, viewKey);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        getSupportFragmentManager().putFragment(savedInstanceState, controlKey, pageControlFragment);
        getSupportFragmentManager().putFragment(savedInstanceState, viewKey, pageViewerFragment);
    }

    @Override
    public void goToCurrentURL(String url) {
        pageViewerFragment.goToCurrentURL(url);
    }

    @Override
    public void goToLastURL() {
        pageViewerFragment.goToLastURL();
    }

    @Override
    public void goToNextURL() {
        pageViewerFragment.goToNextURL();

    }

    @Override
    public void updateURLBar(String url) {
        pageControlFragment.updateUrlBar(url);
    }
}