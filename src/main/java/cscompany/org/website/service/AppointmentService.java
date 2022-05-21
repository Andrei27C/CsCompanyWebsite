package cscompany.org.website.service;

import cscompany.org.website.model.AppointmentEntity;
import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.UserEntity;
import cscompany.org.website.model.dto.AppointmentDTO;
import cscompany.org.website.model.dto.EmployeeDTO;
import cscompany.org.website.model.mapper.AppointmentMapper;
import cscompany.org.website.model.mapper.EmployeeMapper;
import cscompany.org.website.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class AppointmentService {
    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    public List<AppointmentDTO> findByEmployeeId(EmployeeDTO employeeDTO)
    {
        EmployeeEntity employeeEntity = EmployeeMapper.getInstance().convertFromDTO(employeeDTO);
        Optional<List<AppointmentEntity>> appointmentEntityList = Optional.ofNullable(appointmentRepository.findAllByEmployeeEntity(employeeEntity));
        return appointmentEntityList.map(appList -> appList.stream()
                .map(AppointmentMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    public AppointmentDTO save(AppointmentDTO appointmentDTO)
    {
        AppointmentEntity a = AppointmentMapper.getInstance().convertFromDTO(appointmentDTO);
        EmployeeEntity employeeEntity = employeeService.findByUsername(appointmentDTO.getEmployeeDTO().getUsername());
        UserEntity userEntity = userService.findByUsername(appointmentDTO.getUserDTO().getUsername());
        a.setEmployeeEntity(employeeEntity);
        a.setUserEntity(userEntity);

        appointmentRepository.save(a);
        logger.info("Add appointment: {}", appointmentDTO.getStartDate());

        return AppointmentMapper.getInstance().convertToDTO(a);
    }

}
