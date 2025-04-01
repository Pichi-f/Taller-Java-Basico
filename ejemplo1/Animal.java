package ejemplo1;

// Clase base
class Animal {
    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("Este animal hace un sonido");
    }
    
    public void Ataque() {
        System.out.println("Ataque");
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}

// Clase derivada
class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    public void hacerSonido() {
        System.out.println( nombre + " dice: ¡Guau!");
    }
}

// Otra clase derivada
class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    public void hacerSonido() {
        System.out.println( nombre + " dice: ¡Miau!");
    }
}