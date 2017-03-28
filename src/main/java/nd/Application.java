package nd;

import nd.entities.Actor;
import nd.entities.Cast;
import nd.entities.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        //sessionFactory = new Configuration().configure().buildSessionFactory();
        //sessionFactory = new AnnotationConfiguration()
                //.addAnnotatedClass(Video.class)
                //.addAnnotatedClass(Actor.class)
                //.addAnnotatedClass(Cast.class)
                //.configure()
                //.buildSessionFactory();
        sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Video.class).configure().buildSessionFactory();


        Video video = new Video();
        video.setId(123L);
        video.setDescription("the Movie");


        Actor actor = new Actor();
        actor.setName("John Wayne");
        Cast cast = new Cast();
        cast.setVideo(video);
        cast.setActor(actor);



        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(video);
        session.getTransaction().commit();
        session.close();

        //Actor actor1 = (Actor)session.get(Actor.class,new Long(1));
    }
}