package unrn.proxy;

public class Post {

    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post [title=" + title + ", body=" + body + "]";
    }
}
