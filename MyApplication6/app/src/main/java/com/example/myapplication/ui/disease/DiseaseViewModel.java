package com.example.myapplication.ui.disease;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiseaseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DiseaseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is disease fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}