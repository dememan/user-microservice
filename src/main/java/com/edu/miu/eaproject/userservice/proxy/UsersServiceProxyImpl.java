package com.edu.miu.eaproject.userservice.proxy;

import com.edu.miu.eaproject.userservice.domain.Comments;
import com.edu.miu.eaproject.userservice.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class UsersServiceProxyImpl implements  UserServiceProxy {

    @Autowired
    private RestTemplate restTemplate;
    private final String postUrl = "http://localhost:8082/posts/{id}";
    private final String postsURL = "http://localhost:8082/posts/"; //by userid=1111

    private final String commentURL = "http://localhost:8083/comments/{id}";
    private final String commentsURL = "http://localhost:8083/comments/";

    @Override
    public Post get(Long postid) {
        return restTemplate.getForObject(postUrl, Post.class, postid);
    }

    @Override
    public List<Post> getPosts(Long id) {
        ResponseEntity<List<Post>> response =
                restTemplate.exchange(postsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>() {});
        return response.getBody();
    }


    @Override
    public List<Comments> getCommentsByUserId(Long id) {
        return null;
    }

}
