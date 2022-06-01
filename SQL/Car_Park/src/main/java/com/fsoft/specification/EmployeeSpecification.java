package com.fsoft.specification;

import com.fsoft.entity.Employee;
import com.fsoft.form.EmployeeFilter;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeSpecification {
    public static Specification<Employee> buidWhere(String search, EmployeeFilter employeeFilter) {
        Specification<Employee> where = null;

        // search
        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomSpecification name = new CustomSpecification("employeeName", search);
            CustomSpecification birthday = new CustomSpecification("employeeBirthday", search);
            CustomSpecification address = new CustomSpecification("employeeAddress", search);
            CustomSpecification phone = new CustomSpecification("employeePhone", search);
            CustomSpecification department = new CustomSpecification("department", search);
            where = Specification.where(name).or(address).or(phone).or(department);
        }
//
        // filter By MinId
        if (employeeFilter != null && employeeFilter.getMinId() != null) {
            CustomSpecification minId = new CustomSpecification("minId", employeeFilter.getMinId());
            if (where == null) {
                where = minId;
            } else {
                where = where.and(minId);
            }
        }
        // filter By MaxId
        if (employeeFilter != null && employeeFilter.getMaxId() != null) {
            CustomSpecification maxId = new CustomSpecification("maxId", employeeFilter.getMaxId());
            if (where == null) {
                where = maxId;
            } else {
                where = where.and(maxId);
            }
        }

        // filter By MinBirthday
        if (employeeFilter != null && employeeFilter.getMinBirthDay() != null) {
            CustomSpecification minBirthDay = new CustomSpecification("minBirthDay", employeeFilter.getMinBirthDay());
            if (where == null) {
                where = minBirthDay;
            } else {
                where = where.and(minBirthDay);
            }
        }
            // filter By MaxBirthday
            if (employeeFilter != null && employeeFilter.getMaxBirthDay() != null) {
                CustomSpecification maxBirthDay = new CustomSpecification("maxBirthDay", employeeFilter.getMaxBirthDay());
                if (where == null) {
                    where = maxBirthDay;
                } else {
                    where = where.and(maxBirthDay);
                }
            }
        return where;
    }
    @RequiredArgsConstructor
    @Data
    static class CustomSpecification implements Specification<Employee>{
        @NonNull
        private String field;
        @NonNull
        private Object value;
        @Override
        public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(field.equalsIgnoreCase("employeeName")){
                return criteriaBuilder.like(root.get("employeeName"), "%" + value.toString() +"%");
            }

            SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
            if(field.equalsIgnoreCase("employeeBirthday")){
                try {
                    return criteriaBuilder.like((Expression<String>) sdfr.parse(String.valueOf(root.get("employeeBirthday"))), "%" +value.toString() +"%");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            if(field.equalsIgnoreCase("employeeAddress")){
                return criteriaBuilder.like(root.get("employeeAddress"), "%" + value.toString() +"%");
            }
            if(field.equalsIgnoreCase("employeePhone")){
                return criteriaBuilder.like(root.get("employeePhone"), "%" + value.toString() +"%");
            }
            if(field.equalsIgnoreCase("department")){
                return criteriaBuilder.like(root.get("department"), "%" + value.toString() +"%");
            }

            if(field.equalsIgnoreCase("minId")){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString() );
            }

            if(field.equalsIgnoreCase("maxId")){
                return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString() );
            }

            if(field.equalsIgnoreCase("minBirthDay")){
                return criteriaBuilder.lessThanOrEqualTo(root.get("employeeBirthday").as(java.util.Date.class), (Date) value);
            }

            if(field.equalsIgnoreCase("maxBirthDay")){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("employeeBirthday").as(java.util.Date.class), (Date) value);
            }
            return null;
        }
    }
}
