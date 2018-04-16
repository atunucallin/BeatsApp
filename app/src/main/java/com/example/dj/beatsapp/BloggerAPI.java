package com.example.dj.beatsapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DJ on 22/03/2018.
 */

public class BloggerAPI {
    private static  final String key = "AIzaSyAdigQ0KdNBWkD8szbBQtjN_5pbFSOrmvc";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/9186083033571146996/posts/";

    public static PostService postService = null;

    public static PostService getPostService(){
        if (postService == null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            postService = retrofit.create(PostService.class);



        }
        return postService;
    }


    public interface PostService{

        @GET("?key="+key)
        Call<PostList> getPostList();
        /*@GET("{postId}/?key+"+key)
        Call<Item> getPostById(@Path("postId") String id);*/
    }
}
