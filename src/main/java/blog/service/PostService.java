package blog.service;

import blog.domain.model.Post;
import blog.domain.model.dto.UpdatePostDto;
import blog.domain.repository.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostService {

    private final PostMapper postMapper;

    public Post save(Post post, String writer) {
        post.setWriter(writer);
        if (postMapper.save(post) == 1) {
            return post;
        } else {
           throw new IllegalArgumentException();
        }
    }

    public void update(long id, UpdatePostDto updateParam) {
        Post post = postMapper.findById(id);
        post.setTitle(updateParam.getTitle());
        post.setContext(updateParam.getContext());
        post.setPostTime(LocalDateTime.now());
        if (postMapper.update(id, post) != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteById(long id) {
        postMapper.deleteById(id);
    }

    public void clear() {
        postMapper.clear();
    }

    public Post findById(long id) {
        return postMapper.findById(id);
    }

    public List<Post> findAll() {
        return postMapper.findAll();
    }

    public List<Post> findPostsByPage(int page, int size) {
        int start = (page - 1) * size;
        return postMapper.findAllByPagination(start, size);
    }

    public int countAllPosts() {
        return postMapper.countAll();
    }
}
