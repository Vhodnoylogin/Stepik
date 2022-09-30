package study.java_lessons.lesson_6_4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        most10Words(System.in, System.out);
    }

    public static void most10Words(InputStream in, OutputStream out) throws IOException {
//        Scanner sc = new Scanner(in)
//                .useLocale(Locale.ENGLISH)
//                .useDelimiter("| |,|.");
//        Stream.generate(sc::next)
        HashMap<String, Integer> map =
                new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                        .lines()
//                        .peek(logger::info)
                        .flatMap(x -> Arrays.stream(x.split("[\\p{Punct}\\s]+")))
//                        .peek(logger::info)
                        .collect(Collectors.toMap(
                                String::toLowerCase
                                , x -> 1
                                , Integer::sum
                                , HashMap::new
                        ));
        String res = map.entrySet().stream()
                .sorted((x, y) -> {
                    if (x == null) return -1;
                    if (y == null) return 1;
                    if (Objects.equals(x, y)) return 0;
                    if (Objects.equals(x.getValue(), y.getValue())) return x.getKey().compareTo(y.getKey());
                    return y.getValue().compareTo(x.getValue());
                })
                .limit(10)
                .filter(Objects::nonNull)
                .map(Map.Entry::getKey)
//                .map(String::getBytes)
                .collect(Collectors.joining("\n"));
//                .forEach(x -> {
//                    try {
//                        out.write(x);
//                        out.write("\n".getBytes());
//                    } catch (IOException ignored) {
//                    }
//                });
        out.write(res.getBytes(StandardCharsets.UTF_8));
    }
}
