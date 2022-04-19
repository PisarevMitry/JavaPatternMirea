package entity;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Trombonist implements Musician {

    @Override
    public void doCoding() {
        System.out.println("Trombonist");
    }
}
