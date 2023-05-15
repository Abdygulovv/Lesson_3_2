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
public class FirstFragment extends Fragment {

    AppCompatButton buttonFirst;
    EditText editTextName;
    EditText editTextSurName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();
        setClick();
        navigate();
    }

    private void findViews() {
        buttonFirst = requireActivity().findViewById(R.id.buttonNavigate_first);
        editTextName = requireActivity().findViewById(R.id.editText_name);
        editTextSurName = requireActivity().findViewById(R.id.editText_surName);
    }

    private void setClick() {
        if (!editTextName.getText().toString().isEmpty() && !editTextSurName.getText().toString().isEmpty()) {
        } else {
            Toast.makeText(getContext(), "заполнить поля", Toast.LENGTH_LONG).show();
        }
        buttonFirst.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, new SecondFragment())
                    .addToBackStack(null)
                    .commit();
        });

    }
    private void navigate(){
        Bundle bundle = new Bundle();
        bundle.putString("name",editTextName.getText().toString());
        bundle.putString("surName",editTextSurName.getText().toString());

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);

    }
}
