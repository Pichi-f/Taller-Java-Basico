package ejemplo1;
import ejemplo1.Animal;

public class Ejemplo1 {

    public static void main(String[] args) {
        Animal miAnimal = new Animal("Bicho");
        Animal miPerro = new Perro("Max");
        Animal miGato = new Gato("Luna");

        miAnimal.hacerSonido();  // Este animal hace un sonido
        miPerro.hacerSonido();   // Max dice: ¡Guau!
        miGato.hacerSonido();    // Luna dice: ¡Miau!
    }
    
}