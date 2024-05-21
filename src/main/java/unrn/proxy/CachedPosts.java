package unrn.proxy;

import java.time.LocalDateTime;
import java.util.List;

public class CachedPosts implements Posts {

    private HttpPosts postsReales;
    private List<Post> postsCached;
    private LocalDateTime cachedTime;

    public CachedPosts(HttpPosts postsReales) {
        this.postsReales = postsReales;
        this.cachedTime = LocalDateTime.now();
    }

    @Override
    public List<Post> list() {
        if (postsCached != null && LocalDateTime.now().isBefore(this.cachedTime.plusMinutes(30))) {
            return postsCached;
        }
        postsCached = this.postsReales.list();

        return postsCached;
    }

}
