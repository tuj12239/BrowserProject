package temple.edu.browserproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity {

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
}