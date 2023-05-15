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
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_3_2.R;
public class ThirdFragment extends Fragment {

    AppCompatButton buttonThird;
    private TextView name, surName, age, gender, fromSchool, fromWork;

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
        fromSchool = requireActivity().findViewById(R.id.editText_fromSchool);
        fromWork = requireActivity().findViewById(R.id.editText_fromWork);
        buttonThird = requireActivity().findViewById(R.id.buttonNavigate_third);
        name = requireActivity().findViewById(R.id.editText_name);
        surName = requireActivity().findViewById(R.id.editText_surName);
        age = requireActivity().findViewById(R.id.editText_age);
        gender = requireActivity().findViewById(R.id.editText_gender);
    }

    private void setClick() {
        buttonThird.setOnClickListener(v -> {
                    if (!fromSchool.getText().toString().isEmpty() && !fromWork.getText().toString().isEmpty()) {
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
        bundle.putString("fromSchool",fromSchool.getText().toString());
        bundle.putString("fromWork",fromWork.getText().toString());
        bundle.putString("age", age.getText().toString());
        bundle.putString("sex", gender.getText().toString());
        bundle.putString("name",name.getText().toString());
        bundle.putString("surName",surName.getText().toString());

        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(bundle);
    }
}
