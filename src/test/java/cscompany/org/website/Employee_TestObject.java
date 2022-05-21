package cscompany.org.website;

import cscompany.org.website.model.AppointmentEntity;
import cscompany.org.website.model.DepartmentEntity;
import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.UserEntity;
import cscompany.org.website.model.dto.UserDataDTO;
import org.junit.Test;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee_TestObject {

    public UserDataDTO createTest_UserDataDTO() {
        return UserDataDTO.builder()
                .email("cs@gmail.com")
                .name("Cs Andrei")
                .password("cs")
                .username("cs")
                .phone("0721626348")
                .build();
    }

    public DepartmentEntity createTest_Departments(){
        return new DepartmentEntity(1,"department1");
    }

    public EmployeeEntity createTest_Employee() {
        UserDataDTO userDataDTO = createTest_UserDataDTO();
        EmployeeEntity employeeEntity = EmployeeEntity.EmployeeBuilder()
                .email(userDataDTO.getEmail())
                .name(userDataDTO.getName())
                .password(userDataDTO.getPassword())
                .username(userDataDTO.getUsername())
                .phone(userDataDTO.getPhone())
                .departmentEntity(createTest_Departments())
                .build();
        employeeEntity.setIdUserData(1);
        return employeeEntity;
    }

    public UserEntity createTest_User() {
        UserDataDTO userDataDTO = createTest_UserDataDTO();
        UserEntity userEntity = UserEntity.UserEntityBuilder()
                .email(userDataDTO.getEmail())
                .name(userDataDTO.getName())
                .password(userDataDTO.getPassword())
                .username(userDataDTO.getUsername())
                .phone(userDataDTO.getPhone())
                .build();
        userEntity.setIdUserData(1);
        return userEntity;
    }

    public Date stringToDate(String dateString)
    {
        return Date.valueOf(dateString);
    }

    @Test
    public void createTest_Appointment() {
        AppointmentEntity appointmentEntity = AppointmentEntity.builder()
                .idAppointment(1)
                .employeeEntity(createTest_Employee())
                .userEntity(createTest_User())
                .startDate(stringToDate("2022-05-16"))
                .build();
        //return employeeEntity;
    }



}
