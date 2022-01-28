package com.edu.miu.eaproject.userservice.proxy;

import com.edu.miu.eaproject.userservice.domain.Comments;
import com.edu.miu.eaproject.userservice.domain.Post;

import java.util.List;

public interface UserServiceProxy {
    List<Comments> getCommentsByUserId(Long userId);

    Post get(Long postid);

    List<Post> getPosts(Long userId);
}
