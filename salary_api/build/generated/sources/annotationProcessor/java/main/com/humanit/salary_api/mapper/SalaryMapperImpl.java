package com.humanit.salary_api.mapper;

import com.humanit.salary_api.dto.SalaryComponentDTO;
import com.humanit.salary_api.dto.SalaryDTO;
import com.humanit.salary_api.model.Collaborator;
import com.humanit.salary_api.model.Salary;
import com.humanit.salary_api.model.SalaryComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T17:47:47-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class SalaryMapperImpl implements SalaryMapper {

    @Override
    public SalaryDTO toDTO(Salary salary) {
        if ( salary == null ) {
            return null;
        }

        SalaryDTO.SalaryDTOBuilder salaryDTO = SalaryDTO.builder();

        salaryDTO.collaboratorId( salaryCollaboratorId( salary ) );
        salaryDTO.id( salary.getId() );
        salaryDTO.status( salary.getStatus() );
        salaryDTO.salaryComponentList( salaryComponentListToSalaryComponentDTOList( salary.getSalaryComponentList() ) );
        salaryDTO.presentationDate( salary.getPresentationDate() );
        salaryDTO.acceptanceDate( salary.getAcceptanceDate() );
        salaryDTO.effectiveDate( salary.getEffectiveDate() );
        salaryDTO.version( salary.getVersion() );

        return salaryDTO.build();
    }

    @Override
    public Salary toEntity(SalaryDTO salaryDTO) {
        if ( salaryDTO == null ) {
            return null;
        }

        Salary.SalaryBuilder salary = Salary.builder();

        salary.collaborator( salaryDTOToCollaborator( salaryDTO ) );
        salary.id( salaryDTO.getId() );
        salary.status( salaryDTO.getStatus() );
        salary.salaryComponentList( salaryComponentDTOListToSalaryComponentList( salaryDTO.getSalaryComponentList() ) );
        salary.presentationDate( salaryDTO.getPresentationDate() );
        salary.acceptanceDate( salaryDTO.getAcceptanceDate() );
        salary.effectiveDate( salaryDTO.getEffectiveDate() );
        salary.version( salaryDTO.getVersion() );

        return salary.build();
    }

    @Override
    public void updateEntityFromDTO(SalaryDTO salaryDTO, Salary salary) {
        if ( salaryDTO == null ) {
            return;
        }

        salary.setId( salaryDTO.getId() );
        salary.setStatus( salaryDTO.getStatus() );
        if ( salary.getSalaryComponentList() != null ) {
            List<SalaryComponent> list = salaryComponentDTOListToSalaryComponentList( salaryDTO.getSalaryComponentList() );
            if ( list != null ) {
                salary.getSalaryComponentList().clear();
                salary.getSalaryComponentList().addAll( list );
            }
            else {
                salary.setSalaryComponentList( null );
            }
        }
        else {
            List<SalaryComponent> list = salaryComponentDTOListToSalaryComponentList( salaryDTO.getSalaryComponentList() );
            if ( list != null ) {
                salary.setSalaryComponentList( list );
            }
        }
        salary.setPresentationDate( salaryDTO.getPresentationDate() );
        salary.setAcceptanceDate( salaryDTO.getAcceptanceDate() );
        salary.setEffectiveDate( salaryDTO.getEffectiveDate() );
        salary.setVersion( salaryDTO.getVersion() );
    }

    private UUID salaryCollaboratorId(Salary salary) {
        if ( salary == null ) {
            return null;
        }
        Collaborator collaborator = salary.getCollaborator();
        if ( collaborator == null ) {
            return null;
        }
        UUID id = collaborator.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected SalaryComponentDTO salaryComponentToSalaryComponentDTO(SalaryComponent salaryComponent) {
        if ( salaryComponent == null ) {
            return null;
        }

        SalaryComponentDTO.SalaryComponentDTOBuilder salaryComponentDTO = SalaryComponentDTO.builder();

        salaryComponentDTO.id( salaryComponent.getId() );
        salaryComponentDTO.type( salaryComponent.getType() );
        salaryComponentDTO.coverFlex( salaryComponent.getCoverFlex() );
        salaryComponentDTO.value( salaryComponent.getValue() );
        salaryComponentDTO.version( salaryComponent.getVersion() );

        return salaryComponentDTO.build();
    }

    protected List<SalaryComponentDTO> salaryComponentListToSalaryComponentDTOList(List<SalaryComponent> list) {
        if ( list == null ) {
            return null;
        }

        List<SalaryComponentDTO> list1 = new ArrayList<SalaryComponentDTO>( list.size() );
        for ( SalaryComponent salaryComponent : list ) {
            list1.add( salaryComponentToSalaryComponentDTO( salaryComponent ) );
        }

        return list1;
    }

    protected Collaborator salaryDTOToCollaborator(SalaryDTO salaryDTO) {
        if ( salaryDTO == null ) {
            return null;
        }

        Collaborator.CollaboratorBuilder collaborator = Collaborator.builder();

        collaborator.id( salaryDTO.getCollaboratorId() );

        return collaborator.build();
    }

    protected SalaryComponent salaryComponentDTOToSalaryComponent(SalaryComponentDTO salaryComponentDTO) {
        if ( salaryComponentDTO == null ) {
            return null;
        }

        SalaryComponent.SalaryComponentBuilder salaryComponent = SalaryComponent.builder();

        salaryComponent.id( salaryComponentDTO.getId() );
        salaryComponent.type( salaryComponentDTO.getType() );
        salaryComponent.coverFlex( salaryComponentDTO.getCoverFlex() );
        salaryComponent.value( salaryComponentDTO.getValue() );
        salaryComponent.version( salaryComponentDTO.getVersion() );

        return salaryComponent.build();
    }

    protected List<SalaryComponent> salaryComponentDTOListToSalaryComponentList(List<SalaryComponentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SalaryComponent> list1 = new ArrayList<SalaryComponent>( list.size() );
        for ( SalaryComponentDTO salaryComponentDTO : list ) {
            list1.add( salaryComponentDTOToSalaryComponent( salaryComponentDTO ) );
        }

        return list1;
    }
}
