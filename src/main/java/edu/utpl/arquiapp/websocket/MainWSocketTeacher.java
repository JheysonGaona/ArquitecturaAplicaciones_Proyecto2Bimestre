package edu.utpl.arquiapp.websocket;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.utpl.arquiapp.websocket.handlers.TeacherWebSocketHandler;
import edu.utpl.arquiapp.websocket.model.*;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.json.JSONArray;

<<<<<<< HEAD
import javax.persistence.TypedQuery;
=======
import java.util.List;
>>>>>>> 825215dfbf0196b533b1ba18f820fedc519de628
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
        webSocket("/Student", TeacherWebSocketHandler.class);
        init();
        consulta2();
    }

    public static void broadcastMessage(String sender, String message) {
        // saveMessage(message);
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(leer(Integer.valueOf(message)));
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