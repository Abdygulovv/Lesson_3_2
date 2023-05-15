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

    AppCompatButton buttonSecond;
    EditText editTextAge;
    EditText editTextGender;

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
    }

    private void findViews() {
        buttonSecond = requireActivity().findViewById(R.id.buttonNavigate_second);
        editTextAge = requireActivity().findViewById(R.id.editText_age);
        editTextGender = requireActivity().findViewById(R.id.editText_gender);
    }

    private void setClick() {
        if (!editTextAge.getText().toString().isEmpty() && !editTextGender.getText().toString().isEmpty()) {
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
        bundle.putString("age",editTextAge.getText().toString());
        bundle.putString("gender",editTextGender.getText().toString());

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(bundle);
    }
}
