package entity;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Drummer implements Musician {

    @Override
    public void doCoding() {
        System.out.println("Drummer");
    }
}
