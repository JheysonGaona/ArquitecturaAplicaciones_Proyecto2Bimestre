package edu.utpl.arquiapp.websocket;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.utpl.arquiapp.websocket.handlers.TeacherWebSocketHandler;
import edu.utpl.arquiapp.websocket.model.Quiz;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.init;
import static spark.Spark.webSocket;

public class MainWSocketTeacher {
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();
    public static org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    public static Transaction transaction = session.beginTransaction();

    public static void main(String[] args) {
        webSocket("/teacher", TeacherWebSocketHandler.class);
        init();
    }

    public static void broadcastMessage(String sender, String message) {
        var save = saveMessage(message);
        var msm = "";
        if(save == true){
            msm = "Se guardo correctamente el cuestionario";
        }else{
            msm = "Tuvimos problemas al guardar tu cuestionario";
        }
        String finalMsm = msm;
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(finalMsm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean saveMessage(String message){
        boolean correcto = false;
        try{
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(message).getAsJsonArray();

            for(JsonElement obj: gsonArr){

                JsonObject gsonObj = obj.getAsJsonObject();

                String nameQuiz = gsonObj.get("nameQuiz").getAsString();

                JsonArray optionMultiple = gsonObj.get("optionMultiple").getAsJsonArray();
                System.out.println("Nombre del cuestionario: " + nameQuiz); // asdasdad

                if(optionMultiple.size() != 0){
                    for(int i = 0; i < optionMultiple.size(); i++){
                        JsonObject gsonObj2 = optionMultiple.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        System.out.println("pregunta: " + question); //asdadsad
                        JsonArray options = gsonObj2.get("options").getAsJsonArray();
                        for(int j = 0; j < options.size(); j++){
                            JsonObject gsonObj3 = options.get(j).getAsJsonObject();
                            String option = gsonObj3.get("option").getAsString();
                            Boolean answer = gsonObj3.get("answer").getAsBoolean();
                            System.out.println("Opcion: " + option + " respuesta: " + answer); // adsadasd
                        }
                    }
                }

                JsonArray optionTrueFalse = gsonObj.get("optionTrueFalse").getAsJsonArray();
                if(optionTrueFalse.size() != 0){
                    for(int i = 0; i < optionTrueFalse.size(); i++){
                        JsonObject gsonObj2 = optionTrueFalse.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        System.out.println("pregunta: " + question); //asdadsad
                        Boolean answer = gsonObj2.get("answer").getAsBoolean();
                        System.out.println("respuesta: " + answer); // adsadasd
                    }
                }


                JsonArray optionShortAnswer = gsonObj.get("optionShortAnswer").getAsJsonArray();
                if(optionShortAnswer.size() != 0){
                    for(int i = 0; i < optionShortAnswer.size(); i++){
                        JsonObject gsonObj2 = optionShortAnswer.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        System.out.println("Pregunta: " + question);

                    }
                }
                var n = (optionShortAnswer.size() + optionTrueFalse.size() + optionMultiple.size());
                Quiz cuestionario = new Quiz();
                cuestionario.setNombreCuestionario(nameQuiz);
                cuestionario.setNumPreguntasCuestionario(n);
                session.save(cuestionario);
                transaction.commit();
                session.close();
            }
            correcto = true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return correcto;
    }
}
