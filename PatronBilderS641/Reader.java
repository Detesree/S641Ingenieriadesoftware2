public class Reader {
    private String element;
    private Converter converter;

    public Reader(String element, Converter converter){
        this.element = element;
        this.converter = converter;
    }
    //Metodos
    public void parseInput(){
        switch (element) {
            case "LINE":
            converter.makeLine();
                
                break;
            case "PARAGRAPH":
            converter.makeParagraph();
            case "TABLE":
            
                
        
            default:
                break;
        }
    }
}
