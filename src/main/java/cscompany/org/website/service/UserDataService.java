package cscompany.org.website.service;

import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.UserData;
import cscompany.org.website.model.UserEntity;
import cscompany.org.website.model.dto.LoginDTO;
import cscompany.org.website.model.dto.UserDataDTO;
import cscompany.org.website.model.mapper.EmployeeMapper;
import cscompany.org.website.model.mapper.UserDataMapper;
import cscompany.org.website.model.mapper.UserMapper;
import cscompany.org.website.repository.EmployeeRepository;
import cscompany.org.website.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service used to handle the UserData entity
 */
@Service
public class UserDataService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserDataService.class.getName());

    /**
     * Retrieves an user account from the database
     * @param username of the account
     * @return the DTO of the retrieved account
     */
    public UserDataDTO findByUsername(String username)
    {
        Optional<EmployeeEntity> employee = employeeRepository.findByUsername(username);
        if(employee.isPresent())
        {
            logger.info("Employee found with username {}", username);
            System.out.println("employeeeeeeeeeeeeeeeee" + username);
            return employee.map(x -> EmployeeMapper.getInstance().convertToDTO(x)).orElse(null);
        }
        else{
            Optional<UserEntity> user = userRepository.findByUsername(username);
            System.out.println("userrrrrrrrrrrrrrrrrrrr" + username);
            logger.info("User found with username {}", username);
            return user.map(x -> UserMapper.getInstance().convertToDTO(x)).orElse(null);
        }
    }

    /**
     * Retrieves an user data account by LoginDTO (containing username and password)
     * @param loginDTO containing username and password
     * @return the DTO of the retrieved user data
     */
    public UserDataDTO getUserDataDTO(LoginDTO loginDTO) throws Exception {
        UserDataDTO userDataDTO = this.findByUsername(loginDTO.getUsername());
        if (userDataDTO == null) {
            logger.warn("No account with the username: {} was found", loginDTO.getUsername());
            throw new Exception("No userData found");
        }
        UserData userData = UserDataMapper.getInstance().convertFromDTO(userDataDTO);

        if (loginDTO.getPassword().equals(userData.getPassword()) ){
            return userDataDTO;
        }
        throw new Exception("Incorrect Password!");
    }

    /**
     * Logs in an account
     * @param loginDTO containing username and password
     * @return the DTO of the logged in account
     */
    public UserDataDTO logIn(LoginDTO loginDTO) throws Exception {
        logger.info("Logging in {}", loginDTO.getUsername());
        return this.getUserDataDTO(loginDTO);
    }
}
