package com.example.dell.m2_week03.network;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3
{

    private OkHttpClient client;
    private static volatile  OkHttp3 instance;
    private static Request request;
    private static RequestBody builder;
    private Request grequest;
    public Handler handler=new Handler();

    private Interceptor getAppInterceptor()
    {
        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("+++++++++++","拦截前");

                Response response = chain.proceed(request);
                Log.e("++++++++","拦截后");
                return response;
            }
        };
        return interceptor;
    }

    public OkHttp3()
    {
        client = new OkHttpClient().newBuilder()
                .readTimeout(6000,TimeUnit.MILLISECONDS)
                .connectTimeout(6000,TimeUnit.MILLISECONDS)
                .addInterceptor(getAppInterceptor())
                .build();
    }

    //单例
    public  static OkHttp3 getInstance()
    {
        if (instance==null)
        {
            synchronized (OkHttp3.class)
            {
                if (instance==null)
                {
                    instance=new OkHttp3();
                }
            }
        }
        return instance;
    }

    //get
    public void OkHttpGet(String url, final Class clazz, final ListCallBack listCallBack)
    {
        grequest = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(grequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                   listCallBack.getOnFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        listCallBack.getOnSuccess(o);
                    }
                });
            }
        });
    }



    //post
    public static  void OkHttpPost(String url, String name, String pswd, final GetMessListener getMessListener){
        OkHttpClient okHttpClient = new OkHttpClient();
        builder = new FormBody.Builder()
                .add("mobile",name)
                .add("password",pswd)
                .build();
        //创建request
        request = new Request.Builder().url(url).post(builder).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                    Log.e("",""+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Log.d(TAG, "onResponse: "+response.body().string());
                getMessListener.getMess(response.body().string());
            }
        });

    }


    public interface GetMessListener{
        void getMess(String s);
    }

   public interface ListCallBack
    {
        void getOnSuccess(Object obj);
        void getOnFailure(Exception e);
    }

}
