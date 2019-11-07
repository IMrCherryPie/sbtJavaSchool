public class Person {
    private final String name; // Имя
    private final boolean man;         // Пол
    private Person spouse;   // Супруг


    Person(String name, boolean man) {
        this.name = name;
        this.man = man;
    }

    private boolean divorce() {
        if (this.spouse != null && this.spouse.spouse == null) throw new IllegalStateException();
        if (this.spouse == null) return true;
        else {
            this.spouse.spouse = null;
            this.spouse = null;
            return true;
        }
    }

    boolean marry(Person person) {
        if (this.man == person.man) return false;
        if (this.spouse != null) this.divorce();
        if (person.spouse != null) person.divorce();
        if (this.spouse == null && person.spouse == null) {
            this.spouse = person;
            person.spouse = this;
            return true;
        } else return false;
    }

    public String toString() {
        return (this.spouse == null) ? (name + " |||<Пол: " + ((man) ? "Мужчина" : "Женищина") + "> <Не в браке>|||") : (name + "|||<Пол: " +
                ((man) ? "Мужчина" : "Женщина") + ">" + ((man) ?" <Супруга: " : "<Супруг: ") + this.spouse.name + ">|||");
    }

}
