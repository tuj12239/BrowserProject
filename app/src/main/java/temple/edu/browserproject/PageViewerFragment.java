package temple.edu.browserproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class PageViewerFragment extends Fragment {

    WebView webViewWidget;
    final String urlKey = "url";

    public PageViewerFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pageView = inflater.inflate(R.layout.page_viewer_fragment, container, false);

        webViewWidget = pageView.findViewById(R.id.webViewWidget);
        webViewWidget.getSettings().setJavaScriptEnabled(true);


        return pageView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webViewWidget.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                ((PageViewerInterface)getActivity()).updateURLBar(webViewWidget.getUrl());
            }
        });

        if (savedInstanceState != null) {
            webViewWidget.restoreState(savedInstanceState);
            webViewWidget.loadUrl(savedInstanceState.getString(urlKey));
        }

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(urlKey, webViewWidget.getUrl());
        webViewWidget.saveState(savedInstanceState);
    }

    public void goToCurrentURL(String url) {
        webViewWidget.loadUrl(url);
    }

    public void goToLastURL() {
        webViewWidget.goBack();
    }

    public void goToNextURL() {
        webViewWidget.goForward();
    }

    interface PageViewerInterface {
        void updateURLBar(String url);
    }
}
