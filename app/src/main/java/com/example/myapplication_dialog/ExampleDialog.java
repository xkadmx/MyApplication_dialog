package com.example.myapplication_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    private EditText editTextPassword;

    private ExampleDialogListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        //creating view for LayoutInflater

        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {// providing text from EditText
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { // taking text out of EditText and passing it into MainActivity
                        String username = editTextUsername.getText().toString();
                        String password = editTextPassword.getText().toString();
                        listener.applyTexts(username, password);
                    }
                });
        editTextUsername = view.findViewById(R.id.edit_username);
        editTextPassword = view.findViewById(R.id.edit_password);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener"); // if we open this Dialog from MainActivity, but forget to implement ExampleDialogListener into MainActivity we will receive the exception
        }
    }


    // creating an Interface
    public interface ExampleDialogListener{
        void applyTexts(String username, String password);

        // one method

        }
}
