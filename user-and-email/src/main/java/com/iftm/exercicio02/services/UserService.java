package com.iftm.exercicio02.services;

import com.iftm.exercicio02.controllers.UserController;
import com.iftm.exercicio02.data.vo.UserVO;
import com.iftm.exercicio02.mapper.DozerMapper;
import com.iftm.exercicio02.models.User;
import com.iftm.exercicio02.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserVO> findAll() {
        var userDbList = repository.findAll();
        var users = DozerMapper.parseListObject(userDbList, UserVO.class);
        users.stream().forEach(user -> {
            user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                    .withSelfRel()
            );
        });
        return users;
    }

    public UserVO findById(Long id) {
        Optional<User> userDb = repository.findById(id);
        if(userDb.isPresent())
        {
            var user = DozerMapper.parseObject(userDb.get(), UserVO.class);
            user.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
            return user;
        }
        return null;
    }

    public List<UserVO> findByGroupName(String groupName) {
        List<User> users = repository.findUsersByGroupName(groupName);
        var usersVO = DozerMapper.parseListObject(users, UserVO.class);
        usersVO.stream().forEach(user -> {
            user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                    .withSelfRel()
            );
        });
        return usersVO;
    }

    public UserVO save(UserVO userVO) {
        if(verifyUser(userVO)) {
            User user = DozerMapper.parseObject(userVO, User.class);
            var userDb = repository.save(user);
            userVO = DozerMapper.parseObject(userDb, UserVO.class);
            userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        }
        return null;
    }

    public UserVO update(UserVO userVO) {
        Optional<User> dbUser = repository.findById(userVO.getId());
        if(dbUser.isPresent() && verifyUser(userVO))
        {
            User user = DozerMapper.parseObject(userVO, User.class);
            user = repository.save(user);
            userVO = DozerMapper.parseObject(user, UserVO.class);
            userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
            return userVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbUser = repository.findById(id);
        if(dbUser.isPresent()) {
            repository.deleteById(id);
            return "User with id " + id + " has been deleted!";
        }else
            return "ID " + id + " not found!";
    }

    private boolean verifyUser(UserVO userVO) {
        if( !userVO.getFirstName().isBlank() && !userVO.getFirstName().isEmpty() &&
            !userVO.getLastName().isBlank() && !userVO.getLastName().isEmpty()) {
            return true;
        }
        return false;
    }
}