package cscompany.org.website.controller;


import cscompany.org.website.model.dto.AppointmentDTO;
import cscompany.org.website.model.dto.UserDTO;
import cscompany.org.website.model.mapper.UserMapper;
import cscompany.org.website.service.AppointmentService;
import cscompany.org.website.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDTO>> getEmployees(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getUserByUsername")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserDTO> getEmployeeByUsername(@Param("username") String username){
        return new ResponseEntity<>(UserMapper.getInstance().convertToDTO(userService.findByUsername(username)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addAppointment")
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody(required = false) AppointmentDTO appointmentDTO) {
        logger.info("Add appointment {}", appointmentDTO);
        return new ResponseEntity<>(appointmentService.save(appointmentDTO), HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerCustomer(@RequestBody(required = false) UserDTO userDTO) {
        logger.info("Customer {} registered", userDTO.getUsername());
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
    }
}
