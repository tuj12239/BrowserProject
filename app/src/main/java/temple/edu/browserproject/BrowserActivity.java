package temple.edu.browserproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements
        PageControlFragment.PageControlInterface, PageViewerFragment.PageViewerInterface{

    PageControlFragment pageControlFragment;
    PageViewerFragment pageViewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageControlFragment = new PageControlFragment();
        pageViewerFragment = new PageViewerFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.page_control, pageControlFragment)
                .add(R.id.page_viewer, pageViewerFragment)
                .commit();
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