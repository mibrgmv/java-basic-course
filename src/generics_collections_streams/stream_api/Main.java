package generics_collections_streams.stream_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Map<String, Integer> map = new HashMap<>();

        br.lines()
                .map(s -> s.toLowerCase().split("[^a-z0-9а-я]+"))
                .flatMap(Stream::of)
                .forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));

        map.entrySet().stream()
                .sorted((a, b) -> {
                    if (Objects.equals(a.getValue(), b.getValue())) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return b.getValue().compareTo(a.getValue());
                    }
                })
                .map(e -> e.getKey())
                .limit(10)
                .forEach(System.out::println);
    }

    public interface Message<T> {
        String getTo();
        String getFrom();
        T getContent();
    }

    public static class MailMessage implements Message<String> {
        private String from;
        private String to;
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Salary implements Message<Integer> {
        private String from;
        private String to;
        private Integer content;

        public Salary(String from, String to, Integer content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public Integer getContent() {
            return content;
        }
    }

    public static class MailService<T> implements Consumer<Message<T>> {
        private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                List<T> temp = super.get(key);
                if (temp == null) {
                    return Collections.emptyList();
                }
                return temp;
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Message<T> tMessage) {
            String key = tMessage.getTo();
            T val = tMessage.getContent();
            if (mailBox.containsKey(key)) {
                List<T> content = mailBox.get(key);
                content.add(val);
                mailBox.put(key, content);
            } else {
                List<T> content = new ArrayList<>();
                content.add(val);
                mailBox.put(key, content);
            }
        }
    }
}