package com.example.e_commerce.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e_commerce.Database.Database;
import com.example.e_commerce.Model.Product;
import com.example.e_commerce.Model.User;
import com.example.e_commerce.R;

import java.util.ArrayList;

public class ManageUserFragment extends Fragment {
    ListView list_users;
    ArrayList<User> users = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static ManageUserFragment newInstance(String param1, String param2) {
        ManageUserFragment fragment = new ManageUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ManageUserFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_user, container, false);
        list_users = v.findViewById(R.id.user_home_list_users);
        fill_list();
        return v;
    }
    public void fill_list() {
        Database dp = new Database(getContext());
        users = dp.getUsers();
        ManageUserFragment.AdminManageUserAdapter adminManageProductAdapter = new ManageUserFragment.AdminManageUserAdapter(users);
        list_users.setAdapter(adminManageProductAdapter);

    }
    class AdminManageUserAdapter extends BaseAdapter
    {
        ArrayList<User> users = new ArrayList<>();
        public AdminManageUserAdapter(ArrayList<User> users) {
            this.users = users;
        }
        @Override
        public int getCount() {
            return users.size();
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public Object getItem(int i) {
            return users.get(i).getName();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View item = layoutInflater.inflate(R.layout.admin_user_item, null);
            TextView username=(TextView)item.findViewById(R.id.admin_tv_user_name);
            TextView email=(TextView)item.findViewById(R.id.admin_tv_email);
            TextView password=(TextView)item.findViewById(R.id.admin_tv_password);
            TextView job=(TextView)item.findViewById(R.id.admin_tv_job);
            TextView gender=(TextView)item.findViewById(R.id.admin_tv_gender);
            TextView birthdate=(TextView)item.findViewById(R.id.admin_tv_bithdate);
            Button btn_del = item.findViewById(R.id.admin_user_btn_delete);
            username.setText(users.get(i).getName());
            email.setText(users.get(i).getEmail());
            job.setText(users.get(i).getJob());
            password.setText(users.get(i).getPassword());
            birthdate.setText(users.get(i).getBirthdate());
            gender.setText(users.get(i).getGender());
            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database db = new Database(getContext());
                    db.deleteUser(users.get(i).getId());
                    fill_list();
                }
            });
            return item;
        }
    }
}