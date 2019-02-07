package edu.utpl.arquiapp.websocket.handlers;

import edu.utpl.arquiapp.websocket.MainWSocketStudent;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class StudentWebSocketHandler {
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String username = "User" + MainWSocketStudent.userNumber.incrementAndGet();
        MainWSocketStudent.userUsernameMap.put(session, username);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        String username = MainWSocketStudent.userUsernameMap.get(session);
        MainWSocketStudent.userUsernameMap.remove(session);
        System.out.println("Conexion close");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        System.out.println(message);
        boolean bandera;
        try{
            Integer.parseInt(message);
            bandera = true;
        }catch (Exception ex){
            bandera = false;
            System.out.println(ex.getMessage());
        }
        if(bandera == true){
            MainWSocketStudent.broadcastMessage(MainWSocketStudent.userUsernameMap.get(user), message);
        }else{
            MainWSocketStudent.saveResults(message);
        }
    }
}