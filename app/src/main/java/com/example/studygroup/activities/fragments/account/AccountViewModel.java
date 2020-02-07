package com.example.studygroup.activities.fragments.account;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public AccountViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is account fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
