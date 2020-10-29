package temple.edu.browserproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

public class PageViewerFragment extends Fragment {

    WebView webViewWidget;

    public PageViewerFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pageView = inflater.inflate(R.layout.page_viewer_fragment, container, false);

        webViewWidget = pageView.findViewById(R.id.webViewWidget);

        return pageView;
    }
}
