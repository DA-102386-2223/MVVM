package cat.udl.gtidic.course2223.teacher.mvvm.viewmodel;

import static java.util.List.of;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import cat.udl.gtidic.course2223.teacher.mvvm.model.User;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers(){
        if (users == null){
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers(){
//        stupid 5 seconds sleep to simulate a delay getting data
        new Handler().postDelayed(() -> loadUsersDelayed(), 5000);
    }

    private void loadUsersDelayed(){
//        TODO it should be moved to a provider class
        List<User> list = new ArrayList<User>();
        String[] namesList = {"Júlia", "Martina", "Mia", "Emma", "Ona", "Marc", "Nil", "Pol", "Pau", "Biel"};
        for (String name : namesList) list.add(new User(name));
        users.setValue(list);
    }
}
