package com.lucaspariziani.workshopmongo.services;

import com.lucaspariziani.workshopmongo.domain.Post;
import com.lucaspariziani.workshopmongo.domain.User;
import com.lucaspariziani.workshopmongo.dto.UserDTO;
import com.lucaspariziani.workshopmongo.repository.PostRepository;
import com.lucaspariziani.workshopmongo.repository.UserRepository;
import com.lucaspariziani.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")) ;
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
