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

        return controlView;
    }

}
