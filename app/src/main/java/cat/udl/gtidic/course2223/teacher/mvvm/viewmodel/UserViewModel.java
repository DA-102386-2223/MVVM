package cat.udl.gtidic.course2223.teacher.mvvm.viewmodel;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import cat.udl.gtidic.course2223.teacher.mvvm.model.User;

public class UserViewModel extends ViewModel {
    private static final String TAG = UserViewModel.class.getSimpleName();
    private MutableLiveData<List<User>> users;
    private MutableLiveData<User> currentUser = new MutableLiveData<>();

    public UserViewModel(){
        currentUser.setValue(new User("Albert", "Rovira"));
    }

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
        Log.d(TAG, "loadUsersDelayed init");
        List<User> list = new ArrayList<User>();
        String[] namesList = {"Júlia", "Martina", "Mia", "Emma", "Ona", "Marc", "Nil", "Pol", "Pau", "Biel"};
        for (String name : namesList) list.add(new User(name, "Jornet"));
        users.setValue(list);
        Log.d(TAG, "loadUsersDelayed ended");
    }

    public MutableLiveData<User> getCurrentUser(){
        return currentUser;
    }

    public void changeFullName(){
        Log.d(TAG, "changeFullName init");
        currentUser.getValue().changeFullName();

//        needed tu update currentUser because name is not LiveData
        currentUser.setValue(currentUser.getValue());

        Log.d(TAG, "changeFullName endend");
    }

}
