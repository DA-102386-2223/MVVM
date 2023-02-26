package cat.udl.gtidic.course2223.teacher.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cat.udl.gtidic.course2223.teacher.mvvm.databinding.ActivityMainBinding;
import cat.udl.gtidic.course2223.teacher.mvvm.model.User;
import cat.udl.gtidic.course2223.teacher.mvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    UserViewModel myVM;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVM = new ViewModelProvider(this).get(UserViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setElMeuVM(myVM);

        myVM.getUsers().observe(this, users -> {
//            do something when data is changed
            updateUsersInfo(users);
        });
        mainLayout = findViewById(R.id.mainLayout);
    }

    private void updateUsersInfo(List<User> users){
        for (User user : users) {
            TextView t = new TextView(this);
            t.setText(user.getName());
            mainLayout.addView(t);
        }
    }
}