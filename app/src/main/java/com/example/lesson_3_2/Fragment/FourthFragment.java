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
    TextView textViewName;
    TextView textViewSurName;
    TextView textViewAge;
    TextView textViewGender;
    TextView textViewFromSchool;
    TextView textViewFromWork;

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
        textViewName = requireActivity().findViewById(R.id.TextView_name);
        textViewSurName = requireActivity().findViewById(R.id.TextView_useName);
        textViewAge = requireActivity().findViewById(R.id.TextView_age);
        textViewGender = requireActivity().findViewById(R.id.TextView_gender);
        textViewFromSchool = requireActivity().findViewById(R.id.TextView_fromSchool);
        textViewFromWork = requireActivity().findViewById(R.id.TextView_fromWork);

    }

    private void info() {
        name = requireActivity().findViewById(R.id.TextView_name);
        surName = requireActivity().findViewById(R.id.TextView_useName);
        age = requireActivity().findViewById(R.id.TextView_age);
        gender = requireActivity().findViewById(R.id.TextView_gender);
        fromSchool = requireActivity().findViewById(R.id.TextView_fromSchool);
        fromWork = requireActivity().findViewById(R.id.TextView_fromWork);

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