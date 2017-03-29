package nd;

import nd.entities.Actor;
import nd.entities.Cast;
import nd.entities.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Persistence;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Application.class, args);

        //sessionFactory = new Configuration().configure().buildSessionFactory();
        //sessionFactory = new AnnotationConfiguration()
                //.addAnnotatedClass(Video.class)
                //.addAnnotatedClass(Actor.class)
                //.addAnnotatedClass(Cast.class)
                //.configure().addAnnotatedClass(Video.class)
                //.buildSessionFactory();

        setUp();

        Video video = new Video();
        video.setId(123L);
        video.setDescription("the Movie");


        Actor actor = new Actor();
        actor.setName("John Wayne");
        Cast cast = new Cast();
        cast.setVideo(video);
        cast.setActor(actor);







        Video video1 = new Video(1L,"video1");
        Video video2 = new Video(2L,"video2");
        addVideo(video1);
        addVideo(video2);







        Session session = sessionFactory.openSession();
        session.beginTransaction();
        java.util.List videos = session.createQuery("FROM Video").list();
        session.getTransaction().commit();
        session.close();

        Logger.getAnonymousLogger().info(videos.toString());



    }

    protected static void setUp() throws Exception {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                //.configure( "org/hibernate/example/hibernate.cfg.xml" )
                .configure()
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( Video.class )
                //.addAnnotatedClassName( "org.hibernate.example.Customer" )
                //.addResource( "org/hibernate/example/Order.hbm.xml" )
                //.addResource( "org/hibernate/example/Product.orm.xml" )
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder()
                //.applyBeanManager( getBeanManager() )
                .build();
    }

    public static void addVideo(Video video) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(video);
        session.getTransaction().commit();
        session.close();

    }
}