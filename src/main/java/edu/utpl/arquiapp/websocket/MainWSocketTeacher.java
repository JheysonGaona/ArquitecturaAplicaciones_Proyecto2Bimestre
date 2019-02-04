package edu.utpl.arquiapp.websocket;
import com.google.gson.Gson;
import edu.utpl.arquiapp.websocket.handlers.TeacherWebSocketHandler;
import edu.utpl.arquiapp.websocket.model.*;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.init;
import static spark.Spark.webSocket;

public class MainWSocketTeacher {

    public static org.hibernate.Session session;
    public static Transaction transaction;
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String[] args) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        webSocket("/CreateTeacher", TeacherWebSocketHandler.class);
        init();
    }

    public static void broadcastMessage(String sender, String message) {
        saveTeacher(message);
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
              //session.getRemote().sendString(leer(Integer.valueOf(message)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static  String leer(int id){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        String query = "FROM Quiz WHERE idQuiz = " + id;
        String json = "";
        try{
            TypedQuery<Quiz> myQuery = session.createQuery(query, Quiz.class);
            Gson gson = new Gson();
            json = gson.toJson(myQuery.getSingleResult());
            System.out.println(json);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        session.close();
        return json;
    }

    private static void saveMessage(String message){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        var gson = new Gson();
        var cuestionario = gson.fromJson(message, Quiz.class);
        transaction = session.beginTransaction();
        session.save(cuestionario);
        transaction.commit();
        session.close();
    }

    private static void saveTeacher(String message){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        var gson = new Gson();
        var docente = gson.fromJson(message, Teacher.class);
        transaction = session.beginTransaction();
        session.save(docente);
        transaction.commit();
        session.close();
    }
}