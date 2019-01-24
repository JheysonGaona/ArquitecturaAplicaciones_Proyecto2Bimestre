package edu.utpl.arquiapp.websocket;
import com.google.gson.Gson;
import edu.utpl.arquiapp.websocket.handlers.TeacherWebSocketHandler;
import edu.utpl.arquiapp.websocket.model.*;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;

import java.util.List;
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
        webSocket("/CreateQuiz", TeacherWebSocketHandler.class);
        init();
        consulta2();
    }

    public static void broadcastMessage(String sender, String message) {
        saveMessage(message);
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString("Hola");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void saveMessage(String message){
        var gson = new Gson();
        var cuestionario = gson.fromJson(message, Quiz.class);
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        session.save(cuestionario);
        transaction.commit();
        session.close();
    }

    public static void consulta2(){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Docente.class);
        cr.setFirstResult(0);
        cr.setMaxResults(10);
        List results = cr.list();
        results.stream().forEach(System.err::println);
        session.close();
    }
}