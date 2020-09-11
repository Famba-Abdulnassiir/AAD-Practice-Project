package com.example.myapp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp2.datasubmit.ApiClient;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView email,firstname,lastname,projectlink;
    Button  yesbtn;
    ImageView cancelbtn, backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        firstname = findViewById(R.id.firstname);
        lastname =  findViewById(R.id.lastname);
        projectlink =  findViewById(R.id.projectlink);
        cancelbtn = findViewById(R.id.cancelbtn);
        yesbtn = findViewById(R.id.yesbtn);
        backbtn = findViewById(R.id.backarrow);



    }

    public void onback(View view){

    }

    public void onTest(View view){
//        Intent intent = new Intent(this,FetchedDataActivity.class);
//        startActivity(intent);
    }
    public void onSubmit(View view) {
        if (Objects.requireNonNull(email.getText()).toString().isEmpty()) {
            Toast.makeText(this,"please enter Email",Toast.LENGTH_SHORT).show();
        }
        else if (Objects.requireNonNull(firstname.getText()).toString().isEmpty()) {
            Toast.makeText(this,"please enter First Name",Toast.LENGTH_SHORT).show();
        }
        else if (Objects.requireNonNull(lastname.getText()).toString().isEmpty()) {
            Toast.makeText(this,"please enter Last Name",Toast.LENGTH_SHORT).show();
        }
        else if (Objects.requireNonNull(projectlink.getText()).toString().isEmpty()) {
            Toast.makeText(this,"please enter Valid Project Link",Toast.LENGTH_SHORT).show();
        } else {
            maindialog();
        }
        

    }

    private void maindialog() {
        final AlertDialog.Builder maindialog = new AlertDialog.Builder(this);
//        LayoutInflater main = LayoutInflater.from(this);
////       View view = main.inflate(R.layout.miandialog,null);
////        maindialog.setView(view);
       maindialog.setTitle("R.string.alert_title");
        maindialog.setMessage("R.string.alert_message");


        maindialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                submitData();
            }
        });
        maindialog.show();


    }

    private  void  successAlert(){
        final AlertDialog.Builder successdialog = new AlertDialog.Builder(this);
        LayoutInflater main = LayoutInflater.from(this);
        View view = main.inflate(R.layout.successalert,null);
        successdialog.setView(view);
        successdialog.show();

    }

    private void warningAlert(){
        final AlertDialog.Builder warningdialog = new AlertDialog.Builder(this);
        LayoutInflater main = LayoutInflater.from(this);
        View view = main.inflate(R.layout.warningalert,null);
        warningdialog.setView(view);
        warningdialog.show();

    }

    private void submitData(){
        ApiInterface apiInterface;
        apiInterface = ApiClient.getForm().create(ApiInterface.class);

        Call<ResponseBody> call = apiInterface.SubmitProject(Objects.requireNonNull(email.getText()).toString(),
                Objects.requireNonNull(firstname.getText()).toString(),Objects.requireNonNull(lastname.getText()).toString(),
                Objects.requireNonNull(projectlink.getText()).toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call1, Response<ResponseBody> response) {
                if (response.code()== 200){
                    successAlert();
                } else if(response.code()!= 400){
                    warningAlert();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call1, Throwable t) {
                Log.d("Error", "onResponse: "+ t);
            }
        });

    }
}
