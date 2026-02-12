package com.simplecoding.simpledmsreact.common;


import com.simplecoding.simpledmsreact.dept.dto.DeptDto;
import com.simplecoding.simpledmsreact.dept.entity.Dept;
import com.simplecoding.simpledmsreact.emp.dto.EmpDto;
import com.simplecoding.simpledmsreact.emp.entity.Emp;
import com.simplecoding.simpledmsreact.filedb.dto.FileDbDto;
import com.simplecoding.simpledmsreact.filedb.entity.FileDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MapStruct {

    DeptDto toDto(Dept dept);
    Dept toEntity(DeptDto deptDto);
    void updateFromDto(DeptDto deptDto, @MappingTarget Dept dept);

    @Mapping(source = "dept.dno", target = "dno")
    EmpDto toDto(Emp emp);
    @Mapping(source = "dno", target = "dept.dno")
    Emp toEntity(EmpDto empDto);
    @Mapping(target = "dept", ignore = true)
    void updateFromDto(EmpDto empDto, @MappingTarget Emp emp);

    FileDbDto toDto(FileDb fileDb);
    FileDb toEntity(FileDbDto fileDbDto);
}
