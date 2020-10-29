package temple.edu.browserproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class PageControlFragment extends Fragment {

    EditText urlBar;
    ImageButton goButton, backButton, nextButton;

    public PageControlFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View controlView = inflater.inflate(R.layout.page_control_fragment, container, false);

        urlBar = controlView.findViewById(R.id.urlBar);
        goButton = controlView.findViewById(R.id.goButton);
        backButton = controlView.findViewById(R.id.backButton);
        nextButton = controlView.findViewById(R.id.nextButton);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlText = urlBar.getText().toString();
                if((!urlText.startsWith("http://")) && (!urlText.startsWith("https://"))) {
                    urlText = "https://".concat(urlText);
                }
                ((PageControlInterface)getActivity()).goToCurrentURL(urlText);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PageControlInterface)getActivity()).goToLastURL();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PageControlInterface)getActivity()).goToNextURL();
            }
        });

        return controlView;
    }

    interface PageControlInterface
    {
        void goToCurrentURL(String url);
        void goToLastURL();
        void goToNextURL();
    }

}
