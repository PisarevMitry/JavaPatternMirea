import config.BeanConfig;
import entity.Drummer;
import entity.Guitarist;
import entity.Musician;
import entity.Trombonist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Musician fighter = context.getBean(Drummer.class);
        Musician fighter1 = context.getBean(Guitarist.class);
        Musician fighter2 = context.getBean(Trombonist.class);
        fighter.doCoding();
        fighter1.doCoding();
        fighter2.doCoding();
    }
}
