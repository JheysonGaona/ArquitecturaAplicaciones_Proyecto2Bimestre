package edu.utpl.arquiapp.websocket.handlers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.utpl.arquiapp.websocket.MainWSocketTeacher;
import edu.utpl.arquiapp.websocket.model.Quiz;
import edu.utpl.arquiapp.websocket.model.ReadJson;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.hibernate.Transaction;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;

@WebSocket
public class TeacherWebSocketHandler {
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String username = "User" + MainWSocketTeacher.userNumber.incrementAndGet();
        MainWSocketTeacher.userUsernameMap.put(session, username);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        String username = MainWSocketTeacher.userUsernameMap.get(session);
        MainWSocketTeacher.userUsernameMap.remove(session);
        System.out.println("Conexion close");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        MainWSocketTeacher.broadcastMessage(MainWSocketTeacher.userUsernameMap.get(user), message);
    }
}