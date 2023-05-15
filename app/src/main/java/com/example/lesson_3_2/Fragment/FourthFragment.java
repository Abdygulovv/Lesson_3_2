package com.example.lesson_3_2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson_3_2.R;

public class FourthFragment extends Fragment {

    private TextView name, surName, age, gender, fromSchool, fromWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();
        info();
    }

    private void findViews() {
        name = requireActivity().findViewById(R.id.TextView_name);
        surName = requireActivity().findViewById(R.id.TextView_useName);
        age = requireActivity().findViewById(R.id.TextView_age);
        gender = requireActivity().findViewById(R.id.TextView_gender);
        fromSchool = requireActivity().findViewById(R.id.TextView_fromSchool);
        fromWork = requireActivity().findViewById(R.id.TextView_fromWork);

    }

    private void info() {
        String resultName = getArguments().getString("name");
        name.setText(resultName);

        String resultSurName = getArguments().getString("surName");
        surName.setText(resultSurName);

        String resultAge = getArguments().getString("age");
        age.setText(resultAge);

        String resultSex = getArguments().getString("gender");
        gender.setText(resultSex);

        String resultFromSchool = getArguments().getString("fromSchool");
        fromSchool.setText(resultFromSchool);

        String resultFromWork = getArguments().getString("fromWork");
        fromWork.setText(resultFromWork);
    }
}