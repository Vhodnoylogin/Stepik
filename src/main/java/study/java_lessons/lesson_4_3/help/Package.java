package study.java_lessons.lesson_4_3.help;

/*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
public record Package(String content, int price) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (price != aPackage.price) return false;
        return content.equals(aPackage.content);
    }
}
