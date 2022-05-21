package cscompany.org.website.service;

import cscompany.org.website.model.dto.DepartmentDTO;
import cscompany.org.website.model.mapper.DepartmentMapper;
import cscompany.org.website.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());

    public List<DepartmentDTO> findAll()
    {
        logger.info("Find all departments from the database");
        return departmentRepository.findAll().stream()
                .map(DepartmentMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList());
    }
}
