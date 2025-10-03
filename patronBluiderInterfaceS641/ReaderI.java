public class ReaderI {
    private String element;
    private Converter converter;

    public ReaderI(String element, Converter converter) {
        this.element = element;
        this.converter = converter;
    }

    //Métodos
    public void parseInput() {
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
