public class Reader {
    
    //Atributos
    private String element;
    private Converter converter;

    //Constructor de la clase
    public Reader(String element, Converter converter){
        this.element = element;
        this.converter = converter;
    }

    //Métodos
    public void parseInput(){
        switch (element) {
            case "LINE":
                converter.makeLine();
                break;
            case "PARAGRAPH":
                converter.makeParagraph();
                break;
            case "TABLE":
                converter.makeTable();
                break;        
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

}
