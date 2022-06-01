package com.fsoft.specification;

import com.fsoft.entity.BookingOffice;

import com.fsoft.entity.Employee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookingOfficeSpecification {
    public static Specification<BookingOffice> buidWhere(String search) {
        Specification<BookingOffice> where = null;

        // search
        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomSpecification name = new CustomSpecification("officeName", search);
            where = Specification.where(name);
        }
        // search
//        if (!StringUtils.isEmpty(search)) {
//            search = search.trim();
//            CustomSpecification name = new CustomSpecification("id", search);
//            where = Specification.where(name);
//        }
        return where;
    }
//        // search
//        if (StringUtils.isEmpty(search)) {
//           return null;
//        }
//        search = search.trim();
//        CustomSpecification name = new CustomSpecification("officeName", search);
//        return Specification.where(name);
//    }
    @RequiredArgsConstructor
    static class CustomSpecification implements Specification<BookingOffice>{
        @NonNull
        private String field;
        @NonNull
        private Object value;

        @Override
        public Predicate toPredicate(Root<BookingOffice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(field.equalsIgnoreCase("officeName")){
                return criteriaBuilder.like(root.get("officeName"), "%" + value.toString() +"%");
            }
//            if(field.equalsIgnoreCase("id")){
//                return criteriaBuilder.equal(root.get("id"), value.toString() );
//            }
            return null;
        }
    }
}
