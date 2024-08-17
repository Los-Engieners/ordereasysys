package org.ordereasy.services.implementations;
import org.ordereasy.models.User;
import org.ordereasy.repository.IUserRepository;
import org.ordereasy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) { return userRepository.findAll(pageable);
    }

    @Override
    public List<User> getAll() {return userRepository.findAll();
    }

    @Override
    public Optional<User> findOneById(Integer userid) {return userRepository.findById(userid);
    }

    @Override
    public User createOrEditOne(User user) {return userRepository.save(user);
    }

    @Override
    public void deleteOneById(Integer userid) {userRepository.deleteById(userid);
    }

}
