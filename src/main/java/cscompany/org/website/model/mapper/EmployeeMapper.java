package cscompany.org.website.model.mapper;

import cscompany.org.website.model.EmployeeEntity;
import cscompany.org.website.model.dto.EmployeeDTO;

public class EmployeeMapper implements Mapper<EmployeeEntity, EmployeeDTO> {
    private static EmployeeMapper employeeMapper = null;

    private EmployeeMapper() { }

    public static EmployeeMapper getInstance() {
        if (employeeMapper == null) {
            employeeMapper = new EmployeeMapper();
        }
        return employeeMapper;
    }


    @Override
    public EmployeeEntity convertFromDTO(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO convertToDTO(EmployeeEntity employeeEntity) {
        return EmployeeDTO.EmployeeDTOBuilder()
                .name(employeeEntity.getName())
                .phone(employeeEntity.getPhone())
                .username(employeeEntity.getUsername())
                .password(employeeEntity.getPassword())
                .email(employeeEntity.getEmail())
                .departmentEntity(employeeEntity.getDepartmentEntity())
                .build();
    }
}
