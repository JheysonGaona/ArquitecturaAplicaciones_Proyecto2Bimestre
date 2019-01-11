package edu.utpl.arquiapp.websocket;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.utpl.arquiapp.websocket.handlers.TeacherWebSocketHandler;
import edu.utpl.arquiapp.websocket.model.*;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.hibernate.Transaction;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.init;
import static spark.Spark.webSocket;

public class MainWSocketTeacher {
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

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

    private static boolean saveMessage(String message){
        boolean correcto = false;
        // obtener la fecha actual
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(message).getAsJsonArray();
            for(JsonElement obj: gsonArr){
                JsonObject gsonObj = obj.getAsJsonObject();
                String nameQuiz = gsonObj.get("nameQuiz").getAsString();
                JsonArray optionMultiple = gsonObj.get("optionMultiple").getAsJsonArray();
                JsonArray optionTrueFalse = gsonObj.get("optionTrueFalse").getAsJsonArray();
                JsonArray optionShortAnswer = gsonObj.get("optionShortAnswer").getAsJsonArray();
                var numAnswQuiz = (optionShortAnswer.size() + optionTrueFalse.size() + optionMultiple.size());
                // Guardando datos del cuestionario en la tabla cuestionario
                Quiz cuestionario = new Quiz();
                cuestionario.setNombreCuestionario(nameQuiz);
                cuestionario.setNumPreguntasCuestionario(numAnswQuiz);
                cuestionario.setFechaCreacionCuestionario(dateFormat.format(date));
                session.save(cuestionario);
                Long idGenerado = ( Long )session.save(cuestionario);

                // leyendo lista del archivo json para enviar a guardar los datos a la tabla optionMultiple
                if(optionMultiple.size() != 0){
                    for(int i = 0; i < optionMultiple.size(); i++){
                        JsonObject gsonObj2 = optionMultiple.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        JsonArray options = gsonObj2.get("options").getAsJsonArray();
                        OptionMultiple ObjOptionMultiple = new OptionMultiple();
                        ObjOptionMultiple.setIdCuestionario(idGenerado.intValue());
                        ObjOptionMultiple.setTextoPregunta(question);
                        session.save(ObjOptionMultiple);
                        Long generadorID = ( Long )session.save(ObjOptionMultiple);
                        for(int j = 0; j < options.size(); j++){
                            JsonObject gsonObj3 = options.get(j).getAsJsonObject();
                            String option = gsonObj3.get("option").getAsString();
                            Boolean answer = gsonObj3.get("answer").getAsBoolean();
                            OptionMultipleOptions ObjOptionMultipleOptions = new OptionMultipleOptions();
                            ObjOptionMultipleOptions.setIdOptionMultiple(generadorID.intValue());
                            ObjOptionMultipleOptions.setTextoOption(option);
                            ObjOptionMultipleOptions.setAnswerOption(answer);
                            session.save(ObjOptionMultipleOptions);
                        }
                    }
                }

                if(optionTrueFalse.size() != 0){
                    for(int i = 0; i < optionTrueFalse.size(); i++){
                        JsonObject gsonObj2 = optionTrueFalse.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        Boolean answer = gsonObj2.get("answer").getAsBoolean();
                        True_False true_false = new True_False();
                        true_false.setIdCuestionario(idGenerado.intValue());
                        true_false.setTextoPregunta(question);
                        true_false.setAnswer(answer);
                        session.save(true_false);
                    }
                }

                if(optionShortAnswer.size() != 0){
                    for(int i = 0; i < optionShortAnswer.size(); i++){
                        JsonObject gsonObj2 = optionShortAnswer.get(i).getAsJsonObject();
                        String question = gsonObj2.get("question").getAsString();
                        ShortAnswer shortAnswer = new ShortAnswer();
                        shortAnswer.setIdCuestionario(idGenerado.intValue());
                        shortAnswer.setTextAnswer(question);
                        session.save(shortAnswer);
                    }
                }

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
