package com.fsoft.repository;

import com.fsoft.entity.Group;
import com.fsoft.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;
    public GroupRepository(){
        hibernateUtils = new HibernateUtils();
    }
    public List<Group> getAllGroup(){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group ");
            return  query.list();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public Group getGroupById(int id){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Group group = session.get(Group.class, id);
            return  group;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public Group getGroupByName(String name){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group WHERE name =: nameParametter");
            query.setParameter("nameParametter", name);
            Group group = query.uniqueResult();
            return  group;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public void createGroup(Group group){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.save(group);
            System.out.println("Create Success !");
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public void updateGroup(Group newGroup){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(newGroup);
            session.getTransaction().commit();
            System.out.println("Update Success !");
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public void groupUpdate(int id, String name, String status){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Group group =  session.get(Group.class, id);
            group.setName(name);
            group.setStatus(status);
            session.getTransaction().commit();
            System.out.println("Update Success !");
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public void deleteGroup(int id){
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Group group =  session.get(Group.class, id);
            session.delete(group);
            session.getTransaction().commit();
            System.out.println("Delete Success !");
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    public boolean isGroupIdExist(int id){
        Group group = getGroupById(id);
        if(group!=null){
            return  true;
        }else
            return false;
    }
    public boolean isGroupNameExist(String name){
        Group group = getGroupByName(name);
        if(group!=null){
            return  true;
        }else
            return false;
    }
}
