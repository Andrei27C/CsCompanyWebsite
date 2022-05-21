package cscompany.org.website.controller;

import cscompany.org.website.model.AppointmentEntity;
import cscompany.org.website.model.dto.AppointmentDTO;
import cscompany.org.website.model.dto.DepartmentDTO;
import cscompany.org.website.model.dto.EmployeeDTO;
import cscompany.org.website.model.mapper.EmployeeMapper;
import cscompany.org.website.service.AppointmentService;
import cscompany.org.website.service.DepartmentService;
import cscompany.org.website.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getDepartments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.ACCEPTED);
    }

    //todo change return to AppointmentDTO if does not work
    @GetMapping("/getAppointmentsByEmployee")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByEmployee(@RequestBody(required = false) EmployeeDTO employeeDTO){
        System.out.println("Employee DTO -get appointments-" + employeeDTO);
        return new ResponseEntity<>(appointmentService.findByEmployeeId(employeeDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getEmployeeByUsername")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EmployeeDTO> getEmployeeByUsername(@Param("username") String username){
        return new ResponseEntity<>(EmployeeMapper.getInstance().convertToDTO(employeeService.findByUsername(username)), HttpStatus.ACCEPTED);
    }
}
