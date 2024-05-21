package unrn.proxy;

public class Main {

    public static void main(String[] args) {
        var posts = new HttpPosts("https://jsonplaceholder.typicode.com/posts");

        long start = System.currentTimeMillis();
        var postsList = posts.list();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f);

        System.out.println("Cantidad de posts: " + postsList.size());
        for (Post post : postsList) {
            System.out.println(post);
            System.out.println("---------------");
        }
    }
}
