package com.example.lesson_3_2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson_3_2.R;
public class SecondFragment extends Fragment {

    private EditText name, surName, age, gender;
    AppCompatButton buttonSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();
        setClick();
        navigate();
        info();
    }

    private void findViews() {
        buttonSecond = requireActivity().findViewById(R.id.buttonNavigate_second);
        name = requireActivity().findViewById(R.id.editText_name);
        surName = requireActivity().findViewById(R.id.editText_surName);
        age = requireActivity().findViewById(R.id.editText_age);
        gender = requireActivity().findViewById(R.id.editText_gender);
    }

    private void setClick() {
        if (!name.getText().toString().isEmpty() && !surName.getText().toString().isEmpty()) {
        } else {
            Toast.makeText(getContext(), "заполнить поля", Toast.LENGTH_LONG).show();
        }
        buttonSecond.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, new ThirdFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void navigate() {
        Bundle bundle = new Bundle();
        bundle.putString("age", age.getText().toString());
        bundle.putString("gender", gender.getText().toString());
        bundle.putString("age",name.getText().toString());
        bundle.putString("gender",surName.getText().toString());

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(bundle);


    }

    private void info() {
        String resultName = getArguments().getString("name");
        name.setText(resultName);
        String resultSurName = getArguments().getString("surName");
        surName.setText(resultSurName);


    }
}
