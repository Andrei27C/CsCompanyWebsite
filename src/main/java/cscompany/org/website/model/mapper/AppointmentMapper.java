package cscompany.org.website.model.mapper;

import cscompany.org.website.model.AppointmentEntity;
import cscompany.org.website.model.dto.AppointmentDTO;

public class AppointmentMapper implements Mapper<AppointmentEntity, AppointmentDTO>{
    private static AppointmentMapper appointmentMapper = null;

    private AppointmentMapper() { }

    public static AppointmentMapper getInstance() {
        if (appointmentMapper == null) {
            appointmentMapper = new AppointmentMapper();
        }
        return appointmentMapper;
    }

    @Override
    public AppointmentEntity convertFromDTO(AppointmentDTO appointmentDTO) {
        AppointmentEntity appointmentEntity = AppointmentEntity.builder()
                .employeeEntity(null)
                .userEntity(null)
                .startDate(appointmentDTO.getStartDate())
                .build();
        return appointmentEntity;
    }

    @Override
    public AppointmentDTO convertToDTO(AppointmentEntity appointmentEntity) {
        return AppointmentDTO.builder()
                .startDate(appointmentEntity.getStartDate())
                .employeeDTO(EmployeeMapper.getInstance().convertToDTO(appointmentEntity.getEmployeeEntity()))
                .userDTO(UserMapper.getInstance().convertToDTO(appointmentEntity.getUserEntity()))
                .build();
    }
}
