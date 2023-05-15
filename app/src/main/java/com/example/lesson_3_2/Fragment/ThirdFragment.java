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
public class ThirdFragment extends Fragment {

    AppCompatButton buttonThird;
    EditText editTextStudies;
    EditText editTextWord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();
        setClick();
        navigate();
    }

    private void findViews() {
        buttonThird = requireActivity().findViewById(R.id.buttonNavigate_third);
        editTextStudies = requireActivity().findViewById(R.id.editText_fromSchool);
        editTextWord = requireActivity().findViewById(R.id.editText_fromWork);
    }

    private void setClick() {
        buttonThird.setOnClickListener(v -> {
                    if (!editTextStudies.getText().toString().isEmpty() && !editTextWord.getText().toString().isEmpty()) {
                    } else {
                        Toast.makeText(getContext(), "заполнить поля", Toast.LENGTH_LONG).show();
                    }
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, new FourthFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void navigate() {
        Bundle bundle = new Bundle();
        bundle.putString("fromSchool",editTextStudies.getText().toString());
        bundle.putString("fromWork",editTextWord.getText().toString());

        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(bundle);
    }
}
