//ebben lesz az adatbazisom dolgai

package com.todo.repository;

import com.todo.entity.Todo;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TodoRepository {

    @PersistenceContext      //ezen keresztul erem el az adatbazist
    private EntityManager entityManager;

    public void save(Todo todo){
        entityManager.persist(todo);    //ez menti azokat amit beirtam..szoval ez az osztalyt menti(nem konkretan azokat amiet beirtam..azokat az osztalyon keresztul menti)
    }

    public void delete(Todo todo){
        entityManager.remove(todo);     //ez torli
    }

    public Todo findById(int id){   // ez_todo tipusu
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> findAll(){      //az osszes peldanyt megkeresem

        return entityManager.createQuery("SELECT t FROM "+Todo.class.getSimpleName()+" t").getResultList();       //Select * from todo

    }





}
