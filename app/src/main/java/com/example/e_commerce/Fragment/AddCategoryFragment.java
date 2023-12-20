package com.example.e_commerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.e_commerce.Database.Database;
import com.example.e_commerce.Model.Category;
import com.example.e_commerce.R;
public class AddCategoryFragment extends Fragment {

    EditText txt_name, txt_image;
    Button btn_show, btn_add;
    ImageView iv_image;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AddCategoryFragment() {
    }

    public static AddCategoryFragment newInstance(String param1, String param2) {
        AddCategoryFragment fragment = new AddCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_category, container, false);

        Database db = new Database(getContext());

        txt_name = v.findViewById(R.id.add_category_txt_name);
        txt_image = v.findViewById(R.id.add_category_txt_image);

        iv_image = v.findViewById(R.id.add_category_iv_image);

        btn_show = v.findViewById(R.id.add_category_btn_show_image);
        btn_add = v.findViewById(R.id.add_category_btn_add);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txt_image.getText().toString().isEmpty()){
                    String url = txt_image.getText().toString();
                    Glide.with(getContext()).load(url).into(iv_image);
                }
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txt_name.getText().toString(),
                        image = txt_image.getText().toString();

                if(!name.isEmpty() && !image.isEmpty()){
                    Category category = new Category();
                    category.setName(name);
                    category.setImage(image);
                    db.add_category(category);

                    txt_name.setText("");
                    txt_image.setText("");
                    iv_image.setImageResource(R.drawable.image_placeholder);
                }else{
                    Toast.makeText(getContext(), "Fill all data first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}
