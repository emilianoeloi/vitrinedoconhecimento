/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.todo.stories.passos;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.persistence.dao.MentorTeacherDAO;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Roseane Costa
 */
public class PassosStory01 {
    
   MentorTeacher mentorTeacher;
   MentorTeacherDAO  mentorTeacherDAO;
   CollegeClass collegeClass;
   AssociationException associationException;
    
    @Given("desejo associar <professor-orientador> a turma")    
    public void getIdMentorTeacher(@Named("<professor-orientador>") Long id){
         mentorTeacher = new MentorTeacher();
         mentorTeacher.setId(id);
     }
   
    @When("seleciono a <turma> e clico em salvar")
     public void getIdCollegeClass(@Named("<turma>") Long id){
         collegeClass = new CollegeClass();
         collegeClass.setId(id);
     }
    
    @Then("exibe a seguinte mensagem <mensagem>")  //verificar
      public void MentorTeacherDAO(String mensagem) throws AssociationException{
          mentorTeacherDAO.associateTeacherToClass(mentorTeacher, collegeClass);
          Assert.assertEquals(mensagem, mentorTeacherDAO.toString());
                  
                  
        
    }
}


