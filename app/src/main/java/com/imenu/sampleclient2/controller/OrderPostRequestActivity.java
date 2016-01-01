//package com.imenu.sampleclient2.controller;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.imenu.sampleclient2.Global;
//import com.imenu.sampleclient2.R;
//import com.imenu.sampleclient2.model.Order;
//
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
///**
// * Created by __Hussein__ on 12/29/2015.
// */
//public class OrderPostRequestActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //Todo: get buttons using there IDs identified in the layout
//        Button sendingButton = (Button) findViewById(R.id.sendingButton);
//        sendingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new OrderPostRequestTask().execute();
//            }
//        });
//
//    }
//    private class OrderPostRequestTask extends AsyncTask<Void, Void, String> {
//        @Override
//        protected String doInBackground(Void... params) {
//            final String url = getString(R.string.url)+"/order/add";
//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//            Order order= Global.getOrder();
//            String response = restTemplate.postForObject(url, order, String.class);
//            return response;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
//        }
//    }
//}
