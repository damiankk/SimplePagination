package com.restprojects.services;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;

public abstract class PaginationService {

    public final static int maxResults = 5; //choose number of results displayed on a single page

    public static List<Object> listAllByPage(Integer page, JpaRepository jpaRepository){

        int allRecords = jpaRepository.findAll().size();
        int firstElement = (page * maxResults)+1;
        int lastElement = firstElement + maxResults;
        List<Object> resultSet = new LinkedList<>();

        if((page+1)*maxResults > allRecords){
            System.out.println("Out of range!");
            return null;
        }


        for(Integer i=firstElement;i<lastElement;i++){
            resultSet.add(jpaRepository.findOne(i.toString()));
        }

        return resultSet;
    }





}
