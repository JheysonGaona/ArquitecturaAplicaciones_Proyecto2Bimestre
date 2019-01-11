import edu.utpl.arquiapp.websocket.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.utpl.arquiapp.websocket.util.HibernateUtil;

public class TestData {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setNombreCuestionario("Hola base de datos");
        cuestionario.setNumPreguntasCuestionario(20);
        session.save(cuestionario);
        //Ingresar pregunta
        /*Pregunta pregunta = new Pregunta();
        pregunta.setNom_pregunta("Pregunta funciona");
        session.save(pregunta);*//*
        //ingresar respuesta
        Respuesta respuesta = new Respuesta();
        respuesta.setOpcion_respuesta("Respuesta01");
        respuesta.setVerificacion(1);
        session.save(respuesta);
        //Ingresar resultado
        Resultado resultado = new Resultado();
        resultado.setId_prueba(9);
        resultado.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado);*//*
        //Resultado corta
        Resultado_corta resultado_corta = new Resultado_corta();
        resultado_corta.setId_prueba(9);
        resultado_corta.setId_pregunta(5);
        resultado.setValor(100);
        session.save(resultado_corta);*/
        transaction.commit();
        session.close();
    }
}