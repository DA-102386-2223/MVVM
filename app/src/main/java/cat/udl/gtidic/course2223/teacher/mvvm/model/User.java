package cat.udl.gtidic.course2223.teacher.mvvm.model;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Random;

public class User {

    private static final String TAG = User.class.getSimpleName();

//    2 different implementations:
//    name: attribute without LiveData
//    surname: attribute with LiveData
    private String name;
    private MutableLiveData<String> surname = new MutableLiveData<>();

    @Override
    public String toString(){
        return "Sóc l'usuari " + name + " " + surname.getValue();
    }

    public User(String name, String surname){
        this.name = name;
        this.surname.setValue(surname);
    }

    public void changeFullName(){
        Log.d(TAG, "changeFullName init");
        name = getRandomName();
        surname.setValue(getRandomSurname());
        Log.d(TAG, "changeName changed to: " + name + " " + surname.getValue());
    }

    private String getRandomName(){
        Random r = new Random();
        String[] historicNamesList = {"Guisla", "Tuixén", "Esclarmunda", "Cristòfol", "Brunisenda", "Aurembiaix"};
        int randomInt = r.nextInt(historicNamesList.length);
        return historicNamesList[randomInt];
    }

    private String getRandomSurname(){
        Random r = new Random();
        String[] surnamesList = {"Argente", "Bonell", "Bosch", "Brull", "Crespo", "Cunillera", "Huayta", "López", "Martínez", "Melgares", "Moll", "Navarro", "Pellitero", "Riba", "Rodriguez", "Silland", "Ulloa"};
        int randomInt = r.nextInt(surnamesList.length);
        return surnamesList[randomInt];
    }

    public LiveData<String> getSurname(){
        return this.surname;
    }

    public String getName() {
        return name;
    }
}
