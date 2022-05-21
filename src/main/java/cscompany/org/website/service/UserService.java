package cscompany.org.website.service;

import cscompany.org.website.model.UserEntity;
import cscompany.org.website.model.dto.UserDTO;
import cscompany.org.website.model.mapper.UserMapper;
import cscompany.org.website.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());

    public List<UserDTO> findAll()
    {
        logger.info("Find all employees from the database");
        return userRepository.findAll().stream()
                .map(UserMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserEntity findByUsername(String username)
    {
        logger.info("Finding:{}", username);
        return userRepository.findByUsername(username).orElse(null);
    }

    //todo check register user
    public UserDTO register(UserDTO userDTO)
    {
        UserEntity userEntity = UserMapper.getInstance().convertFromDTO(userDTO);
        userRepository.save(userEntity);
        logger.info("Registered user {}",userEntity.getUsername());
        return userDTO;
    }
}
