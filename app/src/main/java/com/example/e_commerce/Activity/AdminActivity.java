package com.example.e_commerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.e_commerce.Fragment.AddCategoryFragment;
import com.example.e_commerce.Fragment.AddProductFragment;
import com.example.e_commerce.Fragment.ChartFragment;
import com.example.e_commerce.Fragment.FeedbackFragment;
import com.example.e_commerce.Fragment.ManageCategoryFragment;
import com.example.e_commerce.Fragment.ManageProductFragment;
import com.example.e_commerce.Fragment.ManageUserFragment;
import com.example.e_commerce.R;
import com.example.e_commerce.Fragment.ReportFragment;
import java.util.HashMap;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {
    private final Map<Integer, AdminCommand> commandMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        commandMap.put(R.id.nav_manage_product, new ManageProductCommand(this));
        commandMap.put(R.id.nav_add_product, new AddProductCommand(this));
        commandMap.put(R.id.nav_manage_category, new ManageCategoryCommand(this));
        commandMap.put(R.id.nav_add_category, new AddCategoryCommand(this));
        commandMap.put(R.id.nav_report, new ReportCommand(this));
        commandMap.put(R.id.nav_feedback, new FeedbackCommand(this));
        commandMap.put(R.id.nav_logout, new LogoutCommand(this));
        commandMap.put(R.id.nav_Mangeusers, new ManageUserCommand(this));

        getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ManageProductFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AdminCommand command = commandMap.get(item.getItemId());
        if (command != null) {
            command.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private interface AdminCommand {
        void execute();
    }

    private class ManageProductCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public ManageProductCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ManageProductFragment()).commit();
        }
    }

    private class AddProductCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public AddProductCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new AddProductFragment()).commit();
        }
    }

    private class ManageCategoryCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public ManageCategoryCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ManageCategoryFragment()).commit();
        }
    }

    private class AddCategoryCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public AddCategoryCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new AddCategoryFragment()).commit();
        }
    }

    private class ReportCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public ReportCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ReportFragment()).commit();
        }
    }

    private class FeedbackCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public FeedbackCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new FeedbackFragment()).commit();
        }
    }

    private class ChartCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public ChartCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ChartFragment()).commit();
        }
    }

    private class LogoutCommand implements AdminCommand {
        private final AppCompatActivity activity;

        public LogoutCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            Intent loginIntent = new Intent(activity, LoginActivity.class);
            activity.startActivity(loginIntent);
            activity.finish();
        }
    }

    private class ManageUserCommand implements AdminCommand {
        private final AppCompatActivity activity;
        public ManageUserCommand(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void execute() {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.admin_container, new ManageUserFragment()).commit();
        }
    }
}