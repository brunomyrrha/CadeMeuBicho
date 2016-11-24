package Motor;
public class Animal {

    public String getAnimal (int codigo){
        switch (codigo){
            case 1:
                return "pombo";
            case 2:
                return "gato";
            case 3:
                return "rato";
            case 4:
                return "cao";
            default:
                return "IMAGEM NÃO LOCALIZADA";
        }
            
    }
}
