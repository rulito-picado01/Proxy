package unrn.proxy;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpPosts implements Posts {

    public static final String TITLE = "title";
    public static final String BODY = "body";
    private String url;

    public HttpPosts(String url) {
        this.url = url;
    }

    public List<Post> list() {
        var postList = new ArrayList<Post>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(this.url).build();
        try (Response response = client.newCall(request).execute()) {
            JSONArray posts = new JSONArray(response.body().string());
            for (int i = 0; i < posts.length(); i++) {
                postList.add(new Post(posts.getJSONObject(i).get(TITLE).toString(),
                        posts.getJSONObject(i).get(BODY).toString()));
            }
            return postList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
