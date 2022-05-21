package cscompany.org.website.service;

import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.dto.EmployeeDTO;
import cscompany.org.website.model.mapper.EmployeeMapper;
import cscompany.org.website.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());


    public List<EmployeeDTO> findAll()
    {
        logger.info("Find all employees from the database");
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeEntity findByUsername(String username)
    {
        logger.info("Finding:{}", username);
        return employeeRepository.findByUsername(username).orElse(null);
    }
}
