package day02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Event {
    public String user;
    public String url;
    public Long timestamp;

    public Event() {
    }

    @Override
    public String toString() {
        return "day02.UserEvent{" +
                "user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
