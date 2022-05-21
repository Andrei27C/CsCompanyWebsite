package cscompany.org.website.model.mapper;

import cscompany.org.website.model.DepartmentEntity;
import cscompany.org.website.model.dto.DepartmentDTO;

public class DepartmentMapper implements Mapper<DepartmentEntity, DepartmentDTO> {

    private static DepartmentMapper departmentMapper = null;

    private DepartmentMapper() { }

    public static DepartmentMapper getInstance() {
        if (departmentMapper == null) {
            departmentMapper = new DepartmentMapper();
        }
        return departmentMapper;
    }

    @Override
    public DepartmentEntity convertFromDTO(DepartmentDTO departmentDTO) {
        return DepartmentEntity.builder()
                .departmentName(departmentDTO.getDepartmentName())
                .build();
    }

    @Override
    public DepartmentDTO convertToDTO(DepartmentEntity departmentEntity) {
        return DepartmentDTO.builder()
                .departmentName(departmentEntity.getDepartmentName())
                .build();
    }
}
