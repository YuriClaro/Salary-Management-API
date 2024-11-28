package com.humanit.salary_api.mapper;

import com.humanit.salary_api.dto.SalaryComponentDTO;
import com.humanit.salary_api.model.Salary;
import com.humanit.salary_api.model.SalaryComponent;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T17:47:47-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class SalaryComponentMapperImpl implements SalaryComponentMapper {

    @Override
    public SalaryComponentDTO toDTO(SalaryComponent salaryComponent) {
        if ( salaryComponent == null ) {
            return null;
        }

        SalaryComponentDTO.SalaryComponentDTOBuilder salaryComponentDTO = SalaryComponentDTO.builder();

        salaryComponentDTO.salaryId( salaryComponentSalaryId( salaryComponent ) );
        salaryComponentDTO.id( salaryComponent.getId() );
        salaryComponentDTO.type( salaryComponent.getType() );
        salaryComponentDTO.coverFlex( salaryComponent.getCoverFlex() );
        salaryComponentDTO.value( salaryComponent.getValue() );
        salaryComponentDTO.version( salaryComponent.getVersion() );

        return salaryComponentDTO.build();
    }

    @Override
    public SalaryComponent toEntity(SalaryComponentDTO salaryComponentDTO) {
        if ( salaryComponentDTO == null ) {
            return null;
        }

        SalaryComponent.SalaryComponentBuilder salaryComponent = SalaryComponent.builder();

        salaryComponent.salary( salaryComponentDTOToSalary( salaryComponentDTO ) );
        salaryComponent.id( salaryComponentDTO.getId() );
        salaryComponent.type( salaryComponentDTO.getType() );
        salaryComponent.coverFlex( salaryComponentDTO.getCoverFlex() );
        salaryComponent.value( salaryComponentDTO.getValue() );
        salaryComponent.version( salaryComponentDTO.getVersion() );

        return salaryComponent.build();
    }

    @Override
    public void updateEntityFromDTO(SalaryComponentDTO salaryComponentDTO, SalaryComponent salaryComponent) {
        if ( salaryComponentDTO == null ) {
            return;
        }

        salaryComponent.setId( salaryComponentDTO.getId() );
        salaryComponent.setType( salaryComponentDTO.getType() );
        salaryComponent.setCoverFlex( salaryComponentDTO.getCoverFlex() );
        salaryComponent.setValue( salaryComponentDTO.getValue() );
        salaryComponent.setVersion( salaryComponentDTO.getVersion() );
    }

    private UUID salaryComponentSalaryId(SalaryComponent salaryComponent) {
        if ( salaryComponent == null ) {
            return null;
        }
        Salary salary = salaryComponent.getSalary();
        if ( salary == null ) {
            return null;
        }
        UUID id = salary.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Salary salaryComponentDTOToSalary(SalaryComponentDTO salaryComponentDTO) {
        if ( salaryComponentDTO == null ) {
            return null;
        }

        Salary.SalaryBuilder salary = Salary.builder();

        salary.id( salaryComponentDTO.getSalaryId() );

        return salary.build();
    }
}
