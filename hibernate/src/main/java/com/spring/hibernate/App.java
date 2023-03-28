package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        cfg.addAnnotatedClass(Student.class);
        
        //creating cretificate object to explain @EMBEDDABLE
        Certificate ct = new Certificate();
        ct.setCourse("Bachelor of Engineering");
        ct.setDuration("4 years");
        
        //creating a new student object to explain @EMBEDDABLE
        Student st = new Student();
        st.setId(101);
        st.setName("Priyanka");
        st.setCity("Malerkotla");
        st.setCerti(ct);
        
        Student st1 = new Student();
        st1.setId(102);
        st1.setName("Raghav");
        st1.setCity("Ludhiana");
        st1.setCerti(ct);
        
        //same as mentioning the foriegn key
        Answers ans = new Answers();
        ans.setA_id(120);
        ans.setAnswers("Sonia");
                
        Questions qu = new Questions();
        qu.setQ_id(101);
        qu.setQue("What is your mother maiden name");
        qu.setAns(ans);
        ans.setQue(qu);
        
        Answers ans1 = new Answers();
        ans1.setA_id(121);
        ans1.setAnswers("Sita Grammer School");
        
        Questions qu1 = new Questions();
        qu1.setQ_id(102);
        qu1.setQue("what is name of the school you first attended");
        qu1.setAns(ans1);
        ans1.setQue(qu1);
        
        Many2OneAnswer anss = new Many2OneAnswer();
        anss.setA_id(1201);
        anss.setAnswer("I am particularly drawn to ABC because of its reputation as leaders in IT Consulting and IT Services.");
        
        Many2OneAnswer anss1 = new Many2OneAnswer();
        anss1.setA_id(1301);
        anss1.setAnswer("Also, Before applying for this job, I had a short talk with one of the employees of ABC, where I get to known about the culture and growth oppounity.");
        
        Many2OneAnswer anss2 = new Many2OneAnswer();
        anss2.setA_id(1401);
        anss2.setAnswer("Additionally after reading the JD, I knew I will be a great fir for this project/company as the skills and experience asked is completely matched with what I have gained so far.");
        
        One2ManyQuestion ques = new One2ManyQuestion();
        ques.setQ_id(199);
        ques.setQuestion("Why do you want to join this company?");
        List<Many2OneAnswer> lst = new ArrayList<Many2OneAnswer>();
        lst.add(anss);
        lst.add(anss1);
        lst.add(anss2);
        ques.setAnswer(lst);
        anss2.setQuestion(ques);
        anss1.setQuestion(ques);
        anss.setQuestion(ques);
        
        Many2ManyProj proj = new Many2ManyProj();
        proj.setPid(143);
        proj.setProj_name("creating my own website");
        Many2ManyProj proj1 = new Many2ManyProj();
        proj1.setPid(144);
        proj1.setProj_name("Setting up GitHub");
        List<Many2ManyProj> list = new ArrayList<Many2ManyProj>();
        list.add(proj);
        list.add(proj1);
        
        
        Many2ManyEmp emp = new Many2ManyEmp();
        emp.setEid(241);
        emp.setEmp_name("Priyanka");
        Many2ManyEmp emp1 = new Many2ManyEmp();
        emp1.setEid(242);
        emp1.setEmp_name("Jain");
        List<Many2ManyEmp> list1 = new ArrayList<Many2ManyEmp>();
        list1.add(emp);
        list1.add(emp1);
        
        emp.setProjects(list);
        proj1.setEmployees(list1);
        
        XmlPerson person = new XmlPerson();
        person.setId(232);
        person.setName("Priyanka");
        person.setCity("Malerkotla");
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();
        
		//        //saving many2manyemp and many2manyproj
		//        Session session = factory.openSession();
		//        Transaction tx = session.beginTransaction();
		//        session.save(emp);
		//        session.save(emp1);
		//        session.save(proj);
		//        session.save(proj1);
		//        tx.commit();
		//        session.close();
        
		//        //saving both One2ManyQuestiona and Many2OneAnswer
		//        //IT IS NOT NECESSARY TO HAVE MANY2ONE MAPPING IN THE ANSWERS, WE CAN ONLY HAVE ONE2MANY MAPPING IN QUESTIONS. 
		//        //WE ADDED MANY2ONE IN ANSWERS JUST FOR LEARNING PURPOSE
		//        Session session = factory.openSession();
		//        Transaction tx = session.beginTransaction();
		//        session.save(anss);
		//        session.save(anss1);
		//        session.save(anss2);
		//        session.save(ques);
		//        tx.commit();
		//        session.close();
        
        
		//        //saving both questions and answers
		//        Session session = factory.openSession();
		//        Transaction tx = session.beginTransaction();
		//        session.save(qu1);
		//        session.save(ans1);
		//        session.save(qu);
		//        session.save(ans);
		//        tx.commit();
		//        session.close();
		//        factory.close();
        
        
        
		//        //saving the student object in database
		//        Session session = factory.openSession(); //only for the first run
		//        // Session session = factory.getCurrentSession();
		//        Transaction tx = session.beginTransaction();
		//        session.save(st);
		//        session.save(st1);
		//        tx.commit();
		//        
		//        //fetching the student object using primary key
		//        Student priyanka = (Student)session.get(Student.class, 101);
		//        System.out.println(priyanka);
		//        
		//        Student raghav = (Student)session.load(Student.class, 102);
		//        System.out.println(raghav);
		//        
		//        session.close();
    }
}
