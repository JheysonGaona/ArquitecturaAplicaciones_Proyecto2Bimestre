package edu.utpl.arquiapp.websocket.handlers;

import edu.utpl.arquiapp.websocket.MainWSocketTeacher;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

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
        System.out.println(message);
        MainWSocketTeacher.broadcastMessage(MainWSocketTeacher.userUsernameMap.get(user), message);
    }
}